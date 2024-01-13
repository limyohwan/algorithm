package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int count = 0;
        while (N >= 0) {
            if (N % 5 == 0) {
                count += (N / 5);
                break;
            }

            N -= 3;
            count++;
        }

        if (N < 0) {
            count = -1;
        }

        System.out.println(count);
    }
}
