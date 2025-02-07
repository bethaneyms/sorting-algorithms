import java.io.*;
import java.util.Random;

class Performance {

    public static void main(String[] args) throws IOException {

        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};


        BufferedWriter writer = new BufferedWriter(new FileWriter("sorting_performance_report.txt"));


        BubbleSort bubbleSort = new BubbleSort();
        InsertionSort insertionSort = new InsertionSort();
        SelectionSort selectionSort = new SelectionSort();
        ShellSort shellSort = new ShellSort();
        QuickSort quickSort = new QuickSort();
        MergeSort mergeSort = new MergeSort();

        writer.write("Sorting Algorithm Performance Report\n\n");

        testAlgorithm(bubbleSort, "Bubble Sort", sizes, writer);
        testAlgorithm(insertionSort, "Insertion Sort", sizes, writer);
        testAlgorithm(selectionSort, "Selection Sort", sizes, writer);
        testAlgorithm(shellSort, "Shell Sort", sizes, writer);
        testAlgorithm(quickSort, "Quick Sort", sizes, writer);
        testAlgorithm(mergeSort, "Merge Sort", sizes, writer);

        writer.close();
    }

    private static void testAlgorithm(Object sorter, String algorithmName, int[] sizes, BufferedWriter writer) throws IOException {
        writer.write("Sorting Algorithm – " + algorithmName + "\n");
        for (int size : sizes) {
            long totalTime = 0;

           //Running the test
            for (int i = 0; i < 20; i++) {
                int[] array = generateRandomArray(size);
                long startTime = System.nanoTime();

                if (sorter instanceof BubbleSort) {
                    ((BubbleSort) sorter).sorty(array);
                } else if (sorter instanceof InsertionSort) {
                    ((InsertionSort) sorter).sorty(array);
                } else if (sorter instanceof SelectionSort) {
                    ((SelectionSort) sorter).sorty(array);
                } else if (sorter instanceof ShellSort) {
                    ((ShellSort) sorter).sorty(array);
                } else if (sorter instanceof QuickSort) {
                    ((QuickSort) sorter).sorty(array);
                } else if (sorter instanceof MergeSort) {
                    ((MergeSort) sorter).sorty(array);
                }

                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }

            //Milliseconds
            long avgTime = totalTime / 20 / 1000000;
            writer.write("Sorted " + size + " elements in " + avgTime + " ms (avg)\n");
        }
        writer.write("\n");
    }
    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt();
        }
        return array;
    }
}
