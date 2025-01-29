package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            list.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int index = 0;
        while(!list.isEmpty()) {
            index = (index + (K - 1)) % list.size();
            result.add(list.remove(index));
        }

        System.out.println(result.toString().replace("[", "<").replace("]", ">"));

    }
}
