package leetcode.array101;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        boolean increase = true;
        int step = 0;

        for (int i = 1; i < arr.length; i++) {
            if (increase) {
                if (arr[i] < arr[i - 1]) {
                    increase = false;
                    if (step == 0) {
                        return false;
                    }
                } else if(arr[i] == arr[i - 1]) {
                    return false;
                }
            } else {
                if (arr[i] >= arr[i - 1]) {
                    return false;
                }
            }
            step++;
        }


        if (increase) {
            return false;
        }

        return true;
    }

    public boolean validMountainArray2(int[] arr) {
        int n = arr.length;

        if (n < 3) {
            return false;
        }

        int left = 0;
        int right = n - 1;

        // 왼쪽에서 정상까지 오르기
        while (left + 1 < n - 1 && arr[left] < arr[left + 1]) {
            left++;
        }

        // 오른쪽에서 정상까지 오르기
        while (right - 1 > 0 && arr[right - 1] > arr[right]) {
            right--;
        }

        // 두 포인터가 같은 정상에서 만나야 함
        return left == right;
    }

    public boolean validMountainArray3(int[] arr) {
        int n = arr.length;
        int i = 0;

        // 증가하는 구간 찾기
        while (i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        // 정상이 처음이나 끝에 있으면 false
        if (i == 0 || i == n - 1) {
            return false;
        }

        // 감소하는 구간 확인
        while (i < n - 1 && arr[i] > arr[i + 1]) {
            i++;
        }

        // 마지막까지 도달했으면 true
        return i == n - 1;
    }

    public boolean validMountainArray4(int[] arr) {
        int n = arr.length;

        if (n <= 2 || arr[0] > arr[1]) {
            return false;
        }

        boolean downMove = false;

        for (int i = 2; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                downMove = true;
            } else if (arr[i] == arr[i - 1] || downMove) {
                return false;
            }
        }

        return downMove;
    }
}
