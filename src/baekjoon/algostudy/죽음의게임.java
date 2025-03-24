package baekjoon.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class 죽음의게임 {
    // n명 원탁에 둘러앉는다.
    // 시작하는 사람 0번 그 오른쪽 1번 그오른쪽 2번 N-1번의 오른쪽사람은 다시 0번
    /*
     * 0 -> 1
     * 1 -> 3
     * 2 -> 2
     * 3 -> 1
     * 4 -> 4
     *
     * 0 -> 1
     * 1 -> 3
     * 2 -> 5
     * 3 -> 4
     * 4 -> 0
     * 5 -> 2
     */
    static boolean[] visited;
    static Map<Integer,Integer> maps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int K = inputs[1];

        visited = new boolean[N];

        // 자료 저장
        for(int i = 0; i < N; i++) {
            maps.put(i, Integer.parseInt(br.readLine()));
        }

        for(int i = 0; i < N; i++) {

        }
    }
}
