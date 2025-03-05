package swea.모의고사;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 요리사 {
    static int[][] boards;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt(); // 테스트 케이스 수
        for (int test = 1; test <= testCase; test++) {
            int size = sc.nextInt(); // 재료 개수
            boards = new int[size][size];
            List<List<Integer>> result = new ArrayList<>();

            // 시너지 테이블 입력
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    boards[i][j] = sc.nextInt();
                }
            }

            // 재료 인덱스를 담은 배열
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }

            // 팀 조합 생성
            combine(arr, size / 2, 0, result, new ArrayList<>());

            int min = Integer.MAX_VALUE;

            // 각 조합별로 탐색
            for (List<Integer> list : result) {
                List<Integer> anotherList = new ArrayList<>();
                for (int value : arr) {
                    if (!list.contains(value)) {
                        anotherList.add(value);
                    }
                }

                min = Math.min(min, Math.abs(cal(list) - cal(anotherList)));
            }

            System.out.println("#" + test + " " + min);
        }
    }

    // 조합 생성 메서드
    static void combine(int[] arr, int size, int idx, List<List<Integer>> result, List<Integer> current) {
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

    static int cal(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        combine(arr, 2, 0, result, new ArrayList<>());

        int sum = 0;

        for (List<Integer> point : result) {
            int x = point.get(0);
            int y = point.get(1);
            sum += boards[x][y] + boards[y][x];
        }

        return sum; // 총 시너지 값 반환
    }
}