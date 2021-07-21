package base.sort;

public class QuickSort {
    public static void quickSort(int[] items) {
        quickSort(items, 0, items.length);
    }

    private static void quickSort(int[] items, int begin, int end) {
        if (end - begin == 2) {
            if (items[begin] > items[begin + 1]) {
                int tmp = items[begin];
                items[begin] = items[begin + 1];
                items[begin + 1] = tmp;
            }
        } else if (end - begin > 2) {
            int middle = partion(items, begin, end);
            quickSort(items, begin, middle);
            quickSort(items, middle + 1, end);
        }
    }

    private static int partion(int[] items, int begin, int end) {
        int val = items[begin];

        int result = begin;
        for(int i = begin + 1; i < end; i++) {
            if (items[i] < val) {
                int tmp = items[i];
                items[i] = items[result];
                items[result] = tmp;
                result = i;
            }
        }

        return result;
    }
}
