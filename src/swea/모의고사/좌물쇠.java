package swea.모의고사;

import java.util.*;

public class 좌물쇠 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int test = 1; test <= testCase; test++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            String input = sc.next();
            char[] ch = input.toCharArray();

            // 중복 제거를 위한 Set 사용
            Set<String> set = new HashSet<>();
            Deque<Character> deque = new ArrayDeque<>();

            // Deque 에 값 추가
            for (char c : ch) {
                deque.offerLast(c);
            }

            // 전체 회전 (N번 회전)
            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder();
                // deque에 담아놓은 요소들을 뽑아주기 위한 도구
                Iterator<Character> iter = deque.iterator();
                int idx = 0;

                // 현재 상태에서 N/4개씩 블록 생성
                while (iter.hasNext()) {
                    sb.append(iter.next());
                    idx++;
                    if (idx % (N / 4) == 0) {
                        set.add(sb.toString());
                        sb.setLength(0);
                    }
                }
                //맨 뒤에서 빼서 앞으로 삽입
                deque.offerFirst(deque.pollLast());
            }

            List<Long> numbers = new ArrayList<>();
            for (String hex : set) {
                // 16진수 -> 10진수
                numbers.add(Long.parseLong(hex, 16));
            }
            // 정렬해준다.
            numbers.sort(Collections.reverseOrder());

            // K값 유효성 검증 후 출력
            System.out.println("#" + test + " " + numbers.get(K - 1));
        }
    }
}