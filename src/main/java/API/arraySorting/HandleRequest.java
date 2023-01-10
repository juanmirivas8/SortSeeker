package API.arraySorting;

import API.CPUExecutor;
import API.arrayGeneration.ArrayBuffer;
import API.arrayGeneration.Producer;
import API.model.RequestData;
import API.model.RequestResult;
import API.model.Result;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class HandleRequest implements Callable<List<Result>> {
    private final RequestData requestData;
    private final ArrayBuffer arrayBuffer;
    private final Producer producer;

    private final ExecutorService executorService;

    public HandleRequest(RequestData request){
        this.requestData = request;
        this.arrayBuffer = new ArrayBuffer(20);
        this.producer = new Producer(arrayBuffer,request);
        this.executorService = CPUExecutor.getInstance().getExecutor();
    }

    @Override
    public List<Result> call() {return sortSingleThreaded(); }

    private List<Result> sortSingleThreaded() {
        List<Result> results = new ArrayList<>();
        RequestResult requestResult = new RequestResult(requestData);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        producer.startProducing();

        while (producer.getRunning()||!arrayBuffer.isEmpty()){
            int[] array = arrayBuffer.take();
            Future<Long> time = executorService.submit(()->{
                Long initialTime = threadMXBean.getCurrentThreadCpuTime();
                executeSort(array);
                Long finalTime = threadMXBean.getCurrentThreadCpuTime();
                return finalTime - initialTime;
            });
            try {
                Long timeElapsed = time.get();
                Result r = new Result(array.length, timeElapsed, requestData.getAlgorithm());
                results.add(r);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return results;
    }
    private void executeSort(int[] array){
        switch (requestData.getAlgorithm()) {
            case BUBBLE_SORT -> Sort.bubbleSort(array);
            case INSERTION_SORT -> Sort.insertionSort(array);
            case MERGE_SORT -> Sort.mergeSort(array);
            case QUICK_SORT -> Sort.quickSort(array);
            case SELECTION_SORT -> Sort.selectionSort(array);
        }
    }
}
