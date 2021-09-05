package Consumers;

import Model.UserInput;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

    public class Consumers {

        public static void main(String[] args) {
            ListenConsumers listen = new ListenConsumers();
            Thread thread = new Thread(listen);
            thread.start();
        }
        public static void consumer() {
            Properties properties = new Properties();
            properties.put("bootstrap.servers", "localhost:9092");
            properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            properties.put("group.id", "test-group");

            KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
            String topics = "user";
            kafkaConsumer.subscribe(Arrays.asList(topics));
            try{
                // Message1
                while (true){
                    ConsumerRecords<String,String> records = kafkaConsumer.poll(10000);
                    for (ConsumerRecord record: records){
                        System.out.println(record.value());

                        BufferedWriter buffer = new BufferedWriter(new FileWriter("result.txt", true));
                        buffer.write(record.value().toString()+"\n"); // this code will write the user records in records.txt file.
                        buffer.close();
                    }
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                kafkaConsumer.close();
            }
        }
    }

    class ConsumerListener implements Runnable {


        @Override
        public void run() {
            Consumers.consumer();
        }


    }
