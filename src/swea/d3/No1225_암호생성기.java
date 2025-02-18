package swea.d3;

import java.util.*;
import java.util.stream.Collectors;

public class No1225_암호생성기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test = 1; test <= 1; test++) { // 여러 TestCase를 처리할 수 있도록 설계
            int testCase = sc.nextInt(); // 시험 번호 입력
            sc.nextLine();  // 입력 버퍼 비우기

            // 입력받은 수를 Deque에 저장
            Deque<Integer> deque = new ArrayDeque<>();
            String input = sc.nextLine();
            int[] inputs = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int value : inputs) {
                deque.offerLast(value); // 값을 뒤에 삽입
            }

            boolean done = false; // 종료 조건을 확인할 플래그
            while (!done) {
                for (int i = 1; i <= 5; i++) { // 1 ~ 5 사이클
                    Integer first = deque.pollFirst(); // 맨 앞 값을 꺼냄
                    int decreased = first - i; // 감소 처리

                    if (decreased <= 0) { // 값이 0 이하라면 종료
                        deque.offerLast(0); // 마지막 0 삽입
                        done = true; // 종료 조건 설정
                        break; // 현재 사이클 종료
                    }
                    deque.offerLast(decreased); // 감소한 값을 뒤에 추가
                }
            }

            // 출력
            System.out.printf("#%d ", testCase); // 테스트 케이스 번호 출력
            System.out.println(
                    deque.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(" ")) // 스트림을 정리하여 출력
            );
        }

        sc.close();  // 리소스 반환
    }
}