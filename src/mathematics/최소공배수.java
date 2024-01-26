package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        long num1 = Long.parseLong(st1.nextToken());
        long num2 = Long.parseLong(st1.nextToken());

        long gcd = 0;
        if(num1 > num2) {
            gcd = gcd(num1, num2);
        } else {
            gcd = gcd(num2, num1);
        }

        System.out.println(num1 * num2 / gcd);
    }

    static long gcd(long a, long b) {
        while(b != 0) {
            long remain = a % b;
            a = b;
            b = remain;
        }

        return a;
    }
}
