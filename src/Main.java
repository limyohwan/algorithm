// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        String[] a = new String[] {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"};
//        System.out.print(ArrayChallenge(a));

        String ss = "f 1    fff   dfd ";
        ss = ss.trim();
        System.out.println(ss);

        String[] strArr = ss.split(" ");
        System.out.println(strArr.length);

        for (String s : strArr) {
            System.out.println(s);
        }
    }

    public static String StringChallenge(String sen) {
        // code goes here
        String[] words = sen.split(" ");

        String answer = "";
        for (String word : words) {
            String temp = "";
            for (int i = 0; i < word.length(); i++) {
                if((word.charAt(i) >= 'a' && word.charAt(i) <= 'z') || (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')) {
                    temp += word.charAt(i);
                }
            }

            if (answer.length() <= temp.length()) {
                answer = temp;
            }
            System.out.println(temp);
        }

        return answer;
    }

    public static int ArrayChallenge(String[] strArr) {
        // code goes here
        String str = strArr[0];
        String[] strArr2 = strArr[1].split(",");
        int min = str.length();
        for (int i = 0; i < strArr2.length; i++) {
            int p1 = 0;
            int p2 = 0;

            while (p1 < str.length()) {
                if (str.charAt(p1) == strArr2[i].charAt(p2)) {
                    p1+=1;
                    p2+=1;
                    if (p2 == strArr2[i].length()) {
                        if (min > str.length() - strArr2[i].length()) {
                            min = str.length() - strArr2[i].length();
                        }
                        break;
                    }
                } else {
                    p1+=1;
                }
            }
        }

        return min;
    }
}