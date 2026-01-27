package com.struct.kafkalearning.consumer;

import java.time.Instant;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import com.struct.kafkalearning.config.KafkaConfig;
import com.struct.kafkalearning.util.TopicAdmin;
import com.struct.kafkalearning.util.Topics;

public final class ManualCommitConsumerDemo {

    private ManualCommitConsumerDemo() {
    }

    public static void run() {
        TopicAdmin.ensureTopics();

        Properties props = new Properties();
        props.putAll(KafkaConfig.commonClientProps());

        props.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConfig.consumerGroupId());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "50");

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumer.subscribe(Collections.singletonList(Topics.TOPIC_DEMO));
            System.out.println("consumer started, groupId=" + KafkaConfig.consumerGroupId());

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(KafkaConfig.pollTimeout());
                if (records.isEmpty()) {
                    continue;
                }

                for (ConsumerRecord<String, String> r : records) {
                    System.out.printf("recv topic=%s partition=%d offset=%d key=%s value=%s ts=%s%n",
                            r.topic(), r.partition(), r.offset(), r.key(), r.value(), Instant.ofEpochMilli(r.timestamp()));
                }

                consumer.commitSync();
            }
        }
    }
}
