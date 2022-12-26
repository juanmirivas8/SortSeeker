import API.algorithms.Generator;
import API.algorithms.Sort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlgorithmsTest {
    private Generator generator = new Generator();

    @Test
    public void generateRandomArraySingleThread() {
        int [] array = generator.generateRandomArraySingleThread(100000000, 1, 100);
    }

    @Test
    public void generateRandomArrayMultiThread() throws InterruptedException {
        int [] array = generator.generateRandomArrayMultiThread(100000000, 1, 100);
        assertEquals(100000000, array.length);
        for (int i = 0; i < array.length; i++) {
            assert(array[i] >= 1 && array[i] <= 100);
        }
    }

    @Test
    public void testBubbleSort(){
        int [] array = generator.generateRandomArrayMultiThread(100, 1, 100);
        int [] sortedArray = Sort.bubbleSort(array);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assert(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testInsertionSort(){
        int [] array = generator.generateRandomArrayMultiThread(100, 1, 100);
        int [] sortedArray = Sort.insertionSort(array);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assert(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testMergeSort(){
        int [] array = generator.generateRandomArrayMultiThread(100, 1, 100);
        int [] sortedArray = Sort.mergeSort(array);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assert(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testQuickSort(){
        int [] array = generator.generateRandomArrayMultiThread(1000, 1, 100);
        int [] sortedArray = Sort.quickSort(array);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assert(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testSelectionSort(){
        int [] array = generator.generateRandomArrayMultiThread(100, 1, 100);
        int [] sortedArray = Sort.selectionSort(array);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assert(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testShellSort(){
        int [] array = generator.generateRandomArrayMultiThread(100, 1, 100);
        int [] sortedArray = Sort.shellSort(array);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assert(sortedArray[i] <= sortedArray[i + 1]);
        }
    }







}