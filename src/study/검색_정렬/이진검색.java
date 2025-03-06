package study.검색_정렬;

public class 이진검색 {

    public static boolean binarySearch(int[] arr, int target) {
        // 초기 좌/우 포인터
        int left = 0;
        int right = arr.length - 1;

        // 이진 검색 시작
        while (left <= right) {
            int mid = left + (right - left) / 2; // 중간 인덱스 계산

            if (arr[mid] == target) { // 목표값이 중간값과 같으면 찾음
                return true;
            } else if (arr[mid] < target) { // 목표값이 중간값보다 크면 오른쪽으로 이동
                left = mid + 1;
            } else { // 목표값이 중간값보다 작으면 왼쪽으로 이동
                right = mid - 1;
            }
        }
        // 못 찾았을 경우
        return false;
    }

    // 재귀 버전
    public static boolean binarySearch(int[]arr, int start, int end, int target) {
        if(start > end) {
            return false;
        } else {
            int mid = (start + end) / 2;

            if(target == arr[mid]) {
                return true;
            }  else if(target < arr[mid]) {
                return binarySearch(arr, start, mid-1, target);
            } else {
                return binarySearch(arr, mid+1, end,target);
            }
        }
    }

}
