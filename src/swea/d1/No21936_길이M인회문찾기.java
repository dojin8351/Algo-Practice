package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No21936_길이M인회문찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int test = 1; test <= testCase; test++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = input[0];
            int M = input[1];
            String inputStr = br.readLine();
            char[] chars = inputStr.toCharArray();

            StringBuilder result = new StringBuilder();
            for(int i = 0; i <= N -M; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = i; j < i+M; j++) {
                    sb.append(chars[j]);
                }
                if(sb.toString().contentEquals(sb.reverse().toString())) {
                    result.append(sb);
                }
            }

            if(result.isEmpty()) {
                System.out.println("#" + test + " " + "NONE");
            } else {
                System.out.println("#" + test + " " + result);
            }
        }


    }
}
