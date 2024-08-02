// Stack class using an array
class Stack {
    private int[] stackArray; // Array to store stack elements
    private int top; // Index of the top element in the stack
    private int maxSize; // Maximum size of the stack

    // Constructor to initialize the stack with a given size
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // Indicates the stack is initially empty
    }

    // Method to push an element onto the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
            return;
        }
        stackArray[++top] = value; // Increment top and insert value
        System.out.println("Pushed " + value + " onto the stack.");
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // Returning -1 as an indicator of an error
        }
        System.out.println("Popped " + stackArray[top] + " from the stack.");
        return stackArray[top--]; // Return top element and decrement top
    }

    // Method to peek at the top element of the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // Returning -1 as an indicator of an error
        }
        return stackArray[top]; // Return the top element without removing it
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1); // If top is -1, the stack is empty
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1); // If top is at the last index, the stack is full
    }

    // Method to print the current elements in the stack
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Current Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a stack of size 5
        Stack stack = new Stack(5);

        // Demonstrate stack operations
        stack.push(10); // Push element 10
        stack.push(20); // Push element 20
        stack.push(30); // Push element 30
        stack.displayStack(); // Display current stack elements

        stack.pop(); // Pop top element (30)
        stack.displayStack(); // Display current stack elements

        System.out.println("Top element is: " + stack.peek()); // Peek at the top element (20)

        stack.push(40); // Push element 40
        stack.push(50); // Push element 50
        stack.push(60); // Attempt to push element 60 (stack is full)
        stack.displayStack(); // Display current stack elements
    }
}
