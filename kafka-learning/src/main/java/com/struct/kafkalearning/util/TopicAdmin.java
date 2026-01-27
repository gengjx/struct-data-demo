package com.struct.kafkalearning.util;

import com.struct.kafkalearning.config.KafkaConfig;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.List;
import java.util.Properties;

public final class TopicAdmin {

    private TopicAdmin() {
    }

    public static void ensureTopics() {
        Properties props = new Properties();
        props.putAll(KafkaConfig.commonClientProps());

        try (AdminClient adminClient = AdminClient.create(props)) {
            List<NewTopic> topics = List.of(
                    new NewTopic(Topics.TOPIC_DEMO, Topics.PARTITIONS, Topics.REPLICATION_FACTOR),
                    new NewTopic(Topics.TOPIC_DEMO_DLT, Topics.PARTITIONS, Topics.REPLICATION_FACTOR)
            );
            adminClient.createTopics(topics).all().get();
        } catch (Exception e) {
            throw new RuntimeException("Failed to ensure topics", e);
        }
    }
}
