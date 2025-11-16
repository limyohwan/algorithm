package leetcode;

import java.util.Arrays;

public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
               arr = shift(arr, i);
               i += 1;
            }
        }
    }

    public int[] shift(int[] arr, int index) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        return arr;
    }

    public void duplicateZeros2(int[] arr) {
        int[] source = Arrays.copyOf(arr, arr.length);

        int arrIdx = 0;

        for (int i = 0; i < source.length; i++) {
            if (arrIdx == source.length) {
                break;
            }

            if (source[i] == 0) {
                arr[arrIdx] = 0;
                arrIdx += 1;
                arr[arrIdx] = 0;
            } else {
                arr[arrIdx] = source[i];
            }

            arrIdx += 1;
        }
    }
}
