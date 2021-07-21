package base.recur;

import java.util.Map;

public class Feb {
    public static int feb(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return feb(n - 1) + feb(n - 2);
        }
    }

    public static int feb(Map<Integer, Integer> map, int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else if (map.containsKey(n)) {
            return map.get(n);
        } else {
            final int val = feb(n - 1) + feb(n - 2);
            map.put(n, val);
            return val;
        }
    }
    public static int feb2(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            int prePre = 1;
            int pre = 1;
            int i = 3;
            while (i <= n) {
                int tmp = prePre + pre;
                prePre = pre;
                pre = tmp;
                i++;
            }
            return pre;
        }
    }
}
