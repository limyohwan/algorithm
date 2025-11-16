package leetcode;

import java.util.Arrays;

public class RemoveDupulicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int[] source = Arrays.copyOf(nums, nums.length);

        int index = 1;
        for (int i = 1; i < source.length; i++) {
            if (!(source[i] == source[i - 1])) {
                nums[index] = source[i];
                index += 1;
            }
        }

        return index;
    }
}
