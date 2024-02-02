package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 다음소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        for (long i = 0; i < n; i++) {
            long number = Long.parseLong(br.readLine());
            while(true) {
                if (isPrime(number)) {
                    break;
                } else {
                    number++;
                }
            }
            System.out.println(number);
        }
    }

    static boolean isPrime(long number) {
        if(number < 2) {
            return false;
        }

        for (long i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
