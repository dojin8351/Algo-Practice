package baekjoon.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15651_N과M3 {
    static List<List<Integer>> results;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 사용자 입력 처리
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = inputs[0]; // N: 배열 크기
        int M = inputs[1]; // M: 선택할 숫자의 개수

        arr = new int[N];
        results = new ArrayList<>();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        func(M,new ArrayList<>(), 0);

        StringBuilder sb = new StringBuilder();
        for (List<Integer> result : results) {
            sb.append(result.toString().replace("[", "").replace("]", "").replace(",","")).append("\n");
        }
        System.out.println(sb);
    }

    public static void func(int size, List<Integer> cur, int idx) {
        if (cur.size() == size) {
            results.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < arr.length; i++) { // idx부터 시작
            if (!visited[i]) {
                cur.add(arr[i]);
                visited[i] = true;

                func(size, cur, i); // i를 인자로 넘깁니다.
                visited[i] = false; // 백트래킹
                cur.remove(cur.size() - 1); // 마지막 원소 제거(backtracking)
            }
        }
    }
}
