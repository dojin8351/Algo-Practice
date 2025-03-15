package baekjoon.dohyeon;

import java.io.*;
import java.util.Stack;

public class No28278 {

    /*
        1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
        2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
        3: 스택에 들어있는 정수의 개수를 출력한다.
        4: 스택이 비어있으면 1, 아니면 0을 출력한다.
        5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.

        스캐너로 풀어봤는데 시간 초과나서 bufferedreader 사용해서 다시풀었음
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> st = new Stack<>();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);

            switch (a) {
                case 1:
                    int b = Integer.parseInt(input[1]);
                    st.push(b);
                    break;
                case 2:
                    if (st.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(st.pop()).append("\n");
                    }
                    break;
                case 3:
                    sb.append(st.size()).append("\n");
                    break;
                case 4:
                    sb.append(st.isEmpty() ? "1\n" : "0\n");
                    break;
                case 5:
                    if (st.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(st.peek()).append("\n");
                    }
                    break;
            }
        }

        System.out.print(sb);
    }
}
