package baekjoon.dohyeon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            set.add(input);
        }

        List<String> arrs = new ArrayList<>(set);
//        Arrays.sort(arrs, Comparator.comparingInt(String::length).thenComparing(s -> s));
        arrs.sort(Comparator.comparing((String s) -> s).thenComparing(String::length));
        arrs.forEach(System.out::println);
    }
}
