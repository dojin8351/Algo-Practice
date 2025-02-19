public class DoublyLinkedList {
    private Node head;
    private Node tail; //있으면 좋음
    private int size;

    // 안써도됨 짜피 참조자료형은 null, int는 0으로 초기화됨
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node get(int idx) {
        if(idx < 0 || idx >= size) {
            return null;
        }

        Node curr;
        //앞에서 부터 찾을래
        if(idx < size/2) {
            curr = head;
            for(int i = 0; i < idx; i++) {
                curr = curr.next;
            }
        }
        //뒤에서 부터 찾을래
        else {
            curr = tail;
            // 조건식을 계산해서 0부터 00회 돌리면 가능
            for(int i = size-1; i > idx; i--) {
                curr = curr.prev;
            }
        }
        return curr;
    }

    // 첫 번째 위치 삽입
    public void addFirst(String data) {
        Node node = new Node(data);

        node.next = head;
        // 공백이 아니라면
        if(head != null) {
            head.prev = node;
        }
        head = node;
        size++;

        // 만약에 노드가 1개 뿐이라면
        // 1개 뿐이면 tail 과 head 는 같다
        if(head.next == null) {
            tail = head;
        }
    }

    // 마지막 위치 삽입
    public void addLast(String data) {
        if(size == 0) {
            addFirst(data);
            return;
        }

        Node node = new Node(data);

        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    // 중간 위치 삽입
    public void add(int idx, String data) {
        if(idx < 0 || idx > size) return;

        if(idx == 0) {
            addFirst(data);
            return;
        }

        if(idx == size) {
            addLast(data);
            return;
        }

        Node prevNode = get(idx-1);
        Node nextNode = prevNode.next;

        Node node = new Node(data);

        prevNode.next = node;
        node.prev = prevNode;

        nextNode.prev = node;
        node.next = nextNode;

        size++;
    }
    
    // 첫번째 위치 삭제
    public String remove() {
        if(head == null) {
            return null;
        }
        
        String data = head.data;

        Node nextNode = head.next;
        if(nextNode != null) {
            nextNode.prev = null;
        }
        head = nextNode;
        size--;
        // tail이 존재 할 수 도 있음
        if(size == 0) {
            tail = null;
        }
        return data;
    }

    public String remove(int idx) {
        if(idx >= size || idx < 0) {
            return null;
        }
        if(idx == 0) {
            return remove();
        }

        Node prevNode = get(idx-1);
//        Node rmNode = prevNode.next;
        Node nextNode = prevNode.next.next;
        String data = prevNode.next.data;
        if(nextNode != null) {
            nextNode.prev = prevNode;
            prevNode.next = nextNode;
        } else {
            prevNode.next = null;
            tail = prevNode;
        }
        size--;
        return data;
    }

    public void printList() {
        Node curr = head;
        if(head == null){
            System.out.println("공백");
            return;
        }
        while(curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

}
