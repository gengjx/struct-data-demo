package com.struct.kafkalearning;

import com.struct.kafkalearning.consumer.ManualCommitConsumerDemo;
import com.struct.kafkalearning.consumer.RetryToDltConsumerDemo;
import com.struct.kafkalearning.producer.IdempotentProducerDemo;
import com.struct.kafkalearning.producer.TransactionalProducerDemo;

public class KafkaLearningApp {

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            printUsage();
            return;
        }

        String command = args[0];
        switch (command) {
            case "produce":
                IdempotentProducerDemo.run();
                break;
            case "consume":
                ManualCommitConsumerDemo.run();
                break;
            case "consume-dlt":
                RetryToDltConsumerDemo.run();
                break;
            case "tx":
                TransactionalProducerDemo.run();
                break;
            default:
                printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Usage: mvn -pl kafka-learning -Dexec.args=<command> exec:java");
        System.out.println("Commands:");
        System.out.println("  produce      - Idempotent producer demo");
        System.out.println("  consume      - Manual commit consumer demo");
        System.out.println("  consume-dlt  - Retry then send to DLT demo");
        System.out.println("  tx           - Transactional producer demo");
    }
}
