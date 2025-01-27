package baekjoon;

import java.util.*;

public class No3985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int N = sc.nextInt();

        int[] rollCake = new int[L];
        Map<Integer, Integer> cakeMap = new HashMap<>();
        int differenceValue = 0;
        int expectationsPerson = 0;


        for(int i = 0; i < N; i++) {
            int P = sc.nextInt();
            int K = sc.nextInt();
            if(differenceValue < K - P) {
                differenceValue = K - P;
                expectationsPerson = i+1;
            }
            for(int j = P-1; j < K; j++) {
                if(rollCake[j] != 0){
                    continue;
                }
                rollCake[j] = i+1;
            }
        }

        for(int i = 0; i < N; i++) {
            int cakeCount = 0;
            for(int j = 0; j < L; j++) {
                if(rollCake[j] == i+1) {
                    cakeCount++;
                }
            }
            cakeMap.put(i+1, cakeCount);
        }

        int max = 0;
        int keyNum = 0;
        for(Integer key : cakeMap.keySet()) {
            if(cakeMap.get(key) > max) {
                max = cakeMap.get(key);
                keyNum = key;
            }
        }

        System.out.println(expectationsPerson);
        System.out.println(keyNum);


    }
}
