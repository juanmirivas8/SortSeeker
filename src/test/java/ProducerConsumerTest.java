import API.arrayGeneration.ArrayBuffer;
import API.arrayGeneration.Producer;
import API.model.Algorithm;
import API.model.RequestData;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ProducerConsumerTest {

    @Test
    public void test() throws InterruptedException {
        RequestData requestData = new RequestData(1, 40, 2, Algorithm.BUBBLE_SORT, LocalDateTime.now());
        ArrayBuffer buffer = new ArrayBuffer(10);
        Producer producer = new Producer(buffer,requestData);
        producer.startProducing();

        while (producer.getRunning()||!buffer.isEmpty()){
            Thread.sleep(1000);
            System.out.println(buffer.take().length);
        }
    }
}
