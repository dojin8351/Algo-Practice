package test.월말대비;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class No1218_괄호짝짓기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = 10;
        for (int test = 1; test <= testCase; test++) {
            sc.nextInt(); // 입력 길이 무시 가능
            String input = sc.next();
            Deque<Character> deque = new ArrayDeque<>();
            boolean isValid = true;

            for (char ch : input.toCharArray()) {
                // 열리는 괄호라면 스택에 추가
                if ("({[<".indexOf(ch) != -1) {
                    deque.push(ch);
                }
                // 닫히는 괄호라면 스택에서 꺼내 검사
                else {
                    if (deque.isEmpty() || !isMatching(deque.pop(), ch)) {
                        isValid = false;
                        break;
                    }
                }
            }

            // 입력 처리 후 스택이 비어있지 않다면 유효하지 않음
            if (!deque.isEmpty()) {
                isValid = false;
            }

            System.out.println(isValid ? 1 : 0);
        }
    }

    // 괄호 매칭을 확인하는 헬퍼 메서드
    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}') ||
                (open == '<' && close == '>');
    }
}