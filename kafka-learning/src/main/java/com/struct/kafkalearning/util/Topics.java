package com.struct.kafkalearning.util;

public final class Topics {

    private Topics() {
    }

    public static final String TOPIC_DEMO = "kafka.learning.demo";
    public static final String TOPIC_DEMO_DLT = "kafka.learning.demo.dlt";

    public static final int PARTITIONS = 3;
    public static final short REPLICATION_FACTOR = 1;
}
