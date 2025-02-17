package swea.d2;

import java.util.Scanner;

public class No1926_간단한369게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            String str = String.valueOf(i); // 숫자를 문자열로 변환
            boolean hasClap = false; // 박수 여부 확인 변수

            for (char ch : str.toCharArray()) { // 각 자리 숫자 확인
                if (ch == '3' || ch == '6' || ch == '9') {
                    sb.append("-");
                    hasClap = true; // 박수로 처리
                }
            }

            if (!hasClap) { // 박수가 없는 경우 원래 숫자 추가
                sb.append(str);
            }

            sb.append(" "); // 숫자와 숫자 사이 공백
        }

        System.out.println(sb);
    }
}