package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class No10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        int x = 0;
        int y = 0;

        if((p + t) % (w * 2) < w) {
            x = (p + t) % w;
        } else {
            x = (w * 2) - (p + t) % (w * 2);
        }

        if((q + t) % (h * 2) < h) {
            y = (q + t) % h;
        } else {
            y = (h * 2) - (q + t) % (h * 2);
        }

        sb.append(x).append(" ").append(y);
        bw.write(sb.toString());
        bw.flush();
    }
}
