package array;

/**
 * 实现一个支持动态扩容的数组
 * <p>
 * 1. 支持尾部增加，插入，删除
 * 2. 支持动态扩容
 */
public class Array {
    private Object[] data;
    private int size;

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        this.data = new Object[capacity];
        this.size = 0;
    }

    public void add(Object obj) {
        if (size == data.length) {
            resize();
        }
        this.data[size] = obj;
        size++;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Object result = this.data[index];
        for (int i = index; i < size - 1; i++) {
            this.data[i] = data[i + 1];
        }
        this.size--;
        return result;
    }

    public void insert(int index, Object obj) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == data.length) {
            resize();
        }

        for (int i = size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }

        this.data[index] = obj;
        this.size++;
    }

    private void resize() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }

    public void printAll() {
        System.out.printf("Size: %d%n", this.size);
        for (int i = 0; i < size; i++) {
            System.out.printf("%d: %s, ", i, this.data[i].toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array a = new Array();

        for (int i = 0; i < 15; i++) {
            a.add(i);
        }
        a.printAll();

        a.insert(10, 100);
        a.printAll();

        a.remove(10);
        a.printAll();

        a.insert(15, 100);
        a.printAll();
        a.remove(15);
        a.printAll();

        a.insert(0, 100);
        a.printAll();
        a.remove(0);
        a.printAll();
    }
}
