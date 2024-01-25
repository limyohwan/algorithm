package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 약수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                count++;
                answer = i;
                if (count == K) {
                    break;
                }
            }
        }

        System.out.println(count == K ? answer : 0);
    }
}
