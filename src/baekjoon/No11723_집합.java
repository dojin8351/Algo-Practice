package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11723_집합 {
    static String order;
    static int x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseCnt = Integer.parseInt(br.readLine());
        int[] arr = new int[21];

        for(int i = 0; i < caseCnt; i++) {
            String[] inputs = br.readLine().split(" ");
            if(inputs.length == 2) {
                order = inputs[0];
                x = Integer.parseInt(inputs[1]);
            } else {
                order = inputs[0];
            }

            if(order.equals("add")) {
                arr[x] = x;
            } else if(order.equals("check")) {
                if(arr[x] != 0) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if(order.equals("remove")) {
                arr[x] = 0;
            } else if(order.equals("toggle")) {
                if(arr[x] != 0) {
                    arr[x] = 0;
                } else {
                    arr[x] = x;
                }
            } else if(order.equals("all")) {
                int num = 1;
                for(int j = 1; j < arr.length; j++) {
                    arr[j] = num++;
                }
            } else if(order.equals("empty")) {
                for(int j = 1; j < arr.length; j++) {
                    arr[j] = 0;
                }
            }
        }
        System.out.print(sb);
    }
}
