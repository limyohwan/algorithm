package slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int aCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                aCount++;
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int bCount = 0;
            for (int j = i; j < i + aCount; j++) {
                int index = j % str.length();
                if (str.charAt(index) == 'b') {
                    bCount++;
                }
            }

            answer = Math.min(answer, bCount);
        }

        System.out.println(answer);
    }
}
