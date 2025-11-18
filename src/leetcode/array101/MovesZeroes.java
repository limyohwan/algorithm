package leetcode.array101;

import java.util.ArrayList;
import java.util.List;

public class MovesZeroes {
    public void moveZeroes(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex != endIndex) {
            if (nums[startIndex] == 0) {
                for (int j = startIndex; j < nums.length - 1 ; j++) {
                    nums[j] = nums[j + 1];
                }

                nums[endIndex] = 0;
                endIndex -= 1;
            } else {
                startIndex +=1;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[nonZeroIndex];
                nums[nonZeroIndex] = nums[i];
                nums[i] = temp;
                nonZeroIndex++;
            }
        }
    }

    public void moveZeroes3(int[] nums) {
        int nonZeroIndex = 0;

        // 0이 아닌 요소들을 앞으로 이동
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }

        // 나머지 위치에 0 채우기
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes4(int[] nums) {
        List<Integer> nonZero = new ArrayList<>();
        int zeroCount = 0;

        for (int num : nums) {
            if (num != 0) {
                nonZero.add(num);
            } else {
                zeroCount++;
            }
        }

        for (int i = 0; i < nonZero.size(); i++) {
            nums[i] = nonZero.get(i);
        }

        for (int i = nonZero.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
