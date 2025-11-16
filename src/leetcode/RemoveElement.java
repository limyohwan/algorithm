package leetcode;

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
}
