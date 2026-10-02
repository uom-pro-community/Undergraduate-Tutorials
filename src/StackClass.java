import java.util.Arrays;

public class StackClass {

    private int[] stackArray;
    private int top;
    private int stackSize;

    // Constructor
    public StackClass(int stackSize) {
        this.stackSize = stackSize;
        this.stackArray = new int[stackSize];
        this.top = -1;
    }

    // Push an element
    public void push(int value) {

        if (top >= stackSize - 1) {
            System.out.println("Stack Overflow - Cannot add " + value);
            return;
        }

        top++;
        stackArray[top] = value;
    }

    // Pop an element
    public int pop() {

        if (top == -1) {
            System.out.println("Stack Underflow - Stack is empty");
            return -1;
        }

        int value = stackArray[top];
        top--;

        return value;
    }

    // Peek the top element
    public int peek() {

        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        return stackArray[top];
    }

    // Check whether stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check whether stack is full
    public boolean isFull() {
        return top == stackSize - 1;
    }

    // Get current number of elements
    public int size() {
        return top + 1;
    }

    // Display stack
    public void display() {
        System.out.println(Arrays.toString(
                Arrays.copyOf(stackArray, top + 1)
        ));
    }

    public static void main(String[] args) {

        StackClass stack = new StackClass(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.display();

        // Stack is full
        stack.push(60);

        System.out.println("Top: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Is Full: " + stack.isFull());

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        stack.display();

        System.out.println("Top: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Is Empty: " + stack.isEmpty());
    }
}