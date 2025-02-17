package swea.d3;

import java.util.*;
import java.util.stream.Collectors;

public class No7102_준홍이의카드놀이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int test = 1; test <= testCase; test++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            Map<Integer, Integer> sumMap = new HashMap<>();

            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    // 중복된 키값이 계속 나오면 기존 value값에 +1을 더해준다
                    int value = sumMap.getOrDefault(i+j,0);
                    sumMap.put(i+j, value + 1);
                }
            }
            int max = 0;

            // key를 순회하면서 max value 찾아주기
            for(int key : sumMap.keySet()) {
                if(max <= sumMap.get(key)){
                    max = sumMap.get(key);
                }
            }
            System.out.print("#" + test + " ");

//             entry를 사용해 맵을 다시 순회하며 max와 value 값을 비교해 일치하면 그 키값을 출력
            for(Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                if(value == max) {
                    System.out.print(key + " ");
                }
            }

            System.out.println();
        }
    }
}
