package swea.모의고사;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 요리사 {
    static int[][] boards;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for (int test = 1; test <= testCase; test++) {
            int size = sc.nextInt();
            boards = new int[size][size];
            List<List<Integer>> result = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    boards[i][j] = sc.nextInt();
                }
            }

            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }

            // n/2 사이즈의 부분집합을 만들어 위의 result에 넣어주는역할
            combine(arr, size / 2, 0, result, new ArrayList<>());

            // 최소값 변수 설정
            int min = Integer.MAX_VALUE;

            // result리스트 안에 담겨있는 값들을 순회 하면서 [0,1,2]의 집합이라면 [3,4,5] 처럼 사용하지 않는 재료의 리스트를
            // anotherList에 담아준다
            for (List<Integer> list : result) {
                List<Integer> anotherList = new ArrayList<>();
                for (int value : arr) {
                    if (!list.contains(value)) {
                        anotherList.add(value);
                    }
                }
                // call함수에 각각 2가지의 요리재료의 리스트를 넣어준 다음 연산
                min = Math.min(min, Math.abs(cal(list) - cal(anotherList)));
            }

            // 결과 출력
            System.out.println("#" + test + " " + min);
        }
    }

    /**
     *
     * @param arr : 부분 집합을 생성할때 참조할 부모 배열
     * @param size : 만들 부분집합의 크기
     * @param idx : 인덱스
     * @param result : 만들어진 부분집합을 한곳에 모아줄 통합 결과 리스트
     * @param current : 부분집합 리스트
     */
    static void combine(int[] arr, int size, int idx, List<List<Integer>> result, List<Integer> current) {
        // current의 사이즈가 size가 된다면 result에 current 리스트를 추가해주고 종료
        if (current.size() == size) {
            result.add(new ArrayList<>(current));
            return;
        }


        for (int i = idx; i < arr.length; i++) {
            current.add(arr[i]);
            combine(arr, size, i + 1, result, current);
            current.remove(current.size() - 1);
        }
    }

    /**
     *
     * @param list : 요리 재료가 담긴 리스트
     * @return : 음식의 맛
     */
    static int cal(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        // 리스트를 배열로 변환
        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        // 받아온 요리재료 리스트를 다시한번 combine을 사용해 부분집합을 생성한다.
        combine(arr, 2, 0, result, new ArrayList<>());

        int sum = 0;

        for (List<Integer> point : result) {
            int x = point.get(0);
            int y = point.get(1);
            sum += boards[x][y] + boards[y][x];
        }

        return sum;
    }
}