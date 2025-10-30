package polygon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세막대 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] sides = new int[3];
        sides[0] = Integer.parseInt(st.nextToken());
        sides[1] = Integer.parseInt(st.nextToken());
        sides[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(sides);

        if (sides[2] < sides[0] + sides[1]) {
            System.out.println(sides[0] + sides[1] + sides[2]);
        } else {
            System.out.println(2 * (sides[0] + sides[1]) - 1);
        }
    }
}
