package leetcode.array101;

import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        int[] source = Arrays.copyOf(nums, nums.length);

        int index = 0;
        for (int i = 0; i < source.length; i++) {
            if (source[i] == val) {
                cnt += 1;
            } else {
                nums[index] = source[i];
                index += 1;
            }
        }

        return nums.length - cnt;
    }

    public int removeElement2(int[] nums, int val) {
        int k = 0; // 유효한 요소를 배치할 위치

        for (int num : nums) {
            if (num != val) {
                nums[k] = num;
                k++;
            }
        }

        return k;
    }

    public int removeElement3(int[] nums, int val) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == val) {
                // 현재 요소를 마지막 요소로 교체
                nums[i] = nums[n - 1];
                n--; // 유효 길이 감소
            } else {
                i++; // val이 아닐 때만 포인터 이동
            }
        }

        return n;
    }

    public int removeElement4(int[] nums, int val) {
        int result = nums.length;

        for (int i = 0; i < result; i++) {
            if (nums[i] == val) {
                nums[i] = nums[result - 1];
                result--;
                i--; // 같은 인덱스 다시 확인
            }
        }

        return result;
    }
}
