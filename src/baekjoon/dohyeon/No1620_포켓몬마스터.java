package baekjoon.dohyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No1620_포켓몬마스터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int pokemonCnt = Integer.parseInt(inputs[0]);
        int questionCnt = Integer.parseInt(inputs[1]);

        // 포켓몬 이름과 숫자를 매핑할 맵 생성 시간초과 떠서 포켓몬 이름받아도 바로 인덱스 찾을 수 있게끔
        Map<String, Integer> nameToIndex = new HashMap<>();
        String[] indexToName = new String[pokemonCnt + 1];

        // 포켓몬 도감 데이터 입력
        for (int i = 1; i <= pokemonCnt; i++) {
            String pokemonName = br.readLine();
            nameToIndex.put(pokemonName, i);
            indexToName[i] = pokemonName;
        }

        for (int i = 0; i < questionCnt; i++) {
            StringBuilder sb = new StringBuilder();
            String question = br.readLine();
            // 숫자인지 아닌지 여부 판별
            if (Character.isDigit(question.charAt(0))) {
                int index = Integer.parseInt(question);
                sb.append(indexToName[index]);
                System.out.println(sb);
            }
            else {
                sb.append(nameToIndex.get(question));
                System.out.println(sb);
            }
        }
    }
}