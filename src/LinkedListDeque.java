public class LinkedListDeque<T> {
    // 내부에 Node를 정의해놓고 쓰자!
    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node front; //앞쪽 컨트롤
    private Node rear; //뒤쪽 컨트롤
    private int size;
    
    //기본생성자를 작성하진 않을건데
    // 상상 가능해야함
    
    //공백 확인
    public boolean isEmpty() {
        return size == 0;
    }
    
    // 개수 반환
    public int size() {
        return size;
    }

    // 앞쪽에 새로운 원소를 추가
    public void addFirst(T item) {
        Node node = new Node(item);
        if(isEmpty()) {
            front = node;
            rear = node;
        } else {
            node.next = front;
            front.prev = node;
            front = node;
        }
        size++;
    }

    public void addLast(T item) {
        Node node = new Node(item);
        if(isEmpty()) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            node.prev = rear;
            rear = node;
        }
        size++;
    }
    
    // 앞쪽 노드 삭제
    public T removeFirst() {
        if(isEmpty()){
            return null;
        }
        T data = front.data;
        if(size == 1) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        size--;
        return data;
    }

    // 뒤쪽 노드 삭제
    public T removeLast() {
        if(isEmpty()) {
            return null;
        }

        T data = rear.data;

        if(size == 1) {
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
        size--;
        return data;
    }

    //peek
    public T peekFirst() {
        if(isEmpty()) {
            return  null;
        }
        return front.data;
    }

    public T peekLast() {
        if(isEmpty()) return null;
        return rear.data;
    }

}
