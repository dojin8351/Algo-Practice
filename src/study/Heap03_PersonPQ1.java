package study;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Heap03_PersonPQ1{
    public static void main(String[] args) {
        PriorityQueue<Person> pq = new PriorityQueue<>();

        PriorityQueue<Person> orderByName = new PriorityQueue<>(Comparator.comparing(p -> p.name));
        PriorityQueue<Person> orderByAge = new PriorityQueue<>(Comparator.comparingInt(p -> p.age));


        orderByName.add(new Person("강건", 15));
        orderByName.add(new Person("김준영", 35));
        orderByName.add(new Person("최시영", 45));

        orderByAge.add(new Person("강건", 15));
        orderByAge.add(new Person("김준영", 35));
        orderByAge.add(new Person("최시영", 45));

        System.out.println(orderByName.poll());
        System.out.println(orderByAge.poll());

    }


    private static class Person {
        String name;
        int age;

        public Person() {
            this("김싸피",13);
        }

        public Person(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

//        @Override
//        public int compareTo(Person o) {
//            return this.name.compareTo((o.name));
//        }
    }
}
