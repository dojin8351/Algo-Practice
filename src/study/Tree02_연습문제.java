package study;

import java.util.Arrays;
import java.util.Scanner;

public class Tree02_연습문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 노드의 총 개수 -> 0부터 , 1부터 인지 잘 파악해야한다.
        int V = sc.nextInt();
        
        // [0] 왼자, [1] 오자, [2] 부모
        int[][] tree = new int[V+1][3];

        for(int i = 0; i < V-1; i++) {
            int p = sc.nextInt();
            int c = sc.nextInt();

            //문제에서 부모의 노드 번호가 작은것 부터 준다!
            // 왼쪽 자식부터 준다

            // 왼자가 아직 채워지지 않았다면..
            if(tree[p][0] == 0) {
                tree[p][0] = c; //왼자저장
            }else {
                tree[p][1] = c; //오자저장
            }
            
            // 부모 정보 저장
            tree[c][2] = p;
        }// 입력 처리
        for(int i = 0; i < V+1; i++) {
            System.out.println(i + " : " + Arrays.toString(tree[i]));
        }
    }
}
