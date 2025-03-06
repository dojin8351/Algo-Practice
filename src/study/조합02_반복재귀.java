package study;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 조합02_반복재귀 {
    public static void main(String[] args) {
        // 입력 데이터
        char[] items = {'A', 'B', 'C', 'D'};
        int R = 2; // 조합의 크기

        // 결과 저장 리스트
        List<List<Character>> result = new ArrayList<>();

        // 재귀 호출 시작
        allSubsets(items,0, new ArrayList<>(), result);
        result.sort(Comparator.comparing(List :: size));
        // 결과 출력
        for (List<Character> combination : result) {
            System.out.println(combination);
        }
    }

    public static void combine(char[] items, int R, int idx, List<Character> current, List<List<Character>> result) {
        // 종료 조건: R개의 조합 완성
        if (current.size() == R) {
            result.add(new ArrayList<>(current)); // 현재 조합을 결과 리스트에 추가
            return;
        }

        // 반복문과 재귀 결합
        for (int i = idx; i < items.length; i++) {
            // 현재 재료 추가
            current.add(items[i]);

            // 다음 재귀 호출 (현재 선택한 재료 이후를 탐색)
            combine(items, R, i + 1, current, result);

            // 백트래킹: 탐색이 끝났으므로 현재 재료 제거
            current.remove(current.size() - 1);
        }
    }

    public static void duplicateCombination(char[] items, int R, int idx, List<Character> current,
                                            List<List<Character>> result) {
        if (current.size() == R) { // 조합이 완성되었을 때
            result.add(new ArrayList<>(current)); // 결과 리스트에 추가
            return;
        }

        for (int i = idx; i < items.length; i++) { // 반복문 시작

            current.add(items[i]); // 현재 원소 선택
            duplicateCombination(items, R, i, current, result); // **i를 그대로 사용**
            current.remove(current.size() - 1); // 백트래킹
        }
    }
    
    // 사이즈를 지정하지않고 유동적으로 사이즈를 조건대로 생성
    public static void allSubsets(char[] items, int idx, List<Character> current, List<List<Character>> result) {
        // 현재 조합을 결과에 추가
        if(current.size() >= 3 && current.size() <= 4) {
            result.add(new ArrayList<>(current));
        }

        for (int i = idx; i < items.length; i++) {
            // 현재 요소 추가
            current.add(items[i]);

            // 재귀 호출 (현재 요소 포함한 결과를 찾음)
            allSubsets(items, i + 1, current, result);

            // 백트래킹: 현재 요소 제거
            current.remove(current.size() - 1);
        }
    }
}