package com.struct.kafkalearning.consumer;

import java.time.Instant;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import com.struct.kafkalearning.config.KafkaConfig;
import com.struct.kafkalearning.util.TopicAdmin;
import com.struct.kafkalearning.util.Topics;

public final class RetryToDltConsumerDemo {

    private RetryToDltConsumerDemo() {
    }

    public static void run() {
        TopicAdmin.ensureTopics();

        Properties consumerProps = new Properties();
        consumerProps.putAll(KafkaConfig.commonClientProps());
        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConfig.consumerGroupId() + "-dlt");
        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        Properties producerProps = new Properties();
        producerProps.putAll(KafkaConfig.commonClientProps());
        producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerProps.put(ProducerConfig.ACKS_CONFIG, "all");
        producerProps.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProps);
             KafkaProducer<String, String> producer = new KafkaProducer<>(producerProps)) {

            consumer.subscribe(Collections.singletonList(Topics.TOPIC_DEMO));
            System.out.println("consumer-dlt started, groupId=" + consumerProps.getProperty(ConsumerConfig.GROUP_ID_CONFIG));

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(KafkaConfig.pollTimeout());
                if (records.isEmpty()) {
                    continue;
                }

                for (ConsumerRecord<String, String> r : records) {
                    boolean ok = handleWithRetry(r, 3);
                    if (!ok) {
                        String dltValue = "originalTopic=" + r.topic() + ", partition=" + r.partition() + ", offset=" + r.offset() + ", key=" + r.key() + ", value=" + r.value();
                        producer.send(new ProducerRecord<>(Topics.TOPIC_DEMO_DLT, r.key(), dltValue)).get();
                        System.out.printf("sent to dlt topic=%s key=%s at %s%n", Topics.TOPIC_DEMO_DLT, r.key(), Instant.now());
                    }
                }

                consumer.commitSync();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean handleWithRetry(ConsumerRecord<String, String> r, int maxAttempts) {
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                if (r.value() != null && r.value().contains("FAIL")) {
                    throw new IllegalStateException("simulated failure by payload containing FAIL");
                }

                System.out.printf("processed topic=%s partition=%d offset=%d key=%s value=%s attempt=%d%n",
                        r.topic(), r.partition(), r.offset(), r.key(), r.value(), attempt);
                return true;
            } catch (Exception ex) {
                System.out.printf("process failed key=%s attempt=%d err=%s%n", r.key(), attempt, ex.getMessage());
                try {
                    Thread.sleep(200L * attempt);
                } catch (InterruptedException ignored) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
        }
        return false;
    }
}
