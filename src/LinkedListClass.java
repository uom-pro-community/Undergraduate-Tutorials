public class LinkedListClass {

    private Node head;
    private int size;

    // Node class
    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add element to the beginning
    public void insertFirst(int value) {

        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;

        size++;
    }

    // Add element to the end
    public void insertLast(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        size++;
    }

    // Remove first element
    public int removeFirst() {

        if (head == null) {
            System.out.println("Linked List is empty");
            return -1;
        }

        int value = head.data;

        head = head.next;

        size--;

        return value;
    }

    // Remove last element
    public int removeLast() {

        if (head == null) {
            System.out.println("Linked List is empty");
            return -1;
        }

        // Only one node
        if (head.next == null) {
            int value = head.data;
            head = null;
            size--;
            return value;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        int value = current.next.data;

        current.next = null;

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

    // Get size
    public int size() {
        return size;
    }

    // Check empty
    public boolean isEmpty() {
        return head == null;
    }

    // Print Linked List
    public void printList() {

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        LinkedListClass list = new LinkedListClass();

        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);

        list.printList();

        list.insertFirst(5);

        list.printList();

        System.out.println("Contains 20: " + list.contains(20));

        System.out.println("Size: " + list.size());

        System.out.println("Removed: " + list.removeFirst());

        list.printList();

        System.out.println("Removed: " + list.removeLast());

        list.printList();
    }
}