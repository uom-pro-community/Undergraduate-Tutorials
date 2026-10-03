public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    // Node
    private class Node {
        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    // Insert at beginning
    public void insertFirst(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        size++;
    }

    // Insert at end
    public void insertLast(int value) {

        Node newNode = new Node(value);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    // Remove first
    public int removeFirst() {

        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }

        int value = head.data;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }

        size--;

        return value;
    }

    // Remove last
    public int removeLast() {

        if (tail == null) {
            System.out.println("List is empty");
            return -1;
        }

        int value = tail.data;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }

        size--;

        return value;
    }

    // Search
    public boolean contains(int value) {

        Node current = head;

        while (current != null) {

            if (current.data == value) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Print forward
    public void printForward() {

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Print backward
    public void printBackward() {

        Node current = tail;

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.previous;
        }

        System.out.println("null");
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);

        list.printForward();

        list.insertFirst(5);

        list.printForward();

        System.out.println("Forward:");
        list.printForward();

        System.out.println("Backward:");
        list.printBackward();

        System.out.println("Removed First: " + list.removeFirst());
        list.printForward();

        System.out.println("Removed Last: " + list.removeLast());
        list.printForward();

        System.out.println("Contains 20: " + list.contains(20));
        System.out.println("Size: " + list.size());
    }
}