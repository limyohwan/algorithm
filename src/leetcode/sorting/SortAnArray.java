package leetcode.sorting;

public class SortAnArray {
    static int[] temp;
    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];

        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    public void mergeSort(int[] arr, int left, int right) {
        // 배열의 크기가 1이면 더 이상 분할 불가
        if (left == right) {
            return;
        }

        // 중간 지점 계산
        int mid = (left + right) / 2;

        // 왼쪽 절반 정렬
        mergeSort(arr, left, mid);

        // 오른쪽 절반 정렬
        mergeSort(arr, mid + 1, right);

        // 정렬된 두 배열 병합
        merge(arr, left, mid, right);
    }

    // 병합 메서드
    public void merge(int[] arr, int left, int mid, int right) {
        int l = left;      // 왼쪽 배열 시작 인덱스
        int r = mid + 1;   // 오른쪽 배열 시작 인덱스
        int idx = left;    // 임시 배열 인덱스

        // 양쪽 배열을 비교하며 정렬
        while (l <= mid && r <= right) {
            // 안정 정렬을 위해 같을 때는 왼쪽 값을 먼저 선택
            if (arr[l] <= arr[r]) {
                temp[idx++] = arr[l++];
            } else {
                temp[idx++] = arr[r++];
            }
        }

        // 왼쪽 배열의 남은 요소 처리
        while (l <= mid) {
            temp[idx++] = arr[l++];
        }

        // 오른쪽 배열의 남은 요소 처리
        while (r <= right) {
            temp[idx++] = arr[r++];
        }

        // 정렬된 배열을 원본에 복사
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
