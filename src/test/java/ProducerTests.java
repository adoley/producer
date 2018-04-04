import org.junit.Test;
import org.learn.producers.KafkaProducerAsync;

public class ProducerTests {
    @Test
    public void kafkaProducerTest()  {
        try {
            KafkaProducerAsync kafkaProducerAsync = new KafkaProducerAsync("test1");
            for (int i = 0; i < 10; i++) {
                kafkaProducerAsync.produceWithOnlyValue("hello " + i);
            }
            kafkaProducerAsync.closeProducer();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
