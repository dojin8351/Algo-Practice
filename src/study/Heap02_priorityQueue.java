package study;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap02_priorityQueue {
    public static void main(String[] args) {
        //최소힙이 기본
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());


        pq.add(10);
        pq.add(20);
        pq.add(15);
        pq.add(19);

        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
