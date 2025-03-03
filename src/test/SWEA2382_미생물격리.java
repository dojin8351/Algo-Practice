package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SWEA2382_미생물격리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] str;
        for (int t = 1; t <= T; t++) {
            str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);   // map 크기
            int M = Integer.parseInt(str[1]);   // 격리 시간
            int K = Integer.parseInt(str[2]);   // 미생물 군집의 개수
            List<Microbiome> list = new ArrayList<>();  // 미생물 군집 정보 관리
            Microbiome[][] map = new Microbiome[N][N];

            // 최초 미생물 군집 정보 등록
            for (int i = 0; i < K; i++) {
                str = br.readLine().split(" ");
                int r = Integer.parseInt(str[0]);
                int c = Integer.parseInt(str[1]);
                int num = Integer.parseInt(str[2]);
                int dir = Integer.parseInt(str[3]); // 1 상, 2 하, 3 좌, 4 우

                Microbiome m = new Microbiome(r, c, num, dir);
                list.add(m);
                Collections.sort(list, Comparator.reverseOrder());  // 같은 칸에 중첩되는 경우 처리해주려고 첨부터 num 큰 순으로 들어가게 함
                map[r][c] = m;
            }

            while (M-- > 0) {

//                System.out.println("============================");
//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < N; j++) {
//                        System.out.print(map[i][j] + "\t");
//                    }
//                    System.out.println();
//                }


                for (int i = 0; i < list.size(); i++) {
                    Microbiome cur = list.get(i);

                    switch (cur.dir) {
                        case 1:
                            cur.nextR--;
                            break;
                        case 2:
                            cur.nextR++;
                            break;
                        case 3:
                            cur.nextC--;
                            break;
                        case 4:
                            cur.nextC++;
                            break;
                    }

                    // 테두리에 도착하면
                    if (cur.nextR == 0 || cur.nextC == 0 || cur.nextR == N - 1 || cur.nextC == N - 1) {
                        cur.num /= 2; // 미생물 수 반으로 깎아주고
                        // 방향 반대로 바꿔주기
                        if (cur.dir == 1 || cur.dir == 3) cur.dir++;
                        else cur.dir--;
                    }
                }

                map = new Microbiome[N][N];

                for (int i = 0; i < list.size(); i++) {
                    Microbiome cur = list.get(i);
                    if (map[cur.nextR][cur.nextC] == null) {    // 비어있는 칸이면 그냥 가
                        map[cur.r][cur.c] = null;
                        map[cur.nextR][cur.nextC] = cur;
                        cur.r = cur.nextR;
                        cur.c = cur.nextC;
                    } else {    // 가려는 칸에 이미 누가 있어
                        if (map[cur.nextR][cur.nextC].num > cur.num) {  // 이미 있는 애가 더 커
                            map[cur.nextR][cur.nextC].num += cur.num;
                            map[cur.r][cur.c] = null;
                            cur.num = 0;
                        } else {    // 새로 들어가려는 애가 더 커
                            System.out.println("이미 있는 " + map[cur.nextC][cur.nextC] + "보다 " + cur.num + "이 더 큼");
                            cur.num += map[cur.nextR][cur.nextC].num;
                            map[cur.nextR][cur.nextC].num = 0;
                            map[cur.nextR][cur.nextC] = cur;
                            cur.r = cur.nextR;
                            cur.c = cur.nextC;
                        }
                    }

                }

            }

            int res = 0;
            for (int i = 0; i < list.size(); i++) {
                res += list.get(i).num;
            }
            System.out.printf("#%d " + res + "\n", t);
        }
    }

    public static class Microbiome implements Comparable<Microbiome> {
        int r;
        int c;
        int nextR;
        int nextC;
        int num;
        int dir;

        public Microbiome(int r, int c, int num, int dir) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.dir = dir;
            this.nextR = r;
            this.nextC = c;
        }

        @Override
        public String toString() {
            return num + "(" + dir + ")";
        }

        @Override
        public int compareTo(Microbiome o) {
            return this.num - o.num;
        }
    }
}
