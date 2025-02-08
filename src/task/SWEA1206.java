package task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA1206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> arr = new ArrayList<>();
        int answer = 0;
        int lt;
        int rt;


        //테케 입력
        for (int t = 0; t < 1; t++) {
            int n = sc.nextInt();

            // 배열 입력값 넣기
            for (int i = 0; i < n; i++)
                arr.add(sc.nextInt());



            for (int i = 2; i < n - 2; i++) {
                System.out.println("i : " + i);
                lt = i - 2;
                rt = i + 2;
                int maxLeft = 0;
                int maxRight = 0;
                boolean flag = false;
                int k = 1;
                while (k <= 2) {

                    if (maxLeft < arr.get(lt))
                        maxLeft = arr.get(lt);

                    if (arr.get(i) < arr.get(rt)) {
                        i = rt - 1;
                        flag = true;
                        break;
                    } else {
                        if (maxRight < arr.get(rt))
                            maxRight = arr.get(rt);
                    }

                    lt += k;
                    rt -= k;
                    k++;
                }
                if (!flag)
                    answer += (maxLeft > maxRight) ? (arr.get(i) - maxLeft) : (arr.get(i) - maxRight);

            }
            System.out.printf("#%d %d%n", t + 1, answer);
            answer = 0;



        }

    }
}
