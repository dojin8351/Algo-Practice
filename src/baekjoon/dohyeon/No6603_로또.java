package baekjoon.dohyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No6603_로또 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
            if(inputs[0] == 0) {
                break;
            }
            int[] nums = new int[inputs[0]];
            for(int i = 1; i < inputs.length; i++) {
                nums[i-1] = inputs[i];
            }

            List<List<Integer>> results = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();

            combine(results,cur,nums,6,0);
            StringBuilder sb = new StringBuilder();

            for(List<Integer> result : results) {
                sb.append(result.toString().replace("[", "").replace("]", "").replace(",","")).append("\n");
            }
            System.out.println(sb);
        }

    }

    public static void combine(List<List<Integer>> result, List<Integer> cur, int[] arr, int size, int idx) {
        if(cur.size() == size) {
            result.add(new ArrayList<>(cur));
        }

        for(int i = idx; i < arr.length; i++) {
            cur.add(arr[i]);

            combine(result,cur,arr,size,i+1);

            cur.remove(cur.size() -1);
        }

    }
}
