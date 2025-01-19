package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] buckets = new int[N];

        for(int i = 0; i < N; i++){
            buckets[i] = i + 1;
        }

        for(int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]) - 1;
            int b = Integer.parseInt(temp[1]) - 1;

            while(a < b) {
                int value = buckets[a];
                buckets[a] = buckets[b];
                buckets[b] = value;

                a++;
                b--;
            }
        }
        for(int bucket : buckets){
            System.out.print(bucket + " ");
        }
    }
}
