package base.sort;

import java.util.ArrayList;

public class BaseSort {

    public static void main(String[] args) {
        final int size = 1000000;
        final ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * size));
        }

        final int[] nums1 = list.stream().mapToInt(i -> i).toArray();
        final int[] nums2 = list.stream().mapToInt(i -> i).toArray();
        final int[] nums3 = list.stream().mapToInt(i -> i).toArray();
        final int[] nums4 = list.stream().mapToInt(i -> i).toArray();
        final int[] nums5 = list.stream().mapToInt(i -> i).toArray();
        final int[] nums6 = list.stream().mapToInt(i -> i).toArray();


        final long l0 = System.currentTimeMillis();
//        final int[] a = bubbleSort(nums1);
//        System.out.println(Arrays.toString(a));
        final long l1 = System.currentTimeMillis();
        System.out.println(l1 - l0);

//        final int[] a1 = bubbleSortWithSwapCheck(nums2);
//        System.out.println(Arrays.toString(a1));
        final long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);

//        final int[] a2 = bubbleSortWithSwapCheckAndRange(nums3);
//        System.out.println(Arrays.toString(a2));
        final long l3 = System.currentTimeMillis();
        System.out.println(l3 - l2);

//        final int[] a3 = bubbleSortWithSwapIndex(nums4);
//        System.out.println(Arrays.toString(a3));
        final long l4 = System.currentTimeMillis();
        System.out.println(l4 - l3);

        final int[] a4 = insertionSort2(nums5);
//        System.out.println(Arrays.toString(a3));
        final long l5 = System.currentTimeMillis();
        System.out.println(l5 - l4);

        final int[] a5 = quickSort(nums6);
//        System.out.println(Arrays.toString(a3));
        final long l6 = System.currentTimeMillis();
        System.out.println(l6 - l5);
    }

    public static int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length);
        return nums;
    }

    private static void quickSort(int[] nums, int begin, int end) {
        if (end - begin == 2) {
            if (nums[begin] > nums[begin + 1]) {
                int tmp = nums[begin];
                nums[begin] = nums[begin + 1];
                nums[begin + 1] = tmp;
            }
        } else if (end - begin > 2) {
            int middle = partition(nums, begin, end);
            quickSort(nums, begin, middle);
            quickSort(nums, middle + 1, end);
        }
    }

    private static int partition(int[] nums, int begin, int end) {
        int result = begin;
        int val = nums[begin];
        for (int i = begin + 1; i < end; i++) {
            if (nums[i] < val) {
                int tmp = nums[i];
                result++;
                nums[i] = nums[result];
                nums[result] = tmp;
            }
        }

        if (result > begin) {
            nums[begin] = nums[result];
            nums[result] = val;
        }

        return result;
    }

    public static int[] insertionSort2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];

            int index = findIndex(nums, 0, i, n);

            if (index < i) {
                System.arraycopy(nums, index, nums, index + 1, i - index);
                nums[index] = n;
            }
        }
        return nums;
    }

    private static int findIndex(int[] nums, int begin, int end, int n) {
        if (nums[begin] > n) {
            return begin;
        } else if (nums[end - 1] <= n) {
            return end;
        } else {
            int middle = begin + (end - begin) / 2;
            if (nums[middle] > n) {
                return findIndex(nums, begin, middle, n);
            } else {
                return findIndex(nums, middle, end, n);
            }
        }
    }

    public static int[] bubbleSort(int[] nums) {
        // i is the begin of sorted range, from nums.length ~ 1
        for (int i = nums.length; i > 1; i--) {
            // j is the next max value pointer
            for (int j = 1; j < i; j++) {
                int n = nums[j];
                // exchange if the bubble > the next
                if (n < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                    nums[j - 1] = n;
                }
            }
        }
        return nums;
    }

    public static int[] bubbleSortWithSwapCheck(int[] nums) {
        // bubble sort, add has swap check

        // i is the begin of sorted range, from nums.length ~ 1,
        for (int i = nums.length; i > 1; i--) {
            // check has swap
            boolean hasSwap = false;
            // j is the next max value pointer
            for (int j = 1; j < i; j++) {
                int n = nums[j];
                // exchange if the bubble > the next
                if (n < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                    nums[j - 1] = n;
                    hasSwap = true;
                }
            }

            if (!hasSwap) {
                break;
            }
        }
        return nums;
    }

    public static int[] bubbleSortWithSwapCheckAndRange(int[] nums) {
        // bubble sort, add has swap check, add the sorted range

        // i is the begin of sorted range, from nums.length ~ 1,
        for (int i = nums.length; i > 1; ) {
            // check has swap
            boolean hasSwap = false;
            // swap index
            int swapIndex = 0;
            // j is the next max value pointer
            for (int j = 1; j < i; j++) {
                int n = nums[j];
                // exchange if the bubble > the next
                if (n < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                    nums[j - 1] = n;
                    hasSwap = true;
                    swapIndex = j;
                }
            }
            i = swapIndex;

            if (!hasSwap) {
                break;
            }
        }
        return nums;
    }

    public static int[] bubbleSortWithSwapIndex(int[] nums) {
        // bubble sort, add has swap check, add the sorted range

        // i is the begin of sorted range, from nums.length ~ 1,
        for (int i = nums.length; i > 1; ) {
            // swap index
            int swapIndex = 0;
            // j is the next max value pointer
            for (int j = 1; j < i; j++) {
                int n = nums[j];
                // exchange if the bubble > the next
                if (n < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                    nums[j - 1] = n;
                    swapIndex = j;
                }
            }


            if (swapIndex == 0) {
                break;
            } else {
                i = swapIndex;
            }
        }
        return nums;
    }


    public static void bubbleSort2(int[] items) {
        int lastExchange = items.length - 1;
        for (int i = 0; i < items.length; i++) {
            boolean flag = true;
            int sortBorder = 0;
            for (int j = 0; j < lastExchange; j++) {
                int item = items[j];
                if (item > items[j + 1]) {
                    items[j] = items[j + 1];
                    items[j + 1] = item;
                    flag = false;
                    sortBorder = j;
                }
            }
            lastExchange = sortBorder;
            if (flag) {
                break;
            }
        }
    }

    public static void insertionSort(int[] items) {
        for (int i = 1; i < items.length; i++) {
            int item = items[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (items[j] > item) {
                    items[j + 1] = items[j];
                } else {
                    break;
                }
            }
            items[j + 1] = item;
        }
    }

    public static void selectionSort(int[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            int item = items[i];

            int minIndex = 0;
            for (int j = i; j < items.length; j++) {
                if (items[j] < items[minIndex]) {
                    minIndex = j;
                }
            }
            items[i] = items[minIndex];
            items[minIndex] = item;
        }
    }
}
