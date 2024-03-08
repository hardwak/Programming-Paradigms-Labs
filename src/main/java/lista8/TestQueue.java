package lista8;

public class TestQueue {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new Queue<>(3);

        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);

            System.out.println("First element: " + queue.first());
            queue.dequeue();
            System.out.println("First element after dequeue: " + queue.first());
        } catch (FullException | EmptyException e) {
            e.printStackTrace();
        }
    }
}
