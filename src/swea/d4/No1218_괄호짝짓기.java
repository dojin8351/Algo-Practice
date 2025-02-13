package swea.d4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class No1218_괄호짝짓기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int test = 1; test <= 10; test++) {
            Stack<Character> stack1 = new Stack<>();
            Stack<Character> stack2 = new Stack<>();
            Stack<Character> stack3 = new Stack<>();
            Stack<Character> stack4 = new Stack<>();
            int length = sc.nextInt();
            String input = sc.next();
            char[] inputChars = input.toCharArray();
            for(char ch : inputChars) {
                if(ch == '(') {
                    stack1.push(ch);
                } else if(ch == '[') {
                    stack2.push(ch);
                } else if(ch == '{') {
                    stack3.push(ch);
                } else if(ch == '<') {
                    stack4.push(ch);
                } else if(ch == ')') {
                    if(stack1.isEmpty()) {
                        break;
                    }
                    stack1.pop();
                } else if(ch == ']') {
                    if(stack2.isEmpty()) {
                        break;
                    }
                    stack2.pop();
                } else if(ch == '}') {
                    if(stack3.isEmpty()) {
                        break;
                    }
                    stack3.pop();
                } else if(ch == '>') {
                    if(stack4.isEmpty()) {
                        break;
                    }
                    stack4.pop();
                }
            }

            if(stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty() && stack4.isEmpty()){
                System.out.println("#" + test + " " + 1);
            } else {
                System.out.println("#" + test + " " + 0);
            }
        }
    }
}
