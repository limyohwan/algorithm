package leetcode.array101;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

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

    public int removeDuplicates2(int[] nums) {
        int k = 0; // 고유 요소를 배치할 위치

        for (int num : nums) {
            // 첫 번째 요소이거나, 이전 고유 요소와 다른 경우
            if (k == 0 || num != nums[k - 1]) {
                nums[k] = num;
                k++;
            }
        }

        return k;
    }

    public int removeDuplicates3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 1; // 쓰기 위치

        for (int right = 1; right < nums.length; right++) {
            // 현재 요소가 이전 요소와 다르면
            if (nums[right] != nums[right - 1]) {
                nums[left] = nums[right];
                left++;
            }
        }

        return left;
    }

    public int removeDuplicates4(int[] nums) {
        int i = 0;

        for (int num : nums) {
            // i < 1 (첫 요소) 또는 num > nums[i-1] (정렬된 배열이므로 != 대신 > 사용)
            if (i < 1 || num > nums[i - 1]) {
                nums[i++] = num;
            }
        }

        return i;
    }

    public int removeDuplicates5(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int index = 0;
        for (int num : set) {
            nums[index++] = num;
        }

        return set.size();
    }

}
