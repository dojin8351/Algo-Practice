package swea.d5;

import java.util.*;

public class No1248_공통조상 {
    static int[][] tree;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int test = 1; test <= testCase; test++) {
            // 정점의 개수
            int V = sc.nextInt();
            tree = new int[V + 1][2]; // 트리를 위한 2차원 배열 초기화
            parent = new int[V + 1]; // 부모 노드를 추적하기 위한 배열

            // 간선의 개수
            int E = sc.nextInt();
            int target1 = sc.nextInt();
            int target2 = sc.nextInt();

            // 트리 구성
            for (int i = 1; i <= V; i++) {
                parent[i] = 0;
            }
            for (int i = 0; i < E; i++) {
                int p = sc.nextInt();
                int c = sc.nextInt();

                if (tree[p][0] == 0) { // 왼쪽 자식
                    tree[p][0] = c;
                } else { // 오른쪽 자식
                    tree[p][1] = c;
                }
                parent[c] = p; // 자식의 부모를 저장
            }

            // 공통 조상
            int common = findCommon(target1, target2);
            System.out.println("#" + test + " " + common + " " + (childCnt(tree, common) + 1));

        }
    }
    public static int childCnt(int[][] tree, int parent) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[tree.length];

        // 탐색 시작 노드 추가
        queue.offer(parent);
        visited[parent] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 0; i < 2; i++) {
                int child = tree[current][i];
                // 유효한 자식 노드 && 방문하지 않은 노드
                if (child != 0 && !visited[child]) {
                    queue.offer(child); // 큐에 추가
                    visited[child] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 공통 조상 찾기
    public static int findCommon(int target1, int target2) {
        // 각 노드의 조상 추적
        Set<Integer> ancestorsOfTarget1 = new HashSet<>();

        // 첫 번째 타겟의 모든 조상 저장
        int current = target1;
        while (current != 0) {
            ancestorsOfTarget1.add(current);
            current = parent[current];
        }

        // 두 번째 타겟의 조상을 따라가며 공통 노드 탐색
        current = target2;
        while (current != 0) {
            if (ancestorsOfTarget1.contains(current)) { // 공통 조상 발견
                return current;
            }
            current = parent[current];
        }
        return -1; // 공통 조상 없음
    }
}