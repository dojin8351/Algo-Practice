package baekjoon.dohyeon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int age = Integer.parseInt(inputs[0]);
            String name = inputs[1];
            User user = new User(age,name);
            userList.add(user);
        }

        userList.sort(Comparator.comparingInt((User value) -> value.age).reversed()
                .thenComparing((User value) -> value.seq));
        userList.sort(Comparator.comparing(User::getAge).thenComparing(User::getSeq));

        userList.forEach(System.out::println);
    }
    static class User {
        int age;
        String name;
        int seq = 0;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
            this.seq = ++seq;
        }

        @Override
        public String toString() {
            return age + " " +  name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }
    }
}
