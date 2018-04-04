package org.learn.producers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.learn.util.Constants;
import org.learn.util.KafkaFutureResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class KafkaProducerAsync {
        private String topic=null;
        private Properties properties=null;
        private Producer<String, String> producer=null;

        public KafkaProducerAsync(String topic) throws IOException {
            this.topic=topic;
            properties = new Properties();
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            this.properties.load(new FileInputStream(classLoader.getResource(Constants.KAFKA_PROPERTIES_FILE).getFile()));
            this.producer = new KafkaProducer<>(properties);
        }
        public void produceWithOnlyValue(String value){
            ProducerRecord record=new ProducerRecord<String, String>(topic,value);
            producer.send(record, new KafkaFutureResponse());
        }
        public void produceWithKeyValue(String key,String value) {
            ProducerRecord record = new ProducerRecord<String, String>(topic, key, value);
            producer.send(record, new KafkaFutureResponse());
        }
        public void closeProducer(){
            producer.close();
        }
}
