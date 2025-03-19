package baekjoon.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 에디터 {
    // 초기 문자를 입력 받았을때 커서는 마지막 문자 뒤에 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> words = new ArrayList<>(Arrays.stream(br.readLine().split(" ")).toList());

        int index = words.size();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            if(inputs[0].equals("L")) {
                if(index != 0) {
                    index = index - 1;
                }
            } else if(inputs[0].equals("D")) {
                if(index != words.size()) {
                    index = index + 1;
                }
            } else if(inputs[0].equals("B")) {
                words.remove(index-1);
            } else {
                words.add(index-1, inputs[1]);
            }
        }

        System.out.println(words);

    }
}
