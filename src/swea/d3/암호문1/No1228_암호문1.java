package swea.d3.암호문1;

import java.util.*;

public class No1228_암호문1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = 10;

        for(int test = 1; test <= testCase; test++) {
            int orgPwLength = sc.nextInt();
            List<String> orgPw = new LinkedList<>();
            for(int i = 0 ;i < orgPwLength; i++) {
                orgPw.add(sc.next());
            }

            int orderCnt = sc.nextInt();
            List<String[]> orders = new ArrayList<>();
            for(int i = 0; i < orderCnt; i++) {
                String[] order = new String[4];
                StringBuilder sb = new StringBuilder();
                // 명령어 부분부눈 찢어서 String 배열로 저장해준다.
                String I = sc.next();
                String index = sc.next();
                String strCnt = sc.next();
                for(int j = 0; j < Integer.parseInt(strCnt); j++) {
                    sb.append(sc.next()).append(" ");
                }
                order[0] = I;
                order[1] = index;
                order[2] = strCnt;
                order[3] = sb.toString().trim();

                orders.add(order);
            }

            // 저장되어 있는 명령어를 이용
            for(String[] order: orders) {
                StringBuilder sb = new StringBuilder();
                // 기존 존재하는 Pw리스트에 원하는 위치에 order[3] 명령어에 주어진 넣을 요소들을 추가해준다.
                orgPw.add(Integer.parseInt(order[1]),order[3]);

                // 넣을때 여러개의 수를 문자열로 넣었기때문에 list를 순회하면서 다시 다 뽑은다음 sb를 이용해 재가공
                for(String pw : orgPw) {
                    sb.append(pw).append(" ");
                }

                //sb에 공백으로 구분되어 저장된 암호를 다시 공백으로 split하여 새로운 리스트를 생성후 orgpw로 다시 넣어준다.
                orgPw = new ArrayList<>(Arrays.asList(sb.toString().split(" ")));
            }

            StringBuilder result = new StringBuilder();
            result.append("#").append(test).append(" ");
            for(int i = 0; i < 10; i++) {
                result.append(orgPw.get(i)).append(" ");
            }

            System.out.println(result);
        }

    }
}
