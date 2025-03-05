package study;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 조합01_재귀함수 {
    static String[] 재료;
    static String[] sel;
    static int N,R;

    public static void main(String[] args) {
        N=4;
        R=4;
        재료 = new String[]{"A","B","C","D"};
        sel = new String[R];

        comb(0,0);

    }

    /**
     * 
     * @param idx : 내가 이번에 고려할 재료들의 인덱스
     * @param sidx : 뽑은 재료의 인덱스
     */
    public static void comb(int idx, int sidx) {
        // 종료조건
        if(sidx == R) {
            // 재료 선정 완료
            System.out.println(Arrays.toString(sel));
            return;
        }

        if(idx == N) {
            // 더이상 고려할 재료가 없어!
            return;
        }
        
        //재귀 조건
        sel[sidx] = 재료[idx]; // 뽑은재료
        comb(idx+1, sidx+1);
//        sel[sidx] = null; // 재료를 사용하지 않았다(결국 덮어버림)
        comb(idx+1, sidx); // 안뽑은재료
    }
    
}
