package API.algorithms;

import API.model.Algorithm;
import API.model.RequestData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Generator {
    private ExecutorService executorService;
    private int avaliableProcessors;

    public Generator() {
        avaliableProcessors = Runtime.getRuntime().availableProcessors();
        executorService = Executors.newFixedThreadPool(avaliableProcessors);
    }

    public int[] generateRandomArraySingleThread(int size, int min, int max) {
        int[] array = new int[size];
        fillArray(array, 0, size - 1, min, max);
        return array;
    }

    public int[] generateRandomArrayMultiThread(int size, int min, int max) {
        CountDownLatch countDownLatch = new CountDownLatch(avaliableProcessors);
        int[] array = new int[size];
        int chunkSize = size / avaliableProcessors;
        for (int i = 0; i < avaliableProcessors; i++) {
            final int startIndex = i * chunkSize;
            final int endIndex = (i + 1) * chunkSize;
            int finalI = i;
            executorService.execute(() -> {
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



    private void fillArray(int[] array, int startIndex, int endIndex, int min, int max) {
        for (int i = startIndex; i <= endIndex; i++) {
            array[i] = (int) (Math.random() * (max - min + 1) + min);
        }
    }

    public int[][] generateCopiesSingleThread(int[] array, int copies) {
        int[][] copiesArray = new int[copies][array.length];
        for (int i = 0; i < copies; i++) {
            System.arraycopy(array, 0, copiesArray[i], 0, array.length);
        }
        return copiesArray;
    }

}
