package org.learn.util;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class KafkaFutureResponse implements Callback {
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if(e!=null){
            //ToDo implement log
            e.printStackTrace();
        }
    }
}
