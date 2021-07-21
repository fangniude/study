package base.sort;

public class MergeSort {
    public static void mergeSort(int[] items) {
        mergesort(items, 0, items.length);
    }

    private static void mergesort(int[] items, int begin, int end) {
        final int size = end - begin;
        if (size == 2) {
            if (items[begin] > items[begin + 1]) {
                int tmp = items[begin];
                items[begin] = items[begin + 1];
                items[begin + 1] = tmp;
            }
        } else {
            int middle = (begin + end) / 2;
            mergesort(items, begin, middle);
            mergesort(items, middle, end);

            int[] tmp = new int[end - begin];
            int index = 0;
            int i = begin;
            int j = middle;
            while (i < middle && j < end) {
                if (items[i] <= items[j]) {
                    tmp[index++] = items[i++];
                } else {
                    tmp[index++] = items[j++];
                }
            }
            while (i < middle) {
                tmp[index++] = items[i++];
            }
            while (j < end) {
                tmp[index++] = items[j++];
            }

            System.arraycopy(tmp, 0, items, begin, tmp.length);
        }
    }

    private static void mergesort2(int[] items, int begin, int end) {
        final int size = end - begin;
        if (size == 2) {
            if (items[begin] > items[begin + 1]) {
                int tmp = items[begin];
                items[begin] = items[begin + 1];
                items[begin + 1] = tmp;
            }
        } else {
            int middle = (begin + end) / 2;
            mergesort(items, begin, middle);
            mergesort(items, middle, end);

            int[] left = new int[middle - begin + 1];
            int[] right = new int[end - middle + 1];
            System.arraycopy(items, begin, left, 0, left.length - 1);
            System.arraycopy(items, middle, right, 0, right.length - 1);
            left[left.length - 1] = Integer.MAX_VALUE;
            right[right.length - 1] = Integer.MAX_VALUE;

            int index = begin;
            int i = begin;
            int j = middle;
            while (index < end) {
                if (left[i]<=right[j]) {
                    items[index++] = left[i++];
                } else {
                    items[index++] = right[j++];
                }
            }
        }
    }
}
