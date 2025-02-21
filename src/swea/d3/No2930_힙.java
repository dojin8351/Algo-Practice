package swea.d3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No2930_힙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int test = 1; test <= testCase; test++) {
            // 최대힙 정렬
            PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
            StringBuilder sb = new StringBuilder();
            int cnt = sc.nextInt();
            sb.append("#").append(test).append(" ");
            for(int i = 0; i < cnt; i++) {
                int caseNum = sc.nextInt();

                if(caseNum == 1) {
                    int value = sc.nextInt();
                    maxPq.offer(value);

                } else if(caseNum == 2) {
                    if(maxPq.isEmpty()) {
                        sb.append("-1").append(" ");
                    } else {
                        sb.append(maxPq.poll()).append(" ");
                    }
                }
            }
            System.out.println(sb);
        }
    }
}
