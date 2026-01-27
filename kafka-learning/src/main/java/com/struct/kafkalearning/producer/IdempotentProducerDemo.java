package com.struct.kafkalearning.producer;

import java.time.Instant;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import com.struct.kafkalearning.config.KafkaConfig;
import com.struct.kafkalearning.util.TopicAdmin;
import com.struct.kafkalearning.util.Topics;

public final class IdempotentProducerDemo {

    private IdempotentProducerDemo() {
    }

    public static void run() {
        TopicAdmin.ensureTopics();

        Properties props = new Properties();
        props.putAll(KafkaConfig.commonClientProps());

        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
        props.put(ProducerConfig.RETRIES_CONFIG, Integer.toString(Integer.MAX_VALUE));
        props.put(ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, "120000");

        props.put(ProducerConfig.LINGER_MS_CONFIG, "10");
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, Integer.toString(32 * 1024));
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "lz4");

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
            for (int i = 0; i < 10; i++) {
                String key = "user-" + (i % 3);
                String value = "msg=" + i + ", ts=" + Instant.now();
                ProducerRecord<String, String> record = new ProducerRecord<>(Topics.TOPIC_DEMO, key, value);
                RecordMetadata md = producer.send(record).get();
                System.out.printf("sent key=%s topic=%s partition=%d offset=%d at %s%n",
                        key, md.topic(), md.partition(), md.offset(), Instant.ofEpochMilli(md.timestamp()));
            }
            producer.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
