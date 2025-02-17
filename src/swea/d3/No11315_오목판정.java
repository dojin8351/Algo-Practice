package swea.d3;

import java.util.Scanner;

public class No11315_오목판정 {
    // 8방향 탐색 dir
    static int[] dirY = {0,0,1,-1,1,1,-1,-1};
    static int[] dirX = {1,-1,0,0,1,-1,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase= sc.nextInt();

        for(int test = 1; test <= testCase; test++) {
            int size = sc.nextInt();
            char[][] boards = new char[size][size];
            for(int i = 0; i < size; i++) {
                boards[i] = sc.next().toCharArray();
            }

            boolean isOmok = false;
            for(int i = 0; i < boards.length; i++) {
                for(int j = 0; j < boards[i].length; j++) {

                    for(int dir = 0; dir < dirX.length; dir++) {
                        int cnt = 0;
                        for(int k = 0; k < 5; k++) {
                            int nextY = i + dirY[dir] * k;
                            int nextX = j + dirX[dir] * k;

                            if (nextX >= 0 && nextY >= 0 && nextX < size && nextY < size && boards[nextY][nextX] == 'o') {
                                cnt++;
                            }
                        }
                        if(cnt == 5) {
                            isOmok = true;
                            break;
                        }
                    }
                }
            }

            if(isOmok) {
                System.out.println("#" + test + " " + "YES");
            } else {
                System.out.println("#" + test + " " + "NO");
            }

        }
    }
}
