package swea.d2;

import java.util.Scanner;

public class No2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            String value = sc.next();
            int cnt = 0;
            for(int j = 0; j < value.length(); j++) {
                String text1 = value.substring(0, j + 1);
                String text2 = value.substring(j + 1, text1.length() + j + 1);

                if(text1.equals(text2)) {
                    cnt = text1.length();
                    break;
                }
            }
            System.out.printf("#%d %d\n", i + 1, cnt);
// repeat를 이용한 풀이
//            for (int i = 1; i <= txt.length(); i++) {
//                if (txt.length() % i == 0) {
//                    String pattern = txt.substring(0, i);
//                    if (txt.equals(pattern.repeat(txt.length() / i))) {
//                        result = i;
//                        break;
//                    }
//                }
//            }

        }
    }

}
