package study;

public class Tree01_순회 {
    public static char[] tree = new char[]{' ', 'A', 'B', 'C', 'D', 'E', 'F','G', ' ', ' ', 'H', 'I'};
    public static int N = tree.length;
    public static void main(String[] args) {

    }

    // 전위 순회 v는 노드의 번호
    public static void preOrder(int v) {
        if(v < N) {
            // 방문 처리
            if(tree[v] != ' ') {
                System.out.println(tree[v]);
            }
            // 왼쪽 자식 탐방
            preOrder(v * 2);
            // 오른쪽 자식 탐방
            preOrder(v * 2 + 1);
        }
    }

    // 중위 순회
    public static void inOrder(int v) {
        if(v < N) {
            // 왼쪽 자식 탐방
            inOrder(v * 2);
            
            // 방문 처리
            if(tree[v] != ' ') {
                System.out.println(tree[v]);
            }

            // 오른쪽 자식 탐방
            inOrder(v * 2 + 1);
        }
    }
    // 후위 순회
    public static void postOrder(int v) {
        if(v < N) {
            // 왼쪽 자식 탐방
            postOrder(v * 2);

            // 오른쪽 자식 탐방
            postOrder(v * 2 + 1);

            // 방문 처리
            if(tree[v] != ' ') {
                System.out.println(tree[v]);
            }
        }
    }

}
