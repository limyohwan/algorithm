package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세로읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] characters = new char[5][15];

        for (int i = 0; i < 5; i++) {
            char[] word = br.readLine().toCharArray();
            for (int j = 0; j < word.length; j++) {
                characters[i][j] = word[j];
            }
        }


        for (int j = 0; j < 15; j++) {
            String str = "";
            for (int i =0; i < 5; i++) {
                if(characters[i][j] != '\u0000') {
                    str += characters[i][j];
                }
            }
            System.out.print(str);
        }
    }
}
