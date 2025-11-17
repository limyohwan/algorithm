package leetcode.beginner;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        fizzBuzz(3);
    }

    public static List<String> fizzBuzz(int n) {
        List<String> results = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results.add("FizzBuzz");
            } else if(i % 3 == 0) {
                results.add("Fizz");
            } else if (i % 5 == 0) {
                results.add("Buzz");
            } else {
                results.add(String.valueOf(i));
            }
        }
        return results;
    }

    public static List<String> fizzBuzz2(int n) {
        List<String> results = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            String currStr = "";
            if(i % 3 == 0) {
                currStr += "Fizz";
            }

            if (i % 5 == 0) {
                currStr += "Buzz";
            }

            if (currStr.isEmpty()){
                currStr += String.valueOf(i);
            }

            results.add(currStr);
        }
        return results;
    }
}
