package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분수합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int numerator1 = Integer.parseInt(st1.nextToken());
        int denominator1 = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int numerator2 = Integer.parseInt(st2.nextToken());
        int denominator2 = Integer.parseInt(st2.nextToken());

        int numerator = (numerator1 * denominator2) + (numerator2 * denominator1);
        int denominator = denominator1 * denominator2;

        int max = Math.max(numerator, denominator);
        int min = Math.min(numerator, denominator);

        while(min != 0) {
            int remain = max % min;
            max = min;
            min = remain;
        }

        System.out.println(numerator / max);
        System.out.println(denominator / max);
    }
}
