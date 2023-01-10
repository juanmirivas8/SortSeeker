package API.arrayGeneration;

import API.CPUExecutor;
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
            while (isRunning){
                if (actualSize <= requestData.getMaxElements()){
                    int[] array = randomArrayGenerator.generateRandomArray(actualSize, 0, 100);
                    buffer.put(array);
                    actualSize += requestData.getStep();
                } else {
                    stopProducing();
                }
            }
        });
    }

    public void stopProducing(){
        isRunning = false;
    }

    public Boolean getRunning() {
        return isRunning;
    }
}
