package study.검색_정렬;

import java.util.Arrays;

public class 병합정렬 {
    /*
        ### 병합정렬

        - 분할 정복 기법을 사용한 안정적인 정렬 알고리즘
        - 배열을 절반으로 분할하고, 각 부분을 재귀적으로 정렬한 뒤, 정렬된 부분 배열을 다시 병합하는 정렬 방식
        - 시간 복잡도 O(N log N) : 배열을 계속 나누는 과정에서 `log N`만큼의 단계가 발생하고, 각 단계에서 병합 과정에 `N`의 시간이 소요되므로 전체적으로 O(N log N)의 시간 복잡도를 가집니다.
        - 추가적인 공간 필요

        ### 단계별 동작

        - 분할 : 주어진 배열을 반으로 나눈다
        - 정복 : 각 부분 배열을 재귀적으로 병합 정렬을 사용해 정렬한다.
        - 병합 : 정렬된 부분 배열들을 합쳐 전체 배열을 정렬한다.

     */
    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 8, 1, 2, 3, 39}; // 정렬 대상 배열
        arr = mergeSort(arr);                  // 병합 정렬 호출

        // 정렬 결과 출력
        System.out.println(Arrays.toString(arr));
    }

    // 병합 정렬 함수: 입력 배열을 받아 정렬된 배열 반환
    static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) { // 배열 길이가 1인 경우, 그대로 반환
            return arr;
        }

        // 배열을 나누기 위해 중간 인덱스를 계산
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);   // 왼쪽 절반
        int[] right = Arrays.copyOfRange(arr, mid, arr.length); // 오른쪽 절반

        // 재귀적으로 병합 정렬 수행
        return merge(mergeSort(left), mergeSort(right));
    }

    // 병합 함수: 정렬된 두 배열을 병합
    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length]; // 병합 배열
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) { // 두 배열 비교
            if (left[i] <= right[j]) {
                result[k++] = left[i++]; // 왼쪽 값이 작을 경우 추가
            } else {
                result[k++] = right[j++]; // 오른쪽 값이 작을 경우 추가
            }
        }

        // 왼쪽 배열의 남은 값 추가
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // 오른쪽 배열의 남은 값 추가
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result; // 병합된 배열 반환
    }
}