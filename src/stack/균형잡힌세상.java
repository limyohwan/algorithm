package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (!line.equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean balanced = true;
            for (char letter : line.toCharArray()) {
                if (letter == '(' || letter == '[') {
                    stack.push(letter);
                } else if (letter == ')' || letter == ']'){
                    if (stack.isEmpty()) {
                        balanced = false;
                        break;
                    }

                    Character popLetter = stack.pop();
                    if (letter == ')' && popLetter != '(') {
                        balanced = false;
                        break;
                    }

                    if (letter == ']' && popLetter != '[') {
                        balanced = false;
                        break;
                    }
                }
            }

            if (balanced && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

            line = br.readLine();
        }
    }
}
