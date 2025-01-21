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
                for(Integer key : switches.keySet()) {
                    if(key % switchNum == 0) {
                        if(switches.get(key) == 1) {
                            switches.replace(key, 0);
                        }else {
                            switches.replace(key, 1);
                        }
                    }
                }
            } else {
                for(int j = switchNum, k = switchNum; j <= switches.size() && k >= 0 ; j++, k--) {
                    if(switches.get(j).equals(switches.get(k))) {
                        if(switches.get(j) == 1 && switches.get(k) == 1) {
                            switches.replace(j, 0);
                            switches.replace(k, 0);
                        } else {
                            switches.replace(j, 1);
                            switches.replace(k, 1);
                        }
                    }else {
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
