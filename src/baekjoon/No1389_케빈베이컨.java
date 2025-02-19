package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1389_케빈베이컨 {
    static int N;
    static int M;
    static List<Integer>[] friendRelationship;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        // 유저의 수
        N = inputs[0];
        // 친구 관계의 수
        M = inputs[1];

        // 관계를 담아줄 리스트 타입 배열 생성
        friendRelationship = new ArrayList[N+1];

        // 사람이 1부터 시작이므로 나의 편리를 위해 1부터 생성;
        for(int i = 1; i < N + 1; i++) {
            friendRelationship[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            int[] friends = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
            int friendA = friends[0];
            int friendB = friends[1];
            // 양방향 관계 설정
            friendRelationship[friendA].add(friendB);
            friendRelationship[friendB].add(friendA);
        }

    }

    public static int bfs(int friend) {
        int relationShip = 0;
        boolean[] visited = new boolean[N+1];
        Queue<List<Integer>> queue = new LinkedList<>();


        return 0;
    }
}
