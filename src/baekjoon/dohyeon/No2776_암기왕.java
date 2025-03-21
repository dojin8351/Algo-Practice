package baekjoon.dohyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No2776_암기왕 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> set = new HashSet<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int query = Integer.parseInt(st.nextToken());
                if (set.contains(query)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }

            System.out.print(sb);
        }

        br.close();
    }
}