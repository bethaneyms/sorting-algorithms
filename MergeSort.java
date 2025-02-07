public class MergeSort {
    public int[] sorty(int[] input) {
        if (input.length <= 1) return input;

        int mid = input.length / 2;
        int[] left = sorty(java.util.Arrays.copyOfRange(input, 0, mid));
        int[] right = sorty(java.util.Arrays.copyOfRange(input, mid, input.length));

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length || j < right.length) {
            if (j == right.length || (i < left.length && left[i] < right[j])) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        return result;
    }
}
