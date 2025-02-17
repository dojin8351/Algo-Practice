package swea.d3;

import java.util.*;

public class No6190_정곤이의단조증가하는수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int test = 1; test <= testCase; test++) {
            int N = sc.nextInt();

            int[] arr = new int[N];
            List<Integer> forgingNums = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            for(int i = 0; i < arr.length; i++) {
                for(int j = i+1; j < arr.length; j++) {
                    int forgingNum = arr[i] * arr[j];
                    if (isForgingNum(forgingNum)) {
                        forgingNums.add(forgingNum);
                    }
                }
            }

            forgingNums.sort(Collections.reverseOrder());
            if(forgingNums.isEmpty()) {
                System.out.println("#" + test + " " + -1);
            } else {
                System.out.println("#" + test + " " + forgingNums.get(0));
            }


        }
    }
    static boolean isForgingNum (int num) {
        boolean isForging = true;
        String str = String.valueOf(num);
        int[] strs = Arrays.stream(str.split("")).mapToInt(Integer :: parseInt).toArray();

        for(int i = 1; i < strs.length; i++) {
            if (strs[i] < strs[i-1]) {
                isForging = false;
                break;
            }
        }
        return isForging;
    }
}
