package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No1672_DNA해독 {

    // 암호를 위한 맵과 해독 표
    static Map<Character, Integer> map = new HashMap<>();
    static char[][] decipheringTable = new char[4][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 암호마다의 index 저장
        map.put('A', 0);
        map.put('G', 1);
        map.put('C', 2);
        map.put('T', 3);

        // 해독표 정의
        decipheringTable[0] = new char[] { 'A', 'C', 'A', 'G' };
        decipheringTable[1] = new char[] { 'C', 'G', 'T', 'A' };
        decipheringTable[2] = new char[] { 'A', 'T', 'C', 'G' };
        decipheringTable[3] = new char[] { 'G', 'A', 'G', 'T' };

        int strLength = Integer.parseInt(br.readLine());
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(str);

        while (sb.length() > 1) {
            char col = sb.charAt(sb.length() - 1);
            char row = sb.charAt(sb.length() - 2);

            char decipher = decipheringTable[map.get(row)][map.get(col)];

            sb.delete(sb.length() - 2, sb.length());

            sb.append(decipher);
        }

        System.out.println(sb);
    }
}