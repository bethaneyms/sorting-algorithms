public class ShellSort {
    public int[] sorty(int[] input) {
        int n = input.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = input[i];
                int j = i;
                while (j >= gap && input[j - gap] > temp) {
                    input[j] = input[j - gap];
                    j -= gap;
                }
                input[j] = temp;
            }
        }
        return input;
    }
}
