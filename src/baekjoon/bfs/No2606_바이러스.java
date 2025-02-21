package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2606_바이러스 {
    /*
        - 컴퓨터 간 네트워크 연결 정보를 저장하고, 바이러스에 감염된 컴퓨터를 확인하는 문제
     */
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int comCnt;
    static int crossLine;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        comCnt = Integer.parseInt(br.readLine()); // 컴퓨터 수
        crossLine = Integer.parseInt(br.readLine()); // 네트워크 연결 수

        // 네트워크 연결 정보 입력
        for (int i = 0; i < crossLine; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int com1 = inputs[0];
            int com2 = inputs[1];

            // 키가 존재 하지 않으면 빈 리스트 생성후 키 에 value 추가
            map.putIfAbsent(com1, new ArrayList<>());
            map.get(com1).add(com2);

            map.putIfAbsent(com2, new ArrayList<>());
            map.get(com2).add(com1);
        }

        System.out.println(bfs(4));

    }

    public static int bfs(int com) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[comCnt + 1];

        queue.offer(com); // 시작 컴퓨터 삽입
        visited[com] = true;
        int virus = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            List<Integer> nodes = map.get(current);

            if (nodes != null) {
                for (int next : nodes) {
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                        virus++;
                    }
                }
            }
        }

        return virus;
    }
}