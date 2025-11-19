package leetcode.sorting;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    public void sortColors2(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;

        // 첫 번째 패스: 카운트
        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        // 두 번째 패스: 재구성
        int index = 0;
        for (int i = 0; i < count0; i++) nums[index++] = 0;
        for (int i = 0; i < count1; i++) nums[index++] = 1;
        for (int i = 0; i < count2; i++) nums[index++] = 2;
    }

    public void sortColors3(int[] nums) {
        int low = 0;      // 0의 오른쪽 경계
        int mid = 0;      // 현재 검사 위치
        int high = nums.length - 1;  // 2의 왼쪽 경계

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {  // nums[mid] == 2
                swap(nums, mid, high--);
                // mid는 증가시키지 않음 (swap된 값 확인 필요)
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors4(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;

        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i++, left++);
            } else if (nums[i] == 2) {
                swap(nums, i, right--);
            } else {
                i++;
            }
        }
    }

    public void sortColors5(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] counts = new int[max + 1];

        for (int num : nums) {
            counts[num] += 1;
        }

        int startingIndex = 0;
        for (int i = 0; i < max + 1; i++) {
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        int sortArray[] = new int[nums.length];
        for (int num : nums) {
            sortArray[counts[num]] = num;
            counts[num] += 1;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sortArray[i];
        }
    }
}
