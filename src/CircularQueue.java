public class CircularQueue {

    private int size;
    private int[] queueArray;
    private int front;
    private int rear;
    private int actualItems;

    public CircularQueue(int size) {
        this.size = size;
        this.queueArray = new int[size];

        front = 0;
        rear = -1;
        actualItems = 0;
    }

    // Insert / Enqueue
    public void insert(int value) {

        if (actualItems == size) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % size;
        queueArray[rear] = value;

        actualItems++;
    }

    // Remove / Dequeue
    public int remove() {

        if (actualItems == 0) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = queueArray[front];

        front = (front + 1) % size;
        actualItems--;

        return value;
    }

    // Get front element
    public int peek() {

        if (actualItems == 0) {
            System.out.println("Queue is empty");
            return -1;
        }

        return queueArray[front];
    }

    public boolean isEmpty() {
        return actualItems == 0;
    }

    public boolean isFull() {
        return actualItems == size;
    }

    public int size() {
        return actualItems;
    }

    public void printQueue() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = 0; i < actualItems; i++) {
            int index = (front + i) % size;
            System.out.print(queueArray[index] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        CircularQueue queue = new CircularQueue(5);

        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);

        queue.printQueue();

        // Remove two
        System.out.println("Removed: " + queue.remove());
        System.out.println("Removed: " + queue.remove());

        queue.printQueue();

        // These reuse the empty positions
        queue.insert(60);
        queue.insert(70);

        queue.printQueue();

        System.out.println("Front: " + queue.peek());
    }
}