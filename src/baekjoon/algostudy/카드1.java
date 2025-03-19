package baekjoon.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 카드1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        List<Integer> trash = new ArrayList<>();

        while (queue.size() > 1) { // 큐에 카드가 하나 남을 때까지 반복
            // 제일 위 카드 제거
            trash.add(queue.poll());
            // 제일 위 카드 아래로 이동 (남은 카드가 있을 경우에만 이동)
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }

        // 마지막 남은 카드 추가 (필요하다면)
        if (!queue.isEmpty()) {
            trash.add(queue.poll());
        }

        for(int value : trash) {
            System.out.print(value + " ");
        }
    }
}