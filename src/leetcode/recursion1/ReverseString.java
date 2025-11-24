package leetcode.recursion1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ReverseString {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    // two pointers
    public void reverseString2(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // 문자 교환
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // 포인터 이동
            left++;
            right--;
        }
    }

    // recursion
    public void reverseString3(char[] s) {
        reverseHelper(s, 0, s.length - 1);
    }

    private void reverseHelper(char[] s, int left, int right) {
        // 베이스 케이스: 포인터가 만나거나 교차하면 종료
        if (left >= right) {
            return;
        }

        // 현재 위치의 문자 교환
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        // 재귀 호출 (포인터를 중앙으로 이동)
        reverseHelper(s, left + 1, right - 1);
    }

    public void reverseString4(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // XOR를 이용한 스왑 (temp 변수 불필요)
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];

            left++;
            right--;
        }
    }

    public void reverseString5(char[] s) {
        Stack<Character> stack = new Stack<>();

        // 1. 모든 문자를 스택에 푸시
        for (char c : s) {
            stack.push(c);
        }

        // 2. 스택에서 팝하며 원본 배열에 저장
        for (int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }
    }

    public void reverseString6(char[] s) {
        char[] temp = new char[s.length];

        // 역순으로 복사
        for (int i = 0; i < s.length; i++) {
            temp[i] = s[s.length - 1 - i];
        }

        // 원본 배열에 복사
        for (int i = 0; i < s.length; i++) {
            s[i] = temp[i];
        }
    }

    public void reverseString7(char[] s) {
        // char[]를 List<Character>로 변환
        List<Character> list = new ArrayList<>();
        for (char c : s) {
            list.add(c);
        }

        // Collections.reverse() 사용
        Collections.reverse(list);

        // 다시 배열로 복사
        for (int i = 0; i < s.length; i++) {
            s[i] = list.get(i);
        }
    }

    public void reverseString8(char[] s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            sb.append(c);
        }

        sb.reverse();

        for (int i = 0; i < s.length; i++) {
            s[i] = sb.charAt(i);
        }
    }
}
