package swea.d2;

import java.util.Scanner;

public class No1989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            String txt = sc.next();
            String reversTxt = "";
            for(int j = txt.length()-1; j >= 0; j--){
                reversTxt += txt.charAt(j);
            }
            if(reversTxt.equals(txt)){
                System.out.printf("#%d %d\n", i + 1, 1);
            }else {
                System.out.printf("#%d %d\n", i + 1, 0);
            }
        }
    }
}
