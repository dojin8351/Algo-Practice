package baekjoon.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15649_N과M1 {

    static List<List<Integer>> results; // 결과 저장할 리스트
    static int[] arr;                   // 입력 배열
    static boolean[] visited;           // 방문 체크용 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 사용자 입력 처리
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = inputs[0]; // N: 배열 크기
        int M = inputs[1]; // M: 선택할 숫자의 개수

        arr = new int[N];
        visited = new boolean[N];
        results = new ArrayList<>();

        // 배열 초기화 (1부터 N까지 숫자)
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        // 순열 생성 함수 호출
        generatePermutations(M, new ArrayList<>());

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (List<Integer> result : results) {
            sb.append(result.toString().replace("[", "").replace("]", "").replace(",","")).append("\n");
        }
        System.out.println(sb);
    }

    // 순열 생성 함수: 백트래킹 기반
    public static void generatePermutations(int size, List<Integer> current) {
        // 목표 크기의 순열을 생성한 경우
        if (current.size() == size) {
            results.add(new ArrayList<>(current)); // 현재 순열을 깊은 복사해 결과에 추가
            return;
        }

        // 배열의 모든 요소를 탐색
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) { // 아직 방문하지 않은 경우
                visited[i] = true;        // 방문 표시
                current.add(arr[i]);     // 현재 숫자 추가

                generatePermutations(size, current); // 재귀 호출로 순열 확장

                // 백트래킹: 상태 복원
                current.remove(current.size() - 1); // 마지막에 추가한 숫자 제거
                visited[i] = false;                // 방문 표시 해제
            }
        }
    }
}