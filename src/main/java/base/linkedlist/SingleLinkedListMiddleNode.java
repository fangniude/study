package base.linkedlist;

import base.linkedlist.SingleLinkedList.SingleNode;

public class SingleLinkedListMiddleNode {
    public static SingleNode middleNode(SingleNode list) {
        SingleNode slow = list;
        SingleNode fast = list;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        final SingleNode node = new SingleNode(1, new SingleNode(2, new SingleNode(3, new SingleNode(4, new SingleNode(5, null)))));
        System.out.println(middleNode(node).val);
        final SingleNode node1 = new SingleNode(0, new SingleNode(1, new SingleNode(2, new SingleNode(3, new SingleNode(4, new SingleNode(5, null))))));
        System.out.println(middleNode(node1).val);
    }
}
