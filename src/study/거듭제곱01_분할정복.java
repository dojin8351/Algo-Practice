package study;

public class 거듭제곱01_분할정복 {
    /*

     */
    public static void main(String[] args) {

    }

    static int pow(int C, int N) {
        int result = 1;
        for(int i = 1; i <= N; i++) {
            result *= C;
        }
        return result;
    }

    static int pow2(int C, int N)
    {
        if(N == 1) {
            return C;
        }

        return C * pow2(C,N-1);
    }
}
