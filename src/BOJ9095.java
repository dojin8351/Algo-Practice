import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1,2,3 더하기
public class BOJ9095 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(4);
        arr.add(7);

        int[] arr1 = new int[11];
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 4;
        arr1[3] = 7;

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {

            int n = sc.nextInt();

            for (int j = 4; j <= n; j++)
                arr.add(arr.get(j - 1) + arr.get(j - 2) + arr.get(j - 3));

            System.out.println(arr.size());

            for (int j = 4; j < n; j++) {
                arr1[j] = arr1[j - 1] + arr1[j - 2] + arr1[j - 3];
            }

            System.out.println(arr1[n-1]);
        }
    }
}
