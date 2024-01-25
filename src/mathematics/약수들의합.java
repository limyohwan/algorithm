package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 약수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(n + " = ");

            int sum = 0;
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    sum += i;
                    sb.append(i);

                    if(i != n / 2) {
                        sb.append(" + ");
                    }
                }
            }

            if (sum == n) {
                System.out.println(sb.toString());
            } else {
                System.out.println(n + " is NOT perfect.");
            }

            n = Integer.parseInt(br.readLine());
        }
    }
}
