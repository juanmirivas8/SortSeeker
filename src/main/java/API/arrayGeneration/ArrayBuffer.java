package API.arrayGeneration;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBuffer {
    private ArrayBlockingQueue<int[]> buffer;

    public ArrayBuffer(int size) {
        buffer = new ArrayBlockingQueue<>(size);
    }

    public void put(int[] array) {
        try {
            buffer.put(array);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int[] take() {
        try {
            return buffer.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean isEmpty(){
        return buffer.isEmpty();
    }
}
