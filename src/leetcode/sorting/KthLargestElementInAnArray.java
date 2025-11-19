package leetcode.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.add(num);
        }

        int answer = 0;

        while(queue.size() >= k) {
            answer = queue.poll();
        }

        return answer;
    }

    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }

        return minHeap.peek();
    }

    public int findKthLargest4(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int low, int high, int targetIdx) {
        int pivot = partition(nums, low, high);

        if (pivot == targetIdx) {
            return nums[pivot];
        } else if (pivot < targetIdx) {
            return quickSelect(nums, pivot + 1, high, targetIdx);
        } else {
            return quickSelect(nums, low, pivot - 1, targetIdx);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int p = low;

        for (int i = low; i < high; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, p);
                p++;
            }
        }

        swap(nums, p, high);
        return p;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest5(int[] nums, int k) {
        return quickSelect2(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect2(int[] nums, int low, int high, int targetIdx) {
        if (low == high) return nums[low];

        // 랜덤 피벗 선택
        int randomIdx = low + new Random().nextInt(high - low + 1);
        swap(nums, randomIdx, high);

        int pivot = partition(nums, low, high);

        if (pivot == targetIdx) {
            return nums[pivot];
        } else if (pivot < targetIdx) {
            return quickSelect(nums, pivot + 1, high, targetIdx);
        } else {
            return quickSelect(nums, low, pivot - 1, targetIdx);
        }
    }
}
