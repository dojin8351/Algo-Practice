package baekjoon;

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

        Integer[] switches = new Integer[size+1];
        switches[0] = null;
        for(int i = 1; i <= size; i++) {
            int a = sc.nextInt();
            switches[i] = a;
        }

        int students = sc.nextInt();
        for(int i = 0; i < students; i++) {
            int gender = sc.nextInt();
            int switchNum = sc.nextInt();

            if (gender == 1) {
                for(int j = 1; j <= switches.length; j++) {
                    if(j % switchNum == 0) {
                        if(switches[j] == 1) {
                            switches[j] = 0;
                        } else if (switches[j] == 0) {
                            switches[j] = 1;
                        } else if(switches[j] == null) {
                            continue;
                        }
                    }
                }
            } else {
                for(int j = 1; j <= switches.length; j++) {
                    if(switches[switchNum - j].equals(switches[switchNum + j])) {

                    }else {
                        break;
                    }
                }
            }

        }
    }
}
