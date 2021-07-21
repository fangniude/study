package base.linkedlist;

public class SingleLinkedList {
    private SingleNode head;
    private int length;

    public SingleLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public void addHead(int val) {
        this.head = new SingleNode(val, this.head);
        length++;
    }

    public void addTail(int val) {
        final SingleNode lastNode = new SingleNode(val, null);
        if (head == null) {
            head = lastNode;
        } else {
            SingleNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = lastNode;
        }
        length++;
    }

    public void add(int index, int val) {
        if (index >= length) {
            this.addTail(val);
        } else if (index <= 0) {
            this.addHead(val);
        } else {
            int i = 0;
            SingleNode cur = head;
            while (i < index - 1) {
                cur = cur.next;
                i++;
            }

            cur.next = new SingleNode(val, cur.next);
        }
    }

    public void removeHead() {
        this.head = this.head.next;
        length--;
    }

    private void remove(int index) {
        if (index == 0) {
            removeHead();
        } else if (index > 0 && index < length) {
            SingleNode cur = head;
            int i = 0;
            while (i < index - 1) {
                cur = cur.next;
                i++;
            }
            cur.next = cur.next.next;
            length--;
        }
    }

    public int getIndexByVal(int val) {
        if (head == null) {
            return -1;
        } else {
            int i = 0;
            SingleNode cur = head;
            while (cur != null && cur.val != val) {
                cur = cur.next;
                i++;
            }
            if (cur != null) {
                return i;
            } else {
                return -1;
            }
        }
    }

    public void printAll() {
        System.out.print("[");
        SingleNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
            if (cur != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        final SingleLinkedList list = new SingleLinkedList();
        list.addHead(1); // 1
        list.addHead(2); // 2, 1
        list.addTail(3); // 2, 1, 3
        list.add(2, 5);// 2, 1, 5, 3
        list.remove(1); // 2, 5, 3
        list.printAll();
        System.out.println(list.getIndexByVal(5));
    }


    public static class SingleNode {
        public int val;
        public SingleNode next;

        public SingleNode(int val, SingleNode next) {
            this.val = val;
            this.next = next;
        }

        public void printAll() {
            System.out.print("[");
            SingleNode cur = this;
            while (cur != null) {
                System.out.print(cur.val);
                cur = cur.next;
                if (cur != null) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
