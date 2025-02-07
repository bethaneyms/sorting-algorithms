import java.util.Random;

interface SortingAlgorithm {
    void sort(int[] arr);
}

public class Tester {
    private SortingAlgorithm sortingAlgorithm;
    private Random random = new Random();

    public Tester(SortingAlgorithm sa) {
        this.sortingAlgorithm = sa;
    }

    private void generateKSorted(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int swapIdx = Math.max(0, Math.min(n - 1, i + random.nextInt(2 * k + 1) - k));
            int temp = arr[i];
            arr[i] = arr[swapIdx];
            arr[swapIdx] = temp;
        }
    }

    public double singleTest(int size, boolean kSorted) {
        int[] arr = new int[size];
        if (kSorted) {
            generateKSorted(arr, 10);
        } else {
            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt(10000);
            }
        }

        long startTime = System.nanoTime();
        sortingAlgorithm.sort(arr);
        return (System.nanoTime() - startTime) / 1_000_000.0;
    }

    public void test(int iterations, int size, boolean kSorted) {
        double totalTime = 0;
        for (int i = 0; i < iterations; i++) {
            totalTime += singleTest(size, kSorted);
        }
        String dataType = kSorted ? "10-sorted" : "random";
        System.out.printf("%s - Size %d: %.3f ms\n", dataType, size, totalTime / iterations);
    }

    public static void main(String[] args) {
        SortingAlgorithm[] algorithms = {
                arr -> new BubbleSort().sorty(arr),
                arr -> new InsertionSort().sorty(arr),
                arr -> new SelectionSort().sorty(arr),
                arr -> new ShellSort().sorty(arr),
                arr -> new QuickSort().sorty(arr),
                arr -> new MergeSort().sorty(arr)
        };

        String[] names = {"Bubble Sort", "Insertion Sort", "Selection Sort", "Shell Sort", "Quick Sort", "Merge Sort"};
        int[] sizes = {100, 500, 1000, 5000, 10000};

        for (int i = 0; i < algorithms.length; i++) {
            System.out.println("\nTesting " + names[i] + "...");
            Tester tester = new Tester(algorithms[i]);

            // Test on Random Data
            for (int size : sizes) {
                tester.test(5, size, false);
            }

            // Test on 10-Sorted Data
            for (int size : sizes) {
                tester.test(5, size, true);
            }
        }
    }
}
