public class LinkedList_데크 {
    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>();

        deque.addFirst(10);
        System.out.println(deque.removeFirst());
    }
}
