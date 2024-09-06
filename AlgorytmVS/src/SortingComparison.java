import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size);
        }
        return array;
    }

    public static long measureSortTime(Runnable sortingMethod, int[] arr) {
        long startTime = System.nanoTime();
        sortingMethod.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000};

        for (int size : sizes) {
            int[] arrayForBubbleSort = generateRandomArray(size);
            int[] arrayForSelectionSort = generateRandomArray(size);
            int[] arrayForDefaultSort = arrayForBubbleSort.clone();

            long bubbleSortTime = measureSortTime(() -> bubbleSort(arrayForBubbleSort), arrayForBubbleSort);
            long selectionSortTime = measureSortTime(() -> selectionSort(arrayForSelectionSort), arrayForSelectionSort);
            long defaultSortTime = measureSortTime(() -> Arrays.sort(arrayForDefaultSort), arrayForDefaultSort);

            System.out.println("Размер массива: " + size);
            System.out.println("Пузырьковая сортировка: " + bubbleSortTime + " нс");
            System.out.println("Сортировка выбором: " + selectionSortTime + " нс");
            System.out.println("Стандартная сортировка (Arrays.sort()): " + defaultSortTime + " нс");
            System.out.println("----------------------------------------");
        }
    }
}
