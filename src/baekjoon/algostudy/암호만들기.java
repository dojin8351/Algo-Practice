package baekjoon.algostudy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 암호만들기 {
    static List<List<String>> results;
    static boolean[] visited;
    static List<String> vowelList = Arrays.asList("a", "e", "i", "o", "u");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        int L = inputs[0]; // 주어지는 문자 의 개수
        int C = inputs[1]; // 만들어야 하는 암호문의 개수

        results = new ArrayList<>();
        visited = new boolean[L];
        String[] words = br.readLine().split(" ");

        // 오름 차순 정렬
        Arrays.sort(words, Comparator.comparing(String::new));

        combine(words,L,0,new ArrayList<>());

        StringBuilder sb = new StringBuilder();

        for(List<String> result : results) {
            sb.append(result.toString().replace("[","").replace("]","").replace(",","").replace(" ","")).append("\n");
        }
        System.out.println(sb);

    }

    public static void combine(String[] arr, int size, int idx, List<String> cur) {
        // 조건에서 1개의 모음이 들어있어야 하고 최소 2개의 자음이 들어 있어야 한다고 나와있기 때문에
        // 모음의 개수를 세어주고 cur리스트에서 값을 빼줘 2이상일때 만 result 리스트에 추가를 해주었다.
        int vowelCount = (int) cur.stream().filter(vowelList::contains).count();
        int consonantCount = cur.size() - vowelCount;

        if (cur.size() == size && vowelCount >= 1 && consonantCount >= 2) {
            results.add(new ArrayList<>(cur));
            return;
        }

        for(int i = idx; i < arr.length; i++) {
            cur.add(arr[i]);

            combine(arr,size,i+1,cur);

            cur.remove(cur.size()-1);

        }
    }

}
