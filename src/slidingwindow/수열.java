package slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] temperatures = new int[N + 1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            temperatures[i] = Integer.parseInt(st2.nextToken());
        }

        int[] prefixSum = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + temperatures[i];
        }

        //누적합 사용

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i <= N - K; i++) {
            answer = Math.max(answer, prefixSum[i + K] - prefixSum[i]);
        }

        System.out.println(answer);
    }
}
