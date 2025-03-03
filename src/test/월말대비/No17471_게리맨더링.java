package test.월말대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No17471_게리맨더링 {
    /*
        - 구역을 나눌때 각 구역의 노드들은 서로 연결이 되어있어야한다.
        - 각 구역의 색을 칠해주면서 반대되는 색상의 인수수의 차이 최소값을 구해서 반환 만약 선거구 나눌수 없는경우 -1 출력
        - 같은 구역끼리는 연결이 되어있어야 한다.
     */
    static Zone[] zoneList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int zoneCnt = Integer.parseInt(br.readLine());
        zoneList = new Zone[zoneCnt+1];
        for(int i = 1; i < zoneList.length; i++) {
            zoneList[i] = new Zone();
        }

        int[] zoneCtz = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        for(int i = 0; i < zoneCtz.length; i++) {
            zoneList[i+1].ctz = zoneCtz[i];
        }

        for(int i = 0; i < zoneCnt; i++ ){
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
            int num = inputs[0];
            for(int j = 1; j <= num; j++) {
                int from = inputs[j];
                for(int k = 1; k <= num; k++) {
                    int to = inputs[k];
                    if(from == to) {
                        continue;
                    }
                    zoneList[inputs[j]].nodes.add(inputs[k]);
                }
            }
        }

        for (int i = 1; i < zoneList.length; i++) {
            System.out.println(zoneList[i].nodes);
        }

    }
    static class Zone {
        int zoneNum; //구역 번호
        boolean color; // 선거구
        int ctz; // 인구수
        Set<Integer> nodes; // 연결된 구역

        public Zone() {
            this.nodes = new HashSet<>();
        }
    }
}
