package baekjoon.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15649_N과M1 {
    static List<List<Integer>> results;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        results = new ArrayList<>();
        combine(arr,M, 0,new ArrayList<>(), results);
        StringBuilder sb = new StringBuilder();
        for(List<Integer> result : results) {
            sb.append(result.toString().replace("[","").replace("]","").replace(",","")).append("\n");
        }
        System.out.println(sb);
    }

    public static void combine(int[] arr, int size, int idx, List<Integer> cur, List<List<Integer>> result) {
        if(cur.size() == size) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            cur.add(arr[i]);

            combine(arr, size, i, cur, result);

            cur.remove(cur.size()-1);
        }
    }
}
