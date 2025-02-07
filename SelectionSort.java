public class SelectionSort {
    public int[] sorty(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = input[minIdx];
            input[minIdx] = input[i];
            input[i] = temp;
        }
        return input;
    }
}
