package swea.d2;

import java.util.*;

public class No1983 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] grade = {"A+", "A0", "A-", "B+", "B0" ,"B-", "C+", "C0", "C-", "D0"};
        int T  = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int stu = sc.nextInt();
            int index = sc.nextInt();

            Map<Integer, Double> avgMap = new HashMap<>();
            Double[] avgArr = new Double[stu];

            for(int j = 0; j < stu; j++) {

                int midtermScore = sc.nextInt();
                int finalScore = sc.nextInt();
                int assignment = sc.nextInt();

                avgArr[j] = midtermScore * 0.35 + finalScore * 0.45 + assignment * 0.2;
                avgMap.put(j, avgArr[j]);
            }

            Arrays.sort(avgArr, Collections.reverseOrder());
            Double result = avgMap.get(index -1);
            int resultIndex = 0;
            for(int j = 0; j < avgArr.length; j++) {
                if(Objects.equals(result, avgArr[j])) {
                    resultIndex = j;
                }
            }

            if(stu > 10) {
                resultIndex = resultIndex / (stu/10);
            }

            System.out.printf("#%d %s\n",i + 1, grade[resultIndex]);

        }
    }
}
