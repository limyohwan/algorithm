package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 창문닫기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i <= Math.sqrt(N); i++) {
            answer++;
        }

        System.out.println(answer);
    }
}
