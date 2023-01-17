
import API.arrayGeneration.RandomArrayGenerator;
import API.arraySorting.Sort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlgorithmsTest {
    private final RandomArrayGenerator randomArrayGenerator = new RandomArrayGenerator();
    @Test
    public void generateRandomArrayMultiThread() throws InterruptedException {
        int [] array = randomArrayGenerator.generateRandomArray(1000000000, 1, 100);
        assertEquals(1000000000, array.length);
    }

    @Test
    public void testBubbleSort(){
        int [] array = randomArrayGenerator.generateRandomArray(100, 1, 100);
        int [] sortedArray = Sort.bubbleSort(array);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assert(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testInsertionSort(){
        int [] array = randomArrayGenerator.generateRandomArray(100, 1, 100);
        int [] sortedArray = Sort.insertionSort(array);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assert(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testMergeSort(){
        int [] array = randomArrayGenerator.generateRandomArray(100, 1, 100);
        int [] sortedArray = Sort.mergeSort(array);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assert(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testQuickSort(){
        int [] array = randomArrayGenerator.generateRandomArray(1000, 1, 100);
        int [] sortedArray = Sort.quickSort(array);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assert(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testSelectionSort(){
        int [] array = randomArrayGenerator.generateRandomArray(100, 1, 100);
        int [] sortedArray = Sort.selectionSort(array);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assert(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test
    public void testShellSort(){
        int [] array = randomArrayGenerator.generateRandomArray(10000, 1, 100);
        int [] sortedArray = Sort.shellSort(array);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assert(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

}
