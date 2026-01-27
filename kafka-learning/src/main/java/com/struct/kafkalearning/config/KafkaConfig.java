package com.struct.kafkalearning.config;

import java.time.Duration;
import java.util.Map;

public final class KafkaConfig {

    private KafkaConfig() {
    }

    public static String bootstrapServers() {
        String v = System.getenv("KAFKA_BOOTSTRAP_SERVERS");
        return (v == null || v.isBlank()) ? "localhost:9092" : v;
    }

    public static String consumerGroupId() {
        String v = System.getenv("KAFKA_GROUP_ID");
        return (v == null || v.isBlank()) ? "kafka-learning-group" : v;
    }

    public static Duration pollTimeout() {
        return Duration.ofSeconds(1);
    }

    public static Map<String, Object> commonClientProps() {
        return Map.of(
                "bootstrap.servers", bootstrapServers(),
                "client.id", "kafka-learning-client"
        );
    }
}
