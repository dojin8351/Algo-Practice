package baekjoon;

import java.util.Scanner;

public class No2567 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
            처음에는 단순히 그림 예제만 보고 겉사각형의 둘레를 구하고 안의 작은 사각혀으이 둘레를 구해 빼주면 되겠다 라고 생각하고 접근
            그러나 잘못된 접근이라는것을 깨달음
            - 문제를 다시 읽어보고 도화지의 크기가 정해져있는것을 발견 paper라는 배열생성
            - 그후 입력받은 x.y좌표를 토대로 색종이 범위만큼 1값 입력
            - searchX, searchY값을 이용해 paper배열을 순회
            - 상하좌우 탐색중 어느 한곳이라도 1이 아니라면 그건 색종이의 변부분으로 생각후 perimeter값증가
         */
        int[][] paper = new int[101][101];
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    paper[j][k] = 1;
                }
            }
        }

        int perimeter = 0;
        
        // 한 지점에서 상하좌우 칠해져있는 공간이지 확인하기위한 탐색기
        // x축 y축 이아니라 x는 행, y는 열
        int[] searchX = {-1, 1, 0, 0};
        int[] searchY = {0, 0, -1, 1};

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (paper[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + searchX[d];
                        int ny = j + searchY[d];

                        if (nx < 0 || nx > 100 || ny < 0 || ny > 100 || paper[nx][ny] == 0) {
                            perimeter++;
                        }
                    }
                }
            }
        }

        System.out.println(perimeter);
    }
}
