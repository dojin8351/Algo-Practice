package swea.d3;

import java.util.Scanner;
import java.util.Stack;

public class No14555_공과잡초 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            String str = sc.next();
            Stack<Character> stack = new Stack<>();
            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '(') {
                    // 여는 괄호를 스택에 추가
                    stack.push(c);
                } else if (c == ')') {
                    // 닫는 괄호가 나왔을 때
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        // 스택의 최상단이 '('라면 짝이 맞음 -> "()"
                        count++;
                        stack.pop(); // '(' 제거
                    } else {
                        // 스택이 비어있거나 짝이 안 맞음 -> "|)"
                        count++;
                    }
                } else if (c == '|') {
                    // 파이프 문자가 나온 경우
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        // 스택의 최상단이 '('라면 짝이 맞음 -> "(|"
                        count++;
                        stack.pop(); // '(' 제거
                    }
                }
            }
            // 결과 출력
            System.out.println("#" + tc + " " + count);
        }
    }
}
