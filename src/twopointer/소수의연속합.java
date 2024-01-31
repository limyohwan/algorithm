package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소수의연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if(isPrime(i)) {
                numbers.add(i);
            }
        }

        int[] prefixSum = new int[numbers.size() + 1];

        for(int i = 0; i < numbers.size(); i++) {
            prefixSum[i + 1] = prefixSum[i] + numbers.get(i);
        }

        int p1 = 0;
        int p2 = 1;
        int answer = 0;
        while(p1 < prefixSum.length && p2 < prefixSum.length) {
            if(prefixSum[p2] - prefixSum[p1] == N) {
                answer++;
                p1 += 1;
                p2 = p1 + 1;
            } else if(prefixSum[p2] - prefixSum[p1] > N) {
                p1 += 1;
                p2 = p1 + 1;
            } else {
                p2++;
            }
        }

        System.out.println(answer);

    }

    static boolean isPrime(int number) {
        if(number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
