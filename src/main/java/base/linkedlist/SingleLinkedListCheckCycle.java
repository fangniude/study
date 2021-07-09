package base.linkedlist;

import base.linkedlist.SingleLinkedList.SingleNode;

public class SingleLinkedListCheckCycle {
    public static boolean checkCycle(SingleNode list) {
        SingleNode slow = list;
        SingleNode fast = list;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        final SingleNode node2 = new SingleNode(2, null);
        final SingleNode node1 = new SingleNode(1, node2);
        System.out.println(checkCycle(node1));

        final SingleNode node3 = new SingleNode(3, node1);
        node2.next = node3;
        System.out.println(checkCycle(node3));
    }
}
