package Learn;

import java.util.ArrayList;

public class MyQueue<T> {
    private final ArrayList<T> queue = new ArrayList<>();

    /**큐에 데이터를 삽입
     * Enqueue.
     *
     * @param item the item
     */
    public void enqueue(T item) {
        queue.add(item);
    }

    /**큐에서 데이터를 꺼낸다 없을 경우에는 0을 반환 있는 경우 항상 가장 앞의 값만 반환
     * Dequeue t.
     *
     * @return the t
     */
    public T dequeue() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }


    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<>();
        mq.enqueue(2);
        mq.enqueue(1);
        mq.enqueue(3);
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
    }
}
