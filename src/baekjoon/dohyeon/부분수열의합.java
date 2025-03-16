package baekjoon.dohyeon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 부분수열의합 {
    static int[] nums;
    static int S;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        S = inputs[1];
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        combine(new ArrayList<>(), 0,0);
        System.out.println(count);
    }

    public static void combine(List<Integer> cur, int idx, int sum) {
        for (int i = idx; i < nums.length; i++) {
            cur.add(nums[i]);
            if (sum + nums[i] == S) {
                count++;
            }

            combine(cur, i + 1, sum + nums[i]);

            cur.remove(cur.size() - 1);
        }
    }
}