package study;

import java.util.*;

public class Tree_순회DFS버전 {

    static Map<Integer, List<Integer>> tree = new HashMap<>(); // 트리를 인접 리스트로 저장
    static int[] parent; // 부모 노드 배열
    static int V; // 트리의 노드 개수

    // 전위 순회 (Pre-order)
    public static void preOrder(int node) {
        if (node == 0) return; // 유효하지 않은 노드
        System.out.print(node + " "); // 현재 노드 방문
        for (int child : tree.getOrDefault(node, new ArrayList<>())) { // 자식들 방문
            preOrder(child);
        }
    }

    // 중위 순회 (In-order) - 왼쪽 자식 → 현재 노드 → 오른쪽 자식
    public static void inOrder(int node) {
        if (node == 0) return;
        List<Integer> children = tree.getOrDefault(node, new ArrayList<>());
        if (children.size() > 0) inOrder(children.get(0)); // 왼쪽 자식이 있다면 방문
        System.out.print(node + " "); // 현재 노드 방문
        if (children.size() > 1) inOrder(children.get(1)); // 오른쪽 자식이 있다면 방문
    }

    // 후위 순회 (Post-order) - 왼쪽 → 오른쪽 → 현재 노드
    public static void postOrder(int node) {
        if (node == 0) return;
        for (int child : tree.getOrDefault(node, new ArrayList<>())) { // 자식 탐색
            postOrder(child);
        }
        System.out.print(node + " "); // 자식 방문 이후 현재 노드 방문
    }

    // DFS를 이용한 트리 구성 및 탐색
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("노드 개수를 입력하세요: ");
        V = sc.nextInt(); // 노드 개수

        parent = new int[V + 1]; // 부모 정보 저장 (1-based index)

        System.out.println("간선 정보를 입력하세요: (부모 자식)");
        for (int i = 0; i < V - 1; i++) { // V개의 노드에는 V-1개의 간선
            int p = sc.nextInt(); // 부모 노드
            int c = sc.nextInt(); // 자식 노드

            // 트리를 인접 리스트로 구성
            tree.putIfAbsent(p, new ArrayList<>());
            tree.get(p).add(c);

            // 부모 정보 저장
            parent[c] = p;
        }

        // 루트 노드 찾기 (부모가 없는 노드)
        int root = 0;
        for (int i = 1; i <= V; i++) {
            if (parent[i] == 0) {
                root = i;
                break;
            }
        }

        System.out.println("\n전위 순회 (Pre-order):");
        preOrder(root);

        System.out.println("\n\n중위 순회 (In-order):");
        inOrder(root);

        System.out.println("\n\n후위 순회 (Post-order):");
        postOrder(root);
    }
}