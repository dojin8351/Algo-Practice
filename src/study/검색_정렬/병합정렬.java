package study.검색_정렬;

public class 병합정렬 {
    /*
        병합 정렬
        - 분할 정복(Divide and Conquer) 기법을 활용한 안정적인 정렬 알고리즘
        - 배열을 절반으로 분할하고, 각 부분을 재귀적으로 정렬한 뒤, 정렬된 부분 배열을 다시 병합하는 정렬 방식
        - 시간 복잡도 O(NlogN)
        - 추가적인 공간 필수

        단계별 동작
        - 분할 : 주어진 배열을 반으로 나눈다.
        - 정복 : 각 부분 배열을 재귀적으로 병합 정렬을 사용해 정렬한다.
        - 병합 : 정렬된 부분 배열들을 합쳐 전체 배열을 정렬한다.
     */
    static int[] arr = {7,5,6,8,1,2,3,39};
    static int N = arr.length;
    static int[] tmp = new int[N];

    public static void main(String[] args) {

    }

    static void mergeSort(int start, int end) {
        if(start < end) {
            int mid = (start + end)/2;
            mergeSort(start,mid);
            mergeSort(mid+1,end);
        }
    }

    static void merge(int start, int mid, int end) {
        int L = start;
        int R = mid + 1;

        int idx = start; // 임시 공간의 인덱스

        while(L <= mid && R <= end) {
            if(arr[L] <= arr[R]) {
                tmp[idx++] = arr[L++];
            } else {
                tmp[idx++] = arr[R++];
            }
        }

        if(L <= mid) {
            for(int i = L; i <= mid; i++) {
                tmp[idx++] = arr[i];
            }
        } else {
            for(int i = R; i <=end; i++) {
                tmp[idx++] = arr[i];
            }
        }
    }
}
