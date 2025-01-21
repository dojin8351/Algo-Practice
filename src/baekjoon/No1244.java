package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No1244 {
    /*
       - 남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다.
       - 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를
         중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꾼다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        Map<Integer,Integer> switches = new HashMap<>();
        for(int i = 1; i <= size; i++) {
            switches.put(i, sc.nextInt());
        }

        int studentCnt = sc.nextInt();
        for(int i = 0; i < studentCnt; i++) {
            int gender = sc.nextInt();
            int switchNum = sc.nextInt();

            if(gender == 1) {
                for (int key = switchNum; key <= size; key += switchNum) {
                    switches.replace(key, 1 - switches.get(key));
                }
            } else {
                switches.replace(switchNum, 1 - switches.get(switchNum));
                for (int j = 1; switchNum - j > 0 && switchNum + j <= size; j++) {
                    if (switches.get(switchNum - j).equals(switches.get(switchNum + j))) {
                        switches.replace(switchNum - j, 1 - switches.get(switchNum - j));
                        switches.replace(switchNum + j, 1 - switches.get(switchNum + j));
                    } else {
                        break;
                    }
                }
            }
        }
        for(Integer key : switches.keySet()) {
            System.out.print(switches.get(key) + " ");
            if(key % 20 == 0) {
                System.out.println();
            }
        }
    }
}
