package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char sign = '+';
        int startIndex = 0;
        boolean isMinus = false;
        if (str.charAt(0) == '-') {
            sign = '-';
            startIndex = 1;
            isMinus = true;
        }

        String number = "";
        int answer = 0;
        // -이후에는 -든 +든 모두 -로 계산하면됨
        for (int i = startIndex; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                if (isMinus) {
                    answer -= Integer.parseInt(number);
                }else if (sign == '+') {
                    answer += Integer.parseInt(number);
                } else {
                    answer -= Integer.parseInt(number);
                    isMinus = true;
                }
                sign = str.charAt(i);
                number = "";
            } else {
                number += str.charAt(i);
            }
        }

        if (isMinus) {
            answer -= Integer.parseInt(number);
        }else if (sign == '+') {
            answer += Integer.parseInt(number);
        } else {
            answer -= Integer.parseInt(number);
        }

        System.out.println(answer);
    }
}
