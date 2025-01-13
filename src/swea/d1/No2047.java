package swea.d1;

import java.util.Scanner;

public class No2047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String value = sc.next();
        String result = "";

        for(int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            ch = Character.toUpperCase(ch);
            result += ch;
        }
        System.out.println(result);
    }
}
