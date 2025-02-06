package swea.d3;

import java.util.Scanner;

public class No1206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 10; i++) {
            int N = sc.nextInt();
            int[] buildings = new int[N];
            for(int j = 0; j < N; j++) {
                buildings[j] = sc.nextInt();
            }

            int totalSum = 0;
            // 탐색중인 빌딩 주변의 빌딩 높이 최댓값을 구한후 만약 그 탐색중인 빌딩의 높아가 주변건물들의
            // 최대 높이보다 높다면 뷰를 가리는 건물이 없다는 뜻 totalSum에 현재빌딩높이 - 주변건물최대높이 한값을
            // 추가 끄읏
            for(int j = 2; j < buildings.length - 2; j++) {
                int highestSideBuilding = Math.max(Math.max(buildings[j - 2], buildings[j - 1]), Math.max(buildings[j + 1], buildings[j + 2]));
                if(buildings[j] > highestSideBuilding) {
                    totalSum += buildings[j] - highestSideBuilding;
                }
            }

            System.out.printf("#%d %d\n", i+1, totalSum);
        }
    }
}
