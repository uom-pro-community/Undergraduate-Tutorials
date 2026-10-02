public class QueueClass {

    private int size;
    private int[] queueArray;
    private int front;
    private int back;
    private int actualItems;

    public QueueClass(int size) {
        this.size = size;
        this.queueArray = new int[size];
        this.front = 0;
        this.back = -1;
        this.actualItems = 0;
    }

    public void insert(int value) {

        if (actualItems == size) {
            System.out.println("Queue is full");
            return;
        }

        back++;
        queueArray[back] = value;
        actualItems++;
    }

    public int remove() {

        if (actualItems == 0) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = queueArray[front];
        front++;
        actualItems--;

        return value;
    }

    public void printQueue() {

        for (int i = front; i <= back; i++) {
            System.out.print(queueArray[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        QueueClass queue = new QueueClass(5);

        queue.insert(23);
        queue.insert(14);
        queue.insert(99);

        queue.printQueue();

        System.out.println("Removed: " + queue.remove());
        queue.printQueue();

        System.out.println("Removed: " + queue.remove());
        queue.printQueue();

        System.out.println("Removed: " + queue.remove());
        queue.printQueue();
    }
}