package linkedlist;

public class SingleLinkedList {
    private Node first;

    public void add(Object obj) {
        first = new Node(obj, first);
    }

    public void remove(Object obj) {
        if (first != null) {
            if (first.equals(obj)) {
                this.first = this.first.next;
            } else {
                remove(first, obj);
            }
        }
    }

    private void remove(Node first, Object obj) {
        if (first.next != null) {
            if (obj.equals(first.next)) {
                this.first = first.next.next;
            }
        }
    }

    public static class Node {
        private Object obj;
        private Node next;

        public Node(Object obj, Node next) {
            this.obj = obj;
            this.next = next;
        }
    }
}
