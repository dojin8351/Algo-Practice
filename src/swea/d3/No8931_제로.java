package swea.d3;

import java.util.Scanner;
public class No8931_제로 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int test = 1; test <= testCase; test++) {
            // java 스택으로 풀이
//            Stack<Integer> stack = new Stack<>();
//            int caseCnt = sc.nextInt();
//
//            for(int caseNum = 0; caseNum < caseCnt; caseNum++) {
//                int input = sc.nextInt();
//
//                if(input == 0) {
//                    stack.pop();
//                }else {
//                    stack.push(input);
//                }
//            }
//            int sum = 0;
//            while(!stack.isEmpty()) {
//                sum += stack.pop();
//            }
            
            // 내가 만든 스택
            MyStack myStack = new MyStack();
            int caseCnt = sc.nextInt();
            for(int caseNum = 0; caseNum < caseCnt; caseNum++) {
                int input = sc.nextInt();

                if(input == 0) {
                    myStack.pop();
                }else {
                    myStack.push(input);
                }
            }
            int sum = 0;
            while(!myStack.isEmpty()) {
                sum += myStack.pop();
            }

            System.out.println("#" + test + " " + sum);
        }

    }
}

class MyStack {
    private int size = 0;
    private int maxValue = 10000;
    int[] stack = new int[maxValue];

    public void push(int value) {
        if (size < maxValue) {
            stack[size++] = value;
        } else {
            // 사이즈를 넘어서면 maxValue 2배 크기의 배열을 새로만든다음
            // 기존 stack 배열을 클론해 저장해놓고
            // 새로 생성한 2배 크기의 배열에 갖다 붙여준다.
            int[] copyStack = stack.clone();
            stack = new int[maxValue *= 2];
            System.arraycopy(copyStack, 0, stack, 0, copyStack.length);
            stack[size++] = value;
        }
    }

    // 사이즈 0이면 오류 메시지, 아니라면 크기 줄이고 반환
    public int pop() {
        if (size == 0) {
            System.out.println("스택 빔");
        }
        return stack[--size]; // 크기를 줄이고 반환
    }

    public int peek() {
        if (size == 0) {
            System.out.println("스택 빔");
        }
        return stack[size - 1];
    }

    // 사이즈 0 이면 트루
    public boolean isEmpty() {
        return size == 0;
    }
}



