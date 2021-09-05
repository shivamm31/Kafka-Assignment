package Consumers;



import Model.UserInput;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

class ListenConsumers implements Runnable {


        @Override
        public void run() {
            Consumers.consumer();
        }
    }

