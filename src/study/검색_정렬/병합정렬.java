package study.검색_정렬;

import java.util.Arrays;

public class 병합정렬 {

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