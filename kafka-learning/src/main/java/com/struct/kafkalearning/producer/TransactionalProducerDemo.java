package com.struct.kafkalearning.producer;

import java.time.Instant;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.struct.kafkalearning.config.KafkaConfig;
import com.struct.kafkalearning.util.TopicAdmin;
import com.struct.kafkalearning.util.Topics;

public final class TransactionalProducerDemo {

    private TransactionalProducerDemo() {
    }

    public static void run() {
        TopicAdmin.ensureTopics();

        Properties props = new Properties();
        props.putAll(KafkaConfig.commonClientProps());

        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
        props.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "kafka-learning-tx-" + System.currentTimeMillis());

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
            producer.initTransactions();

            producer.beginTransaction();
            for (int i = 0; i < 5; i++) {
                ProducerRecord<String, String> record = new ProducerRecord<>(Topics.TOPIC_DEMO, "tx", "tx-msg=" + i + ", ts=" + Instant.now());
                producer.send(record);
            }
            producer.commitTransaction();

            System.out.println("transaction committed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
