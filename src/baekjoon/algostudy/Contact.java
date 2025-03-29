package baekjoon.algostudy;

import java.util.*;

public class Contact {
    static Map<Integer, Set<Integer>> callMap; // 연락망 그래프
    static int startPoint; // 시작점
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 10; // 테스트 케이스 수

        for (int t = 1; t <= tc; t++) {
            callMap = new HashMap<>();
            int size = sc.nextInt();
            startPoint = sc.nextInt();

            // 입력 받아서 callMap에 저장
            for (int i = 0; i < size / 2; i++) {
                int key = sc.nextInt();
                int value = sc.nextInt();

                callMap.putIfAbsent(key, new HashSet<>());
                callMap.get(key).add(value);
            }

            int result = bfs(startPoint);
            System.out.println("#" + t + " " + result);
        }
    }

    /**
     *
     * @param start : 처음 주어지는 시작점
     * @return : 마지막 계층? 노드들 중에서 가장 큰 값
     */
    private static int bfs(int start) {
        // 문제의 조건에서 서로 마주보면서 전화했던 사람에게 다시 할 수 도 있다는 점에서
        // visited를 set을 이용해 만듬
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        // bfs순회하면서 같은계층? 에서 순회하는 자식들을 lastNode에 저장해준다
        List<Integer> lastNode = new ArrayList<>();

        while (!queue.isEmpty()) {
            // 계층?단계? 를 구분해주기 위해서 사용
            int size = queue.size();
            lastNode = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                // 넣어놓은 자식을 가지고온다.
                int current = queue.poll();

                lastNode.add(current);

                // 현재 노드의 자식 순회
                if (callMap.containsKey(current)) {
                    // 키로 value 를 가져와 순회
                    for (int next : callMap.get(current)) {
                        // 만약 visited에 등록되지 않았다면 추가해주고 queue에도 추가해준다.
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        // 위의 lastNode에 저장된 값들중 가장 큰 값을 출력해준다.
        return Collections.max(lastNode);
    }
}