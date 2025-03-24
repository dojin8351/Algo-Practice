package study.그래프;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_02_인접리스트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // 정점의 개수(0번시작인지, 1번시작인지 확인) 
        int E = sc.nextInt(); // 간선의 개수

        List<Integer>[] adjList = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            int A = sc.nextInt(); // 연결된 두개의 정점의 정보
            int B = sc.nextInt();

            adjList[A].add(B);
            adjList[B].add(A);
        }// 간선을 입력하겠다
        
    }//main
}
