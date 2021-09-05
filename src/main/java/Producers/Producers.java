package Producers;


import Model.UserInput;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;

    public class Producers {
        public static void main(String[] args){
            // For example 192.168.1.1:9092,192.168.1.2:9092


            Properties properties = new Properties();
            properties.put("bootstrap.servers", "localhost:9092");
            properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

            Random random=new Random();
            int minAge=18;
            int maxAge=28;
            int age;

            KafkaProducer kafkaProducer = new KafkaProducer(properties);
            try{
                for(int i = 0; i < 6; i++){
                    age= random.nextInt((maxAge-minAge)+1)+minAge;
                    UserInput user= new UserInput(i," SHIVAM ROY",age,"B.Tech");
                    String tmp= ("{\"Id\":"+"\""+Integer.toString(user.getId())+"\","+"\"Name\":"+"\""+user.getName()+"\","+"\"Age\":"+"\""+Integer.toString(user.getAge())+"\","+"\"Course\":"+"\""+user.getCourse()+"\"}");
                    System.out.println(tmp);
                    kafkaProducer.send(new ProducerRecord("user",tmp));
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                kafkaProducer.close();
            }
        }
    }


