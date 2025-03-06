package study;

public class 거듭제곱02_분할정복 {
    public static void main(String[] args) {

    }

    static int pow(int C, int N) {
        // 기저조건
        if(N == 1) {
            return C;
        }
        if(N % 2 == 1) {
            return pow(C , (N-1)/2) * pow(C, (N-1)/2) * C;
        } else {
            return pow(C, N/2) * pow(C, N/2);
        }
        // 재귀부분
    }

    static int pow2(int C, int N) {
        // 기저조건
        if(N == 1) {
            return C;
        }
        if(N % 2 == 1) {
            int tmp = pow(C , (N-1)/2);
            return tmp * tmp * C;
        } else {
            int tmp = pow2(C,N/2);
            return tmp * tmp;
        }
        // 재귀부분
    }
}
