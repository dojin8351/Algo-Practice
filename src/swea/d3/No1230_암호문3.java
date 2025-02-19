package swea.d3;

import java.util.*;

public class No1230_암호문3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = 10;

        for(int test = 1; test <= testCase; test++) {
            int N = sc.nextInt();
            List<String> orgPw = new LinkedList<>();
            for(int i = 0; i < N; i++) {
                orgPw.add(sc.next());
            }
            int orderCnt = sc.nextInt();
            for(int i = 0; i < orderCnt; i++) {
                String orderCase = sc.next();

                switch (orderCase) {
                    case "I":
                        int index = sc.nextInt();
                        int pwCnt = sc.nextInt();
                        List<String> pw = new ArrayList<>();
                        for (int j = 0; j < pwCnt; j++) {
                            pw.add(sc.next());
                        }
                        orgPw.addAll(index, pw);
                        break;

                    case "D":
                        int startIndex = sc.nextInt();
                        int deleteCnt = sc.nextInt();
                        for (int j = 0; j < deleteCnt; j++) {
                            orgPw.remove(startIndex);
                        }
                        break;

                    case "A":
                        int appendPwCnt = sc.nextInt();
                        List<String> appendPw = new ArrayList<>();
                        for (int j = 0; j < appendPwCnt; j++) {
                            appendPw.add(sc.next());
                        }
                        orgPw.addAll(orgPw.size(), appendPw);
                        break;

                    default:
                        break;
                }

            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test).append(" ");
            for(int i = 0; i < 10; i++) {
                sb.append(orgPw.get(i)).append(" ");
            }

            System.out.println(sb);
        }
    }
}
