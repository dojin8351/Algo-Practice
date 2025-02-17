package swea.d4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class No1224_계산기3 {
    // charAt으로 찢다 피연산자를 만나면 sb에 append
    // 만약 연산자를 만나게된다면 stack에 push
    // 그후 또다시 피연산자 만나면 sb에 append
    // 다시 연산자를 만나게 되면 만난 연산자와 stack에 가장 위에있는 연산자의 우선순위를 비교
    static Map<Character,Integer> operator = new HashMap<>();
    public static void main(String[] args) {
        operator.put('+',1);
        operator.put('*',2);

        Scanner sc = new Scanner(System.in);
        for(int test = 1; test <= 10; test++) {
            StringBuilder sb = new StringBuilder();
            Stack<Character> op = new Stack<>();
            int length = sc.nextInt();
            String input = sc.next();
            boolean tag = false;
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                // 여는 괄호를 만나면 스택에 그대로 푸시
                if (ch == '(') {
                    op.push(ch);
                }
                // 닫는 괄호를 만나면 여는 괄호까지 스택 정리
                else if (ch == ')') {
                    while (!op.isEmpty() && op.peek() != '(') {
                        sb.append(op.pop());
                    }
                    op.pop(); // 여는 괄호 '(' 제거
                }
                // 숫자일 경우 결과 문자열에 추가
                else if (ch >= '0' && ch <= '9') {
                    sb.append(ch);
                }
                // 연산자일 경우
                else {
                    // 우선순위 비교
                    while (!op.isEmpty() && operator.get(op.peek()) >= operator.get(ch)) {
                        sb.append(op.pop());
                    }
                    op.push(ch);
                }
            }

            // 문자열 탐색 후 남은 스택의 연산자들을 결과에 추가
            while (!op.isEmpty()) {
                sb.append(op.pop());
            }

            System.out.println("후위 표기법 변환 결과: " + sb);
        }
    }
}
