package baekjoon.dohyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1325_효율적인해킹 {
    static List<Integer>[] nodes;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        nodes = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 1; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            int[] inputs2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
            int A = inputs2[0];
            int B = inputs2[1];
            nodes[A].add(B);
        }

        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < nodes.length; i++) {
            if(!nodes[i].isEmpty()) {
                map.put(i,bfs(i));
            }
        }

        for(Integer key : map.keySet()) {
            System.out.println(map.get(key));
        }

    }

    public static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();

            if(!nodes[current].isEmpty()) {
                for(Integer nextNode : nodes[current]) {
                    if(!visited[nextNode]) {
                        queue.offer(nextNode);
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
