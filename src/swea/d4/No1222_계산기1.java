package swea.d4;

import java.util.Scanner;
import java.util.Stack;

public class No1222_계산기1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test = 1; test <= 10; test++) {
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            int length = sc.nextInt();
            String input = sc.next();

            for(int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if(ch >= '0' && ch <= '9') {
                    sb.append(ch);
                } else {
                    if (stack.isEmpty()) {
                        stack.push(ch);
                    } else {
                        if (stack.peek() == ch) {
                            sb.append(ch);
                        }
                    }
                }
            }
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            System.out.println("#" + test + " " + calculator(sb.toString()));
        }
    }

    public static int calculator(String str) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < str.length();i++) {
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9') {
                stack.push(ch - '0');
            } else {
                int B = stack.pop();
                int A = stack.pop();

                if(ch == '+') {
                    stack.push(A+B);
                }

            }
        }

        return stack.pop();
    }
}
