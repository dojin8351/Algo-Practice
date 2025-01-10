package baekjoon;

import java.io.*;

public class No1193 {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String str;
            while ((str = br.readLine()) != null) {
                bw.write(str + "\n");
            }
            bw.flush(); // 출력 버퍼 비우기
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
