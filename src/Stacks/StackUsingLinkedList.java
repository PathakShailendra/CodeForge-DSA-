package Stacks;

public class StackUsingLinkedList {
    class MyStack {
         class StackNode {
             int data;
             StackNode next;
             StackNode(int a) {
                 data = a;
                 next = null;
             }
         }
        StackNode top;



        // Function to push an integer into the stack.
        void push(int x) {
            StackNode newNode = new StackNode(x);
            newNode.next = top;
            top = newNode;
        }

        int pop() {
            if (top == null) return -1;
            int poppedData = top.data;
            top = top.next;
            return poppedData;
        }
    }

}
