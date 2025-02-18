package swea.d3.암호문1;


import java.util.*;

public class No1228_암호문1re {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = 10; // 테스트 케이스 횟수

        for (int test = 1; test <= testCase; test++) {
            // 원본 암호문의 길이와 데이터 입력받기
            int orgPwLength = sc.nextInt();
            List<String> orgPw = new LinkedList<>();
            for (int i = 0; i < orgPwLength; i++) {
                orgPw.add(sc.next());
            }

            // 명령어 입력받기
            int orderCnt = sc.nextInt();
            for (int i = 0; i < orderCnt; i++) {
                sc.next();
                int index = sc.nextInt();
                int strCnt = sc.nextInt();

                // 삽입할 데이터 처리
                List<String> insertList = new ArrayList<>();
                for (int j = 0; j < strCnt; j++) {
                    insertList.add(sc.next());
                }

                // 위치에 데이터 삽입
                orgPw.addAll(index, insertList);
            }

            // 결과 출력 (10개만)
            StringBuilder result = new StringBuilder();
            result.append("#").append(test).append(" ");
            for (int i = 0; i < 10; i++) {
                result.append(orgPw.get(i)).append(" ");
            }

            System.out.println(result.toString().trim());
        }
    }
}