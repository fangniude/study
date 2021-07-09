package base.linkedlist;

import base.linkedlist.SingleLinkedList.SingleNode;

public class SingleLinkedListMerge {
    public static SingleNode merge(SingleNode n1, SingleNode n2) {
        final SingleNode head = new SingleNode(-1, null);
        SingleNode last = head;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                last.next = new SingleNode(n1.val, null);
                last = last.next;
                n1 = n1.next;
            } else {
                last.next = new SingleNode(n2.val, null);
                last = last.next;
                n2 = n2.next;
            }
        }
        if (n1 != null) {
            last.next = n1;
        } else {
            last.next = n2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        final SingleNode node = new SingleNode(1, new SingleNode(2, new SingleNode(3, new SingleNode(4, new SingleNode(5, null)))));
        final SingleNode node1 = new SingleNode(0, new SingleNode(1, new SingleNode(2, new SingleNode(3, new SingleNode(4, new SingleNode(5, null))))));
        merge(node, node1).printAll();
    }
}
