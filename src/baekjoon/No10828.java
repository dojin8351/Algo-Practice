package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class No10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
            push X: 정수 X를 스택에 넣는 연산이다.
            pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            size: 스택에 들어있는 정수의 개수를 출력한다.
            empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
            top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
         */
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            String requestMethod = sc.next();
            if(requestMethod.equals("push")){
                int x = sc.nextInt();
                stack.push(x);
            } else if (requestMethod.equals("pop")) {
                if(stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.pop());
                }
            } else if (requestMethod.equals("size")) {
                System.out.println(stack.size());
            } else if (requestMethod.equals("empty")) {
                if(stack.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if (requestMethod.equals("top")) {
                if(stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
