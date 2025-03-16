package baekjoon.dohyeon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 좌표정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Point> pointList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = inputs[0];
            int y = inputs[1];

            Point point = new Point(x,y);
            pointList.add(point);
        }

        pointList.sort(Comparator.comparing((Point point) -> point.x).thenComparing((Point point) -> point.y));

        for(Point point: pointList) {
            System.out.println(point);
        }

    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
