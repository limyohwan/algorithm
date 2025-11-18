package leetcode.array101;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);

        int k = 0;

        for (int num : nums) {
            if (k == 0 || num != nums[k - 1]) {
                nums[k] = num;
                k++;
            }
        }

        return nums[k - 3 < 0 ? nums.length - 1 : k -3];
    }

    public int thirdMax2(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        Set<Integer> taken = new HashSet<Integer>();

        for (int index = 0; index < nums.length; ++index) {
            // If current number was already taken, skip it.
            if (taken.contains(nums[index])) {
                continue;
            }

            // If min heap already has three numbers in it.
            // Pop the smallest if current number is bigger than it.
            if (minHeap.size() == 3) {
                if (minHeap.peek() < nums[index]) {
                    taken.remove(minHeap.poll());

                    minHeap.add(nums[index]);
                    taken.add(nums[index]);
                }
            }
            // If min heap does not have three numbers we can push it.
            else {
                minHeap.add(nums[index]);
                taken.add(nums[index]);
            }
        }

        // 'nums' has only one distinct element it will be the maximum.
        if (minHeap.size() == 1) {
            return minHeap.peek();
        }
        // 'nums' has two distinct elements.
        else if (minHeap.size() == 2) {
            int firstNum = minHeap.poll();
            return Math.max(firstNum, minHeap.peek());
        }

        return minHeap.peek();
    }

    public int thirdMax3(int[] nums) {
        // Sorted set to keep elements in sorted order.
        TreeSet<Integer> sortedNums = new TreeSet<Integer>();

        // Iterate on all elements of 'nums' array.
        for (int num : nums) {
            // Do not insert same element again.
            if (sortedNums.contains(num)) {
                continue;
            }

            // If sorted set has 3 elements.
            if (sortedNums.size() == 3) {
                // And the smallest element is smaller than current element.
                if (sortedNums.first() < num) {
                    // Then remove the smallest element and push the current element.
                    sortedNums.pollFirst();
                    sortedNums.add(num);
                }

            }
            // Otherwise push the current element of nums array.
            else {
                sortedNums.add(num);
            }
        }

        // If sorted set has three elements return the smallest among those 3.
        if (sortedNums.size() == 3) {
            return sortedNums.first();
        }

        // Otherwise return the biggest element of nums array.
        return sortedNums.last();
    }

    public int thirdMax4(int[] nums) {
        // Three variables to store maxiumum three numbers till now.
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int num : nums) {
            // This number is already used once, thus we skip it.
            if (firstMax == num || secondMax == num || thirdMax == num) {
                continue;
            }

            // If current number is greater than first maximum,
            // It means that this is the greatest number and first maximum and second max
            // will become the next two greater numbers.
            if (firstMax <= num) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            }
            // When current number is greater than second maximum,
            // it means that this is the second greatest number.
            else if (secondMax <= num) {
                thirdMax = secondMax;
                secondMax = num;
            }
            // It is the third greatest number.
            else if (thirdMax <= num) {
                thirdMax = num;
            }
        }

        // If third max was never updated, it means we don't have 3 distinct numbers.
        if (thirdMax == Long.MIN_VALUE) {
            int ans = (int) firstMax;
            return ans;
        }

        int ans = (int) thirdMax;
        return ans;
    }
}
