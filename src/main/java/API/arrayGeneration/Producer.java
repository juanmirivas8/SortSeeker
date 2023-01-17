package API.arrayGeneration;

import API.CPUExecutor;
import API.arraySorting.HandleRequest;
import API.model.RequestData;

import java.util.concurrent.ExecutorService;

public class Producer {

    private final ArrayBuffer buffer;
    private Boolean isRunning;

    private final RequestData requestData;

    private final RandomArrayGenerator randomArrayGenerator;
    private final ExecutorService executorService;

    public Producer(ArrayBuffer buffer, RequestData request) {
        this.buffer = buffer;
        this.isRunning = true;
        this.requestData = request;
        this.randomArrayGenerator = new RandomArrayGenerator();
        this.executorService = CPUExecutor.getInstance().getExecutor();
    }

    public void startProducing(){
        executorService.execute(()->{
            Integer actualSize = requestData.getMinElements();
            System.out.println("Producer started");
            while (isRunning){
                if (actualSize <= requestData.getMaxElements()){
                    int[] array = randomArrayGenerator.generateRandomArray(actualSize, 0, 100);
                    buffer.put(array);
                    System.out.println("Produced array of size: " + array.length);
                    actualSize += requestData.getStep();
                } else {
                    stopProducing();
                }
            }
            System.out.println("Producer stopped");
        });
    }

    public void stopProducing(){
        isRunning = false;
    }

    public Boolean getRunning() {
        return isRunning;
    }
}
