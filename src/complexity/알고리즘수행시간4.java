package complexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알고리즘수행시간4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if (n == 1) {
            System.out.println(0);
        } else {
            System.out.println(n * (n -1) / 2);
        }
        
        System.out.println(2);
    }
}
