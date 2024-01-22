package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세탁소사장동혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] coins = {25, 10, 5, 1};

        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());

            for (int coin : coins) {
                System.out.print(C / coin + " ");
                C = C % coin;
            }
            System.out.println();
        }
    }
}
