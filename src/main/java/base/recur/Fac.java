package base.recur;

import java.util.ArrayList;
import java.util.List;

public class Fac {
    public static int fac(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return n * fac(n - 1);
        }
    }
}
