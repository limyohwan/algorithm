package leetcode.array101;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int cnt = 0;
        int[] sources = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sources[i]) {
                cnt++;
            }
        }

        return cnt;
    }

    private void bubbleSort(int[] arr) {
        int n = arr.length;
        // Loop through the array for bubble sort passes.
        for (int i = 0; i < n - 1; ++i) {
            // Inner loop to compare and swap elements.
            for (int j = 0; j < n - i - 1; ++j) {
                // Compare and swap if elements are in the wrong order.
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public int heightChecker2(int[] heights) {
        // Sort the array using bubble sort.
        int[] sortedHeights = heights.clone();
        bubbleSort(sortedHeights);

        int count = 0;
        // Loop through the original and sorted arrays.
        for (int i = 0; i < sortedHeights.length; ++i) {
            // Increment count if elements at the same index differ.
            if (heights[i] != sortedHeights[i]) {
                count += 1;
            }
        }
        // Return the total count of differing elements.
        return count;
    }

    private void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
        // Calculate the start and sizes of two halves.
        int start1 = left;
        int start2 = mid + 1;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Copy elements of both halves into a temporary array.
        for (int i = 0; i < n1; i++) {
            tempArr[start1 + i] = arr[start1 + i];
        }
        for (int i = 0; i < n2; i++) {
            tempArr[start2 + i] = arr[start2 + i];
        }

        // Merge the sub-arrays in 'tempArr' back into the original array 'arr' in
        // sorted order.
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (tempArr[start1 + i] <= tempArr[start2 + j]) {
                arr[k] = tempArr[start1 + i];
                i += 1;
            } else {
                arr[k] = tempArr[start2 + j];
                j += 1;
            }
            k += 1;
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = tempArr[start1 + i];
            i += 1;
            k += 1;
        }
        while (j < n2) {
            arr[k] = tempArr[start2 + j];
            j += 1;
            k += 1;
        }
    }

    // Recursive function to sort an array using merge sort.
    private void mergeSort(int[] arr, int left, int right, int[] tempArr) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        // Sort first and second halves recursively.
        mergeSort(arr, left, mid, tempArr);
        mergeSort(arr, mid + 1, right, tempArr);
        // Merge the sorted halves.
        merge(arr, left, mid, right, tempArr);
    }

    public int heightChecker3(int[] heights) {
        // Sort the array using merge sort.
        int[] sortedHeights = heights.clone();
        int[] tempArray = new int[heights.length];
        mergeSort(sortedHeights, 0, sortedHeights.length - 1, tempArray);

        int count = 0;
        // Loop through the original and sorted arrays.
        for (int i = 0; i < sortedHeights.length; ++i) {
            // Increment count if elements at the same index differ.
            if (heights[i] != sortedHeights[i]) {
                count += 1;
            }
        }
        // Return the total count of differing elements.
        return count;
    }

    // Function to max heapify a subtree (in top-down order) rooted at index i.
    private void heapify(int[] arr, int n, int i) {
        // Initialize largest as root 'i'.
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If the left child is larger than the root.
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If the right child is larger than the largest so far.
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root swap root with the largest element
        // Recursively heapify the affected sub-tree (i.e. move down).
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    private void heapSort(int[] arr) {
        int n = arr.length;
        // Build heap; heapify all elements except leaf nodes, in bottom-up order.
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Traverse elements one by one, to move the current root to the end, and
        for (int i = n - 1; i >= 0; i--) {
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;
            // call max heapify on the reduced array.
            heapify(arr, i, 0);
        }
    }

    public int heightChecker4(int[] heights) {
        // Sort the array using heap sort.
        int[] sortedHeights = heights.clone();
        heapSort(sortedHeights);

        int count = 0;
        // Loop through the original and sorted arrays.
        for (int i = 0; i < sortedHeights.length; ++i) {
            // Increment count if elements at the same index differ.
            if (heights[i] != sortedHeights[i]) {
                count += 1;
            }
        }
        // Return the total count of differing elements.
        return count;
    }

    private void countingSort(int[] arr) {
        // Create the counting hash map.
        Map<Integer, Integer> counts = new HashMap<>();
        // Find the minimum and maximum values in the array.
        int minVal = Arrays.stream(arr).min().getAsInt();
        int maxVal = Arrays.stream(arr).max().getAsInt();

        // Update element's count in the hash map.
        for (int val : arr) {
            counts.put(val, counts.getOrDefault(val, 0) + 1);
        }

        int index = 0;
        // Place each element in its correct position in the array.
        for (int val = minVal; val <= maxVal; ++val) {
            // Append all 'val's together if they exist.
            while (counts.getOrDefault(val, 0) > 0) {
                arr[index] = val;
                index += 1;
                counts.put(val, counts.get(val) - 1);
            }
        }
    }

    public int heightChecker5(int[] heights) {
        // Sort the array using counting sort.
        int[] sortedHeights = heights.clone();
        countingSort(sortedHeights);

        int count = 0;
        // Loop through the original and sorted arrays.
        for (int i = 0; i < sortedHeights.length; ++i) {
            // Increment count if elements at the same index differ.
            if (heights[i] != sortedHeights[i]) {
                count += 1;
            }
        }
        // Return the total count of differing elements.
        return count;
    }
}
