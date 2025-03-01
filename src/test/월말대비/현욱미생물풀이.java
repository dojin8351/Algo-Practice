package test.월말대비;

import java.util.*;
import java.io.*;
class Node {
    int numbers;
    int direction;
    public Node(int numbers, int direction){
        this.numbers = numbers;
        this.direction = direction;
    }
    public int getNumbers() {
        return numbers;
    }
    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }
    public int getDirection() {
        return direction;
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }
}
public class 현욱미생물풀이 {
    static Node[][] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            graph = new Node[n][n];
            for (int i = 0; i < k; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                int cnt = Integer.parseInt(st2.nextToken());
                int dir = Integer.parseInt(st2.nextToken())-1;
                Node node = new Node(cnt, dir);
                graph[x][y] = node;
            }
            for (int j = 1; j <= m; j++) {
                List<int[]> xy_list = new ArrayList<>();
                List<Node> change_list = new ArrayList<>();
                for (int a = 0; a < n; a++) {
                    for (int b = 0; b < n; b++) {
                        int max = 0;
                        int sum = 0;
                        int max_dir = 0;
                        if (a-1 >=0 && graph[a-1][b] != null && graph[a-1][b].getDirection() == 1) {
                            Node node1 = graph[a-1][b];
                            sum += node1.getNumbers();
                            if (node1.getNumbers() > max) {
                                max = node1.getNumbers();
                                max_dir = node1.getDirection();
                            }
                            graph[a-1][b] = null;
                        }
                        if (a+1 < n && graph[a+1][b] != null && graph[a+1][b].getDirection() == 0) {
                            Node node2 = graph[a+1][b];
                            sum += node2.getNumbers();
                            if (node2.getNumbers() > max) {
                                max = node2.getNumbers();
                                max_dir = node2.getDirection();
                            }
                            graph[a+1][b] = null;
                        }
                        if (b-1 >=0 && graph[a][b-1] != null && graph[a][b-1].getDirection() == 3) {
                            Node node3 = graph[a][b-1];
                            sum += node3.getNumbers();
                            if (node3.getNumbers() > max) {
                                max = node3.getNumbers();
                                max_dir = node3.getDirection();
                            }
                            graph[a][b-1] = null;
                        }
                        if (b+1 < n && graph[a][b+1] != null && graph[a][b+1].getDirection() == 2) {
                            Node node4 = graph[a][b+1];
                            sum += node4.getNumbers();
                            if (node4.getNumbers() > max) {
                                max = node4.getNumbers();
                                max_dir = node4.getDirection();
                            }
                            graph[a][b+1] = null;
                        }
                        if (sum!=0) {
                            Node new_node = new Node(sum,max_dir);
                            boolean extinct = false;
                            if (a == 0 || a == n-1 || b == 0 || b == n-1) {
                                int new_num = (int) (sum/2);
                                new_node.setNumbers(new_num);
                                if (max_dir % 2 == 0) {
                                    new_node.setDirection(max_dir + 1);
                                } else {
                                    new_node.setDirection(max_dir - 1);
                                }
                                if (new_num == 0) {
                                    extinct = true;
                                }
                            }
                            if (!extinct) {
                                change_list.add(new_node);
                                int[] xy = {a,b};
                                xy_list.add(xy);
                            }
                        }
                    }
                }
                for (int p = 0; p < change_list.size(); p++) {
                    Node update_node = change_list.get(p);
                    int[] update_xy = xy_list.get(p);
                    graph[update_xy[0]][update_xy[1]] = update_node;
                }
            }
            int total = 0;
            for (int c = 0; c < n; c++) {
                for (int d = 0; d < n; d++) {
                    if (graph[c][d] != null) {
                        int num = graph[c][d].getNumbers();
                        total+=num;
                    }
                }
            }
            bw.write("#"+t+" "+total+"\n");
        }
        bw.flush();
        bw.close();
    }
}