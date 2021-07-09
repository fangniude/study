package base.linkedlist;

import base.linkedlist.SingleLinkedList.SingleNode;

public class SingleLinkedListRemoveLastK {
    public static void removeLastK(SingleNode list, int k) {
        SingleNode fast = list;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        SingleNode slow = list;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
    }

    public static void main(String[] args) {
        final SingleNode node = new SingleNode(0, new SingleNode(1, new SingleNode(2, new SingleNode(3, new SingleNode(4, new SingleNode(5, null))))));
        node.printAll();
        removeLastK(node, 2);
        node.printAll();
    }
}
