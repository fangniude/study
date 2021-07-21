package base.stack;

public class ArrStack {
    private int[] arr;
    private int pointer;

    public ArrStack() {
        this.arr = new int[100];
        this.pointer = 0;
    }

    public void push(int val) {
        this.arr[pointer++] = val;
    }

    public int pop() {
        return this.arr[pointer--];
    }

    public void printAll() {
        System.out.print("[");
        for (int i = 0; i < pointer; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(this.arr[i]);
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        final ArrStack stack = new ArrStack();
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.printAll();
        stack.pop();
        stack.printAll();
    }
}
