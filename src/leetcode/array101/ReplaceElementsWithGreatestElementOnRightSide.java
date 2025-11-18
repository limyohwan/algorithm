package leetcode.array101;

import java.util.Stack;
import java.util.TreeMap;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int index = 0;

        while (index < arr.length - 1) {
            int greatestElement = arr[index + 1];
            int greatestIndex = index + 1;

            for (int i = index + 1; i < arr.length; i++) {
                if (arr[i] > greatestElement) {
                    greatestElement = arr[i];
                    greatestIndex = i;
                }
            }

            for (int i = index; i < greatestIndex; i++) {
                arr[i] = greatestElement;
            }

            index = greatestIndex;
        }

        arr[arr.length - 1] = -1;

        return arr;
    }

    public int[] replaceElements2(int[] arr) {
        int maxValue = -1; // 마지막 요소는 -1

        // 오른쪽에서 왼쪽으로 순회
        for (int i = arr.length - 1; i >= 0; i--) {
            // 현재 요소를 임시 저장
            int currentElement = arr[i];

            // 현재 요소를 오른쪽의 최댓값으로 교체
            arr[i] = maxValue;

            // 다음 반복을 위해 최댓값 갱신
            maxValue = Math.max(maxValue, currentElement);
        }

        return arr;
    }

    public int[] replaceElements3(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int maxRight = -1;

            // i+1부터 끝까지 최댓값 찾기
            for (int j = i + 1; j < n; j++) {
                maxRight = Math.max(maxRight, arr[j]);
            }

            arr[i] = maxRight;
        }

        return arr;
    }

    public int[] replaceElements4(int[] arr) {
        int n = arr.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // 모든 요소를 TreeMap에 추가 (값: 빈도)
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            // 현재 요소 제거
            map.put(arr[i], map.get(arr[i]) - 1);
            if (map.get(arr[i]) == 0) {
                map.remove(arr[i]);
            }

            // 최댓값 가져오기
            result[i] = map.isEmpty() ? -1 : map.lastKey();
        }

        return result;
    }

    public int[] replaceElements5(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int max = -1;

        // 역순으로 스택에 최댓값 저장
        for (int i = arr.length - 1; i >= 0; i--) {
            stack.push(max);
            max = Math.max(max, arr[i]);
        }

        // 스택에서 꺼내며 배열 채우기
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }

        return arr;
    }
}
