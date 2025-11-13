package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            System.out.println(binomialCoefficient3(k, n));
        }
    }

    // 파스칼 법칙
    public static int binomialCoefficient(int n, int k) {
        // 기저 조건
        if (k == 0 || n == k) {
            return 1;
        }

        // 파스칼의 법칙
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }


    // 파스칼 법칙 + 동적 프로그래밍
//    static int[][] dp = new int[30][30];
//    public static int binomialCoefficient2(int n, int k) {
//        // 이미 계산된 값이 있으면 재활용
//        if (dp[n][k] > 0) {
//            return dp[n][k];
//        }
//
//        // 기저 조건
//        if (k == 0 || n == k) {
//            return dp[n][k] = 1;
//        }
//
//        // 파스칼의 법칙으로 계산 후 저장
//        return dp[n][k] = binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
//    }

    public static int binomialCoefficient3(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        // 기저 조건: k = 0일 때
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // 파스칼의 삼각형 구성
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return dp[n][k];
    }
}
