package base.queue;

public class CycleQueue {
    private int[] items;
    private int head;
    private int tail;

    public CycleQueue(int capacity) {
        this.items = new int[capacity];
        this.head = 0;
        this.tail = 0;
    }

    public boolean enqueue(int num) {
        if ((head + 1) % items.length == tail) {
            return false;
        } else {
            items[head] = num;
            if (head == items.length - 1) {
                head = 0;
            } else {
                head++;
            }
            return true;
        }
    }

    public Integer dequeue() {
        if (head == tail) {
            return null;
        } else {
            final int item = items[tail];
            if (tail == items.length - 1) {
                tail = 0;
            } else {
                tail++;
            }
            return item;
        }
    }
}
