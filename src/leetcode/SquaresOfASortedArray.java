package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        return nums;
    }

    public int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int position = n - 1; // 뒤에서부터 채우기

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[position] = leftSquare;
                left++;
            } else {
                result[position] = rightSquare;
                right--;
            }

            position--;
        }

        return result;
    }

    public int[] sortedSquares3(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result.add(leftSquare);
                left++;
            } else {
                result.add(rightSquare);
                right--;
            }
        }

        // 역순 변환
        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
