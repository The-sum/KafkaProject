package the.sum.kafka.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

public class CustomConsumer {
    public static void main(String[] args) {
        // 0 配置消费者
        Properties properties = new Properties();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"hadoop102:9092");

        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"test");

        // 1 创建一个消费者
        KafkaConsumer<String, String> KafkaConsumer = new KafkaConsumer<>(properties);

        // 2 订阅一个主题
        ArrayList<String> topic = new ArrayList<>();
        topic.add("first");
        KafkaConsumer.subscribe(topic);

        // 3 接收消息
        while (true){
            ConsumerRecords<String, String> poll = KafkaConsumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord<String, String> stringStringConsumerRecord : poll) {
                System.out.println(stringStringConsumerRecord);
            }
        }
    }
}
