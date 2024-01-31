package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        int p1 = 0;
        int p2 = 1;
        int answer = 0;
        while(p1 < n) {
            if (p2 >= n) {
                p1 += 1;
                p2 = p1 + 1;
                continue;
            }

            if(numbers[p1] + numbers[p2] == x) {
                answer++;
                p1 += 1;
                p2 = p1 + 1;
            } else {
                p2++;
            }
        }

        System.out.println(answer);
    }
}
