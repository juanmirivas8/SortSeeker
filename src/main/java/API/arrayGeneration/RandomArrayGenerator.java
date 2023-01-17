package API.arrayGeneration;

import API.CPUExecutor;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public class RandomArrayGenerator {
    private ExecutorService executorService;
    private int avaliableProcessors;

    public RandomArrayGenerator() {
        CPUExecutor cpuExecutor = CPUExecutor.getInstance();
        avaliableProcessors = cpuExecutor.getAvaliableProcessors();
        executorService = cpuExecutor.getExecutor();
    }

    public int[] generateRandomArray(int size, int min, int max) {
        CountDownLatch countDownLatch = new CountDownLatch(avaliableProcessors);
        int[] array = new int[size];
        int chunkSize = size / avaliableProcessors;
        //Random object for all tasks
        //Random random = new Random();
        for (int i = 0; i < avaliableProcessors; i++) {
            final int startIndex = i * chunkSize;
            final int endIndex = (i + 1) * chunkSize;
            int finalI = i;

            executorService.execute(() -> {
                //Random object in every task
                Random random = new Random();
                if (finalI == avaliableProcessors - 1) {
                    for(int j = startIndex; j < array.length; j++) {
                        array[j] = random.nextInt(max - min + 1) + min;
                    }
                } else {
                    for(int j = startIndex; j <= endIndex; j++) {
                        array[j] = random.nextInt(max - min + 1) + min;
                    }
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return array;
    }

}
