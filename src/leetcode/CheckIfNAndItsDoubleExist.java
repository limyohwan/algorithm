package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] * 2 || arr[i] * 2 == arr[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkIfExist2(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (seen.contains(2 * num) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }

            seen.add(num);
        }

        return false;
    }

    public boolean checkIfExist3(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int target = 2 * arr[i];
            int index = customBinarySearch(arr, target);

            if (index >= 0 && index != i) {
                return true;
            }
        }

        return false;
    }

    private int customBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid  = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
