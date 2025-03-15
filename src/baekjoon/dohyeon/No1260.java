package baekjoon.dohyeon;

import java.util.*;

/*
    그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
    단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
    더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 */

public class No1260 {

    static void dfs(int v, boolean[] visited, List<Node> nodes) {
        // v를 순회했다면 visited[v]를 true 로 변경하면서 같은 곳을 순회하는것을 방지
        visited[v] = true;
        System.out.print(v + " ");

        // 해당 노드에 연결된 자식 노드들을 방문
        List<Node> children = new ArrayList<>(nodes.get(v).children);
        
        // n.data 기준으로 오름차순 정렬
        children.sort(Comparator.comparingInt(n -> n.data));

        // 정렬된 자식 노드들을 순차적으로 확인
        // 방문하지 않은 노드만 재귀적으로 방문
        for (Node child : children) {
            if (!visited[child.data]) {
                dfs(child.data, visited, nodes);
            }
        }
    }

    static void bfs(int v, boolean[] visited, List<Node> nodes) {
        // bfs에 사용할 큐
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes.get(v));
        visited[v] = true;
        
        // queue가 비어있지 않다면 계속 반복 하도록 조건 설정
        while (!queue.isEmpty()) {
            // 현재의 노드 값에 queue.poll()을 사용해서 현재 queue에 들어있는 제일 앞의 값을 빼서 Node에 넣어준다
            Node current = queue.poll();
            System.out.print(current.data + " ");

            // 위에서 넣어준 node의 자식 노드들을 탐색
            List<Node> children = new ArrayList<>(current.children);
            children.sort(Comparator.comparingInt(n -> n.data));

            // 자식 노드들 중 visited가 false라면 queue에 child의 data를 추가하고 visited 를 true로 변경
            for (Node child : children) {
                if (!visited[child.data]) {
                    queue.add(child);
                    visited[child.data] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N: 정점의 개수 (노드의 개수)
        // M: 간선의 개수 (연결된 노드 간의 관계 수)
        // V: 탐색 시작 노드 번호
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        List<Node> nodes = new ArrayList<>();

        // 노드 초기화
        for (int i = 0; i <= N; i++) {
            nodes.add(new Node(i));
        }

        // 노드 초기화 0번부터 N번까지의 Node 객체 생성
        // 0번 인덱스는 사용 X
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            nodes.get(a).children.add(nodes.get(b));
            nodes.get(b).children.add(nodes.get(a));
        }

        boolean[] visited = new boolean[N + 1];

        dfs(V, visited, nodes);
        System.out.println();
        
        // dfs 를 수행하면서 이미 위의 visited 의 배열이 수정이 되었으므로 다시 초기화해준다
        visited = new boolean[N + 1];
        bfs(V, visited, nodes);
    }

    /*
        Node 클래스 정의
        여러 자식 노드의 관계를 구성 할 수 있게 children 연결관계를 저장하는 리스트 가짐
     */
    static class Node {
        int data; // 정점 번호
        List<Node> children; // 자식들이 저장되는 리스트

        public Node(int data) {
            this.data = data;
            children = new ArrayList<>();
        }
    }
}


