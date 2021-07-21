package base.stack;

import base.linkedlist.SingleLinkedList;

public class LinkedStack {
    private SingleLinkedList.SingleNode top;

    public LinkedStack() {
        top = null;
    }

    public void push(int val) {
        this.top = new SingleLinkedList.SingleNode(val, top);
    }

    public int pop() {
        SingleLinkedList.SingleNode node = top;
        this.top = top.next;
        return node.val;
    }

    public void printAll() {
        top.printAll();
    }

    public static void main(String[] args) {
        final LinkedStack stack = new LinkedStack();
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.printAll();
        stack.pop();
        stack.printAll();
    }
}
