package swea.d2;

import java.util.Scanner;

public class No1989_초심가의회문검사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i = 1; i <= testCase; i++) {
            String input = sc.next();
            if(isPalindrome(input)) {
                System.out.println("#" + i + " " + "1");
            } else {
                System.out.println("#" + i + " " + "0");
            }
        }
    }

    private static boolean isPalindrome(String input) {
        StringBuilder sb = new StringBuilder(input);
        if(sb.reverse().toString().equals(input)) {
            return true;
        }
        return false;
    }
}
