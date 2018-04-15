package org.learn.util;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;

public class KafkaFutureResponse implements Callback {
    final static Logger logger = Logger.getLogger(KafkaFutureResponse.class);
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if(e!=null){
            logger.error(e);
        }
    }
}
