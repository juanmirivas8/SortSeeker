package API;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CPUExecutor {
    private static CPUExecutor instance = null;
    private ExecutorService executor;
    private int avaliableProcessors;

    private CPUExecutor() {
        avaliableProcessors = Runtime.getRuntime().availableProcessors();
        executor = Executors.newFixedThreadPool(avaliableProcessors);
    }

    public static CPUExecutor getInstance() {
        if (instance == null) {
            instance = new CPUExecutor();
        }
        return instance;
    }

    public int getAvaliableProcessors() {
        return avaliableProcessors;
    }

    public ExecutorService getExecutor() {
        return executor;
    }
}
