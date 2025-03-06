package study.검색_정렬;

public class 퀵정렬 {

    /*
        퀵 정렬
        - 분할 정복 기법을 활용한 효율적인 정렬 알고리즘
        - 피벗이라는 기준 요소를 선택하여 배열을 두 부분으로 분할하고, 재귀적으로 정렬하는 방식
        - 시간복잡도 O(NlogN), 최악의 경우 O(N²) (정렬된 배열에서 선택한 피벗이 항상 최솟값/최댓값일 경우)
        - 추가적인 공간을 필요치 않아 메모리 효율성이 높음. (제자리 정렬, in-place sort)

        주요 과정
        - Pivot 선택: 배열의 특정 요소(첫 요소, 마지막 요소, 중간값 등)를 피벗으로 지정.
        - 분할 (Partition): Pivot보다 작은 값은 왼쪽, 큰 값은 오른쪽에 배치.
        - 재귀 호출: 분할된 두 배열을 다시 각각 퀵 정렬.
        - 최종적으로 모든 재귀 호출이 종료되면 배열이 정렬됨.

        구현 방식
        - Hoare partition 방식을 사용한 퀵정렬
     */

    // 배열의 특정 범위를 재귀적으로 정렬하는 함수
    public static void quickSort(int[] arr, int low, int high) {
        /*
            재귀 종료 조건
            배열의 시작 인덱스(low)가 끝 인덱스(high)보다 크거나 같아진 경우
            더 이상 분할할 요소가 없는 상태이므로 종료.
        */
        if (low < high) {
            // 분할 수행 후 기준 피벗의 인덱스 반환
            int partitionIndex = partition(arr, low, high);

            /*
                피벗 기준 왼쪽 부분 배열(작은 값들)을 재귀적으로 퀵 정렬
                - partitionIndex는 정렬된 피벗 위치이므로 제외.
            */
            quickSort(arr, low, partitionIndex - 1);

            /*
                피벗 기준 오른쪽 부분 배열(큰 값들)을 재귀적으로 퀵 정렬
                - partitionIndex + 1부터 시작.
            */
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // 배열을 피벗을 기준으로 분할(Partition)하는 함수
    private static int partition(int[] arr, int low, int high) {
        /*
            `pivot`: 배열의 기준이 되는 값. 여기서는 배열의 마지막 요소를 피벗으로 선택.
            - 피벗보다 작은 값은 왼쪽으로 이동.
            - 피벗보다 큰 값은 오른쪽으로 이동.
            - 마지막에 피벗은 자신의 정렬된 위치로 이동.
        */
        int pivot = arr[high];

        /*
            변수 `i`: 피벗보다 작은 값이 마지막으로 배치된 위치의 인덱스
            - 초기값은 `low - 1`, 즉 아직 아무것도 배치되지 않았음을 의미.
        */
        int i = low - 1;

        /*
            Partition 과정
            - 배열의 low부터 high-1까지 반복하며
              피벗보다 작거나 같은 값을 찾고, 작은 값은 `i`가 가리키는 위치로 이동.
            - 피벗과 비교되면서 재정렬 수행.
        */
        for (int j = low; j < high; j++) {
            /*
                현재 요소(arr[j])가 피벗 값보다 작거나 같은 경우:
                - `i`를 증가시킨 후, `arr[j]`와 `arr[i]`를 교환하여 작은 값을 올바른 위치로 이동.
            */
            if (arr[j] <= pivot) {
                i++; // 작은 값의 끝 위치를 한 칸 확장

                // arr[i]와 arr[j] 스왑: 작은 값을 앞으로 이동
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        /*
            반복이 끝난 후, `i`는 피벗보다 작은 값의 마지막 인덱스를 가리킴.
            - 피벗의 정렬된 위치는 i + 1.
            - 피벗과 i + 1 위치의 값을 스왑하여 피벗을 '정렬된 위치'에 배치.
        */
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        /*
            반환값
            - 피벗 값의 최종 정렬된 위치 인덱스(i + 1)를 반환.
            - 이 값을 기준으로 배열을 분할하여 재귀 호출을 진행.
        */
        return i + 1;
    }
}