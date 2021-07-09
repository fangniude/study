package base.array;

import static java.lang.System.out;

public class MyArrayList {
    private int[] data;
    private int length;

    public MyArrayList() {
        this.data = new int[10];
        this.length = 0;
    }

    public MyArrayList(int capacity) {
        this.data = new int[capacity];
        this.length = 0;
    }

    public void add(int val) {
        check();
        this.data[length++] = val;
    }

    private void check() {
        if (this.length == data.length) {
            int[] newData = new int[data.length * 2];
            System.arraycopy(this.data, 0, newData, 0, data.length);
            this.data = newData;
        }
    }

    public void add(int index, int val) {
        check();
        if (index >= length) {
            add(val);
        } else {
            for (int i = length; i > index; i--) {
                data[i] = data[i - 1];
                if (i == index + 1) {
                    data[index] = val;
                    length++;
                    break;
                }
            }
        }
    }

    public void remove(int index) {
        if (index < length) {
            System.arraycopy(data, index + 1, data, index, length - 1 - index);
            length--;
        }
    }

    public int get(int index) {
        if (index >= length) {
            return -1;
        } else {
            return data[index];
        }
    }

    public static void main(String[] args) {
        final MyArrayList list = new MyArrayList();

        list.printAll();
        list.add(0, 3);// 3
        list.add(0, 4);// 43
        list.add(1, 5);// 453
        list.add(3, 9);// 4539
        list.add(3, 10);// 453109
        list.add(7); // 4,5,3,10,9,7
        list.remove(3); // 4, 5 ,3, 9, 7
        list.printAll();
    }

    private void printAll() {
        out.print("[");
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                out.print(",");
            }
            out.print(data[i]);
        }
        out.println("]");
    }
}
