package test.월말대비;

import java.util.*;

public class No5658_보물상자비밀번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int test = 1; test <= testCase; test++){
            sc.nextLine();
            // 주어지는 문자열의 길이
            int N = sc.nextInt();
            // K번째 큰 수 찾기
            int K = sc.nextInt();

            String inputStr = sc.next();
            char[] inputChars = inputStr.toCharArray();

            Deque<Character> lock = new ArrayDeque<>();
            for(char ch : inputChars) {
                lock.offerLast(ch);
            }

            Set<String> pws = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N/4; i++) {

                for (Character character : lock) {
                    sb.append(character);

                    if (sb.length() == N / 4) {
                        pws.add(sb.toString());
                        sb = new StringBuilder();
                    }
                }

                lock.offerFirst(lock.pollLast());
            }
            List<Integer> pw10 = new ArrayList<>();
            for(String pw : pws) {
                pw10.add(Integer.parseInt(pw,16));
            }

            pw10.sort(Collections.reverseOrder());
            sb.append("#").append(test).append(" ").append(pw10.get(K-1));
            System.out.println(sb);
        }

    }
}
