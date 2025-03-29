package study.그래프;

import java.util.Scanner;

public class 그래프_01_인접행렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // 정점의 개수(0번시작인지, 1번시작인지 확인) 
        int E = sc.nextInt(); // 간선의 개수

        int[][] adjArr = new int[V][V]; //만약 시작정점이 1이라면 V+1로 만들기

        for(int i = 0; i < E; i++) {
           int A = sc.nextInt(); // 연결된 두개의 정점의 정보
           int B = sc.nextInt();
           int W = sc.nextInt(); // 가중치 값/ 없다면 1을 저장하세요

            adjArr[A][B] = 1; // 가중치가 없다면 1을 있다면 W저장
            adjArr[B][A] = 1; // 유향이라면 19번은 작성하면 안된다.

//            adjArr[A][B] = adjArr[B][A] = W;

            // 유향 / 가중치 / 변수에 저장도 싫어
            adjArr[sc.nextInt()][sc.nextInt()] = sc.nextInt();



        }// 간선을 입력하겠다
        
    }//main
}
