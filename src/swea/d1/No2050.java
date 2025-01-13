package swea.d1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No2050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String value = sc.next();

        Character[] values = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        Map<Character, Integer> valuesMap = new HashMap<>();

        for(int i = 0; i < values.length; i++){
            valuesMap.put(values[i], i);
        }

        for(int i = 0; i < value.length(); i++){
            System.out.print(valuesMap.get(value.charAt(i)) + " ");
        }

    }
}
