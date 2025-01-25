package baekjoon;

import java.util.Scanner;
import java.util.regex.*;

public class No17413 {
    public static void main(String[] args) {
        // 예시 입력
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // 정규표현식: 태그는 그대로, 단어는 뒤집어서 처리
        Pattern pattern = Pattern.compile("<[^<>]*>|\\S+|\\s+");
        Matcher matcher = pattern.matcher(input);

        StringBuilder result = new StringBuilder();

        // 매칭된 결과를 처리하여 결과 문자열 생성
        while (matcher.find()) {
            String matched = matcher.group();

            // 태그는 그대로 출력
            if (matched.startsWith("<") && matched.endsWith(">")) {
                result.append(matched);
            }
            // 태그 외의 문자열은 뒤집어서 출력
            else {
                result.append(new StringBuilder(matched).reverse().toString());
            }
        }

        // 결과 출력
        System.out.println(result.toString());
    }
}
