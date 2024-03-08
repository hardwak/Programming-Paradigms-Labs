package lista8;

import java.util.ArrayList;

public class Queue<E> implements MyQueue<E> {
    private ArrayList<E> queue;
    private int front, rear, size, capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            queue.add(null);
        }
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public void enqueue(E x) throws FullException {
        if (isFull()) {
            throw new FullException("Queue is full");
        }
        queue.set(rear, x);
        rear = (rear + 1) % capacity;
        size++;
    }

    @Override
    public void dequeue() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("Queue is empty");
        }
        queue.set(front, null);
        front = (front + 1) % capacity;
        size--;
    }

    @Override
    public E first() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("Queue is empty");
        }
        return queue.get(front);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
}
