package baekjoon;

import java.util.*;

public class No17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();
        Stack<Character> reversTool = new Stack<>();

        boolean tag = false;

        for(char c : input.toCharArray()){
            if(c == '<') {
                while(!reversTool.isEmpty()) {
                    result.append(reversTool.pop());
                }
                tag = true;
                result.append(c);
            } else if(c == '>') {
                result.append(c);
                tag = false;
            } else if(c == ' ') {
                if (tag) {
                    result.append(c);
                } else {
                    while (!reversTool.isEmpty()) {
                        result.append(reversTool.pop());
                    }
                    result.append(c);
                }
            } else{
                if(tag) {
                    result.append(c);
                } else {
                    reversTool.push(c);
                }
            }
        }

        while(!reversTool.isEmpty()) {
            result.append(reversTool.pop());
        }

        System.out.println(result);
    }
}
