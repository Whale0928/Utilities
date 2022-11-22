package Learn;


public class MyLinkedList<T> {
    private Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T value) {
            this.data = value;
        }
    }

    /**
     * 링크드리스트에 값을 저장하는 역할
     * Add node.
     *
     * @param data the data
     */
    public void add(T data) {
        if (head == null) {
            head = new Node<>(data); //head 는 해당 리스트의 가장 앞의 값을 의미함으로 만약 Null 일 경우 비어있다는 의미
        } else {
            Node<T> node = this.head; //else 가 수행되면 head의 값이 있다는 의미이니 리스트 가장 앞의 값을 가져온다.
            while (node.next != null) { //노드의 다음을 저장한 next 가 null 이 되기전 까지. 다음 값을 꺼내며 반복 한다.
                node = node.next;
            }
            node.next = new Node<>(data); //지금 순간 앞의 while 에서 리스트의 최대 값을 가져왔음으로 node는 현재 가장 마지막 값인 상태
        }
    }

    public void printAll(){
        if(head != null){
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public int search(int i){
        return 0;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(11);
        linkedList.printAll();
    }
}
