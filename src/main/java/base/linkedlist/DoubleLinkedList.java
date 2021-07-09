package base.linkedlist;

public class DoubleLinkedList {
    private DoubleNode head;
    private DoubleNode tail;
    private int length;

    public DoubleLinkedList() {
        this.head = new DoubleNode(-1, null, null);
        this.tail = new DoubleNode(-1, null, null);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public void addHead(int val) {
        final DoubleNode node = new DoubleNode(val, head, head.next);
        node.pre.next = node;
        node.next.pre = node;
        length++;
    }

    public void addTail(int val) {
        final DoubleNode node = new DoubleNode(val, tail.pre, tail);
        node.pre.next = node;
        node.next.pre = node;
        this.length++;
    }

    public void add(int index, int val) {
        if (index <= 0) {
            this.addHead(val);
        } else if (index >= length) {
            this.addTail(val);
        } else {
            int i = 0;
            DoubleNode cur = head.next;
            while (i < index) {
                cur = cur.next;
                i++;
            }

            final DoubleNode newNode = new DoubleNode(val, cur.pre, cur);
            newNode.pre.next = newNode;
            newNode.next.pre = newNode;
            this.length++;
        }
    }

    public int getByIndex(int index) {
        final DoubleNode node = getNodeByIndex(index);
        if (node == null) {
            return -1;
        } else {
            return node.val;
        }
    }

    public DoubleNode getNodeByIndex(int index) {
        if (index >= 0 && index < length) {
            int i = 0;
            DoubleNode cur = head.next;
            while (i < index) {
                cur = cur.next;
                i++;
            }
            return cur;
        } else {
            return null;
        }
    }

    public void remove(int index) {
        final DoubleNode node = getNodeByIndex(index);
        if (node != null) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    public void printAll() {
        System.out.print("[");
        DoubleNode cur = head.next;

        while (cur != tail) {
            System.out.print(cur.val);
            cur = cur.next;
            if (cur != tail) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        final DoubleLinkedList list = new DoubleLinkedList();
        list.addHead(1); // 1
        list.addHead(2); // 2, 1
        list.addTail(3); // 2, 1, 3
        list.printAll();
        list.add(2, 5); // 2, 1, 5, 3
        list.printAll();
        System.out.println(list.getByIndex(2));
        list.remove(2); // 2, 1, 3
        list.printAll();
    }

    public static class DoubleNode {
        private int val;
        private DoubleNode next;
        private DoubleNode pre;

        public DoubleNode(int val, DoubleNode pre, DoubleNode next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
}
