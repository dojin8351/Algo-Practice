package study.그래프;

public class 그래프기본 {
    /*
        그래프
        - 아이템 (사물 또는 추상적 개념) 들과 이들 사이으이 연결 관계 표현
        - 정점들의 집합과 이들을 연결하는 간선들의 집합으로 구성된 자료구조
        - 선형자료구조나 트리로 표현하기 어려운 M : N 의 관계를 표현한 것
        - V개의 정점을 가지는 그래프는 최대 V * (V-1) / 2 간선이 가능

        그래프 표현 방법
        - 간선의 정보를 저장하는 방식 메모리나 성능을 고려하여 결정
        1. 인접 행렬(Adjacent Matrix)
        2. 인접 리스트(Adjacent List)
        3. 간선 배열(Edge Array)
        
        인접 행렬(Adjacent Matrix)
        - 두 정점을 연결하는 간선의 유무를 행렬로 표현
        - V * V개의 2차원 배열
        - 행 번호와 열 번호는 그래프의 정점 번호
        - 두 정점이 인접되어 있으면 1, 그렇지 않다면 0으로 표현
        - 무향 그래프 -> i번째 행의 합 = i 번째 열의 합 = Vi 의 차수
        - 유향 그래프 -> i번째 행의 합 = Vi의 진출 차수, i번째 열의 합 = Vi 의 진입 차수
     */
}
