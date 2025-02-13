package swea.d3;

import java.util.Scanner;

public class No1216_회문2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int boardSize = 100;

        for (int testCase = 1; testCase <= 10; testCase++) {
            int t =sc.nextInt();
            char[][] board = new char[boardSize][boardSize];

            for (int i = 0; i < boardSize; i++) {
                board[i] = sc.next().toCharArray();
            }

            int maxLength = 1;

            // 가로 검사
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    for (int k = j; k < boardSize; k++) {
                        if (isPalindrome(board[i], j, k)) {
                            maxLength = Math.max(maxLength, k - j + 1);
                        }
                    }
                }
            }

            // 배열을 90도 우측으로 돌린다다음 다시 가로 검사 = 세로검사
            char[][] rotatedBoard = rotation90(board);
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    for (int k = j; k < boardSize; k++) {
                        if (isPalindrome(rotatedBoard[i], j, k)) {
                            maxLength = Math.max(maxLength, k - j + 1);
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", t, maxLength);
        }
    }
    
    // 검사할 배열과 시작 끝 점을 넣어주면 앞,끝 쪽에서 1씩 쪼여오면서 검사해오는 방식으로 회문 검사
    private static boolean isPalindrome(char[] array, int start, int end) {
        while (start < end) {
            if (array[start] != array[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    // 넘겨받은 배열을 우측 90 도로 돌려주는 메서드
    private static char[][] rotation90(char[][] board) {
        // 90도 돌린 배열을 받아줄 배열 생성
        char[][] rotatedBoard = new char[board[0].length][board.length];
        
        // 90 도 돌려주는 과정
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                rotatedBoard[j][board.length - i - 1] = board[i][j];
            }
        }
        return rotatedBoard;
    }

}