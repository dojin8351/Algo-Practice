package study.검색_정렬;

public class 삽입정렬 {
    /*
        ## 1. 삽입 정렬 (Insertion Sort)
        ### 개념
        - 삽입 정렬은 배열을 왼쪽부터 순차적으로 확인하며, 현재 요소를 이미 정렬된 부분 배열에 적절한 위치에 삽입하는 방식으로 동작합니다.
        - 정렬된 부분을 확장해 나가는 방식으로 배열이 정렬됩니다.
        - 시간 복잡도:
            - 최선의 경우(이미 정렬된 배열): O(N)
            - 최악의 경우(역순 정렬된 배열): O(N²)

        - 공간 복잡도: 추가 공간을 사용하지 않는 제자리 정렬 (In-place Sort)

        ### 알고리즘 과정
        1. 정렬된 부분 배열은 처음 한 요소로 시작 (왼쪽에서부터 확장).
        2. 배열의 현재 요소를 정렬된 부분와 비교하여 올바른 위치로 삽입.
        3. 배열 끝까지 반복.

     */
    public static void insertionSort(int[] arr) {
        // 두 번째 요소부터 시작 (인덱스 1)
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // 현재 정렬할 대상
            int j = i - 1;    // 이전 요소를 가리키는 인덱스

            // 정렬된 부분에서 key보다 큰 값들을 한 칸 오른쪽으로 이동
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // 올바른 위치에 key 삽입
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 6, 2, 7};
        insertionSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}