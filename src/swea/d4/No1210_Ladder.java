package swea.d4;
import java.util.Scanner;

public class No1210_Ladder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int testCase = 1; testCase <= 10; testCase++) {
            sc.nextInt();

            int[][] board = new int[100][100];
            int endX = 99, endY = 0;

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    board[i][j] = sc.nextInt();
                    if (board[i][j] == 2) {
                        endY = j;
                    }
                }
            }
            int curX = endX;
            int curY = endY;
            // 맨 위에 도착하면 끄읏
            while (curX > 0) {

                curX--;
                // 왼쪽으로 1이 아닐때까지 쭈욱
                if (curY > 0 && board[curX][curY - 1] == 1) {
                    while (curY > 0 && board[curX][curY - 1] == 1) {
                        curY--;
                    }
                    // 오른쪽으로 1이 아닐때까지 쭈욱
                } else if (curY < 99 && board[curX][curY + 1] == 1) {
                    while (curY < 99 && board[curX][curY + 1] == 1) {
                        curY++;
                    }
                }
                //1이 아니면 이제 새로 반복시작 하면서 행을 위로 올려준다.
            }

            System.out.println("#" + testCase + " " + curY);
        }
    }
}
