package study.검색_정렬;

public class 버블정렬 {
    /*
        ## 2. 버블 정렬 (Bubble Sort)
        ### 개념
        - 버블 정렬은 배열을 반복적으로 순회하며, 인접한 두 요소를 비교하여 잘못된 순서를 "교환"하는 방식으로 동작합니다.
        - 배열의 가장 큰 값은 한 번 순회할 때마다 맨 끝으로 이동(버블처럼 올라감).
        - **시간 복잡도**:
            - 최선의 경우: O(N) (이미 정렬된 경우)
            - 최악의 경우: O(N²)

        - 공간 복잡도: In-place 정렬

        ### 알고리즘 과정
        1. 배열을 첫 번째 요소부터 끝까지 반복하며,
            - 인접한 두 요소를 비교.
            - 잘못된 순서라면 두 요소를 교환.

        2. 배열 끝쪽에는 가장 큰 값이 정렬됩니다.
        3. 과정 반복 (이미 정렬된 부분 제외).

     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // 배열의 길이만큼 반복
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // 교환 여부 확인

            // 안쪽 루프: 마지막 정렬된 요소 제외
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 두 요소 교환
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true; // 교환 발생
                }
            }

            // 최적화: 교환이 없었다면 이미 정렬된 상태
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 2, 7};
        bubbleSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}