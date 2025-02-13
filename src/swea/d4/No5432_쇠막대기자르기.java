package swea.d4;

import java.util.Scanner;
import java.util.Stack;

public class No5432_쇠막대기자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        sc.nextLine();

        for (int test = 1; test <= testCase; test++) {
            Stack<Integer> stack = new Stack<>();  // '('의 인덱스를 저장
            int sum = 0;
            String input = sc.next().trim();
            char[] inputChars = input.toCharArray();

            for (int i = 0; i < inputChars.length; i++) {
                if (inputChars[i] == '(') {
                    // '('일 때 스택에 넣음
                    stack.push(i);
                } else if (inputChars[i] == ')') {
                    // ')'일 때 레이저 처리
                    if (inputChars[i - 1] == '(') {
                        // 레이저인 경우
                        stack.pop();
                        sum += stack.size();  // 레이저는 스택에 있는 '('의 개수만큼 잘라짐
                    } else {
                        // 레이저가 아닌 경우 (쇠막대기의 끝인 경우)
                        stack.pop();
                        sum += 1;  // 하나의 쇠막대기가 끝난 것으로 처리
                    }
                }
            }
            System.out.println("#" + test + " " + sum);
        }

        sc.close();
    }
}
