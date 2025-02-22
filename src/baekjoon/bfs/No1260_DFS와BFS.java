package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1260_DFS와BFS {
    static List<Integer>[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        int nodeCnt = inputs[0];
        int crossCnt = inputs[1];
        int startNode = inputs[2];

        nodes = new ArrayList[nodeCnt + 1];
        for (int i = 0; i <= nodeCnt; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < crossCnt; i++) {
            int[] inputs2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
            int parentNode = inputs2[0];
            int childNode = inputs2[1];
            nodes[parentNode].add(childNode);
        }
        System.out.println(dfs(startNode));
        System.out.println(bfs(startNode));
    }

    public static List<Integer> bfs(int start) {
        List<Integer> result = new ArrayList<>(); // 순서를 유지하는 리스트
        boolean[] visited = new boolean[nodes.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            List<Integer> next = nodes[current];
            for (Integer node : next) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.offer(node);
                }
            }
        }
        return result;
    }

    public static List<Integer> dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>(); // 방문 순서를 저장할 리스트
        boolean[] visited = new boolean[nodes.length];
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited[current]) {
                visited[current] = true;
                result.add(current); // 방문한 정점을 결과 리스트에 추가

                // 스택에 연결된 노드를 뒤에서부터 추가 (작은 번호가 먼저 탐색되도록)
                List<Integer> neighbors = nodes[current];
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int next = neighbors.get(i);
                    if (!visited[next]) {
                        stack.push(next);
                    }
                }
            }
        }
        return result; // 방문한 순서를 포함한 리스트 반환
    }

}

