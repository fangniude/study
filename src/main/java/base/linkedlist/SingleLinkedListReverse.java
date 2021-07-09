package base.linkedlist;

import base.linkedlist.SingleLinkedList.SingleNode;

import java.util.HashMap;
import java.util.TreeMap;

public class SingleLinkedListReverse {
    public static SingleNode reverse(SingleNode node) {
        if (node == null) {
            return null;
        } else if (node.next == null) {
            return node;
        } else {
            final SingleNode nextNode = node.next;
            final SingleNode reversedNextNode = reverse(nextNode);
            nextNode.next = node;
            node.next = null;
            return reversedNextNode;
        }
    }

    public static SingleNode reverseLoop(SingleNode list) {
        SingleNode cur = list;
        SingleNode pre = null;
        while (cur != null) {
            final SingleNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        final SingleNode node = new SingleNode(1, new SingleNode(2, new SingleNode(3, new SingleNode(4, new SingleNode(5, null)))));
        node.printAll();
        reverse(reverse(node)).printAll();
        reverseLoop(reverseLoop(node)).printAll();
        reverseLoop(reverse(node)).printAll();
        reverse(reverseLoop(node)).printAll();
    }
}
