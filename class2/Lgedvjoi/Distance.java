package SCPT.class2.batch4;

import java.util.*;

public class Distance {
    static Scanner ip = new Scanner(System.in);
    static int t;
    static int x;
    static int y;

    public static void main(String[] args) {
        t = ip.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        x = ip.nextInt();
        y = ip.nextInt();

        if ((x + y) % 2 != 0) {
            System.out.println(-1 + " " + -1);
        } else {
            int xc1 = (x - y) / 2;
            int yc1 = y;

            int xc2 = x;
            int yc2 = (y - x) / 2;

            if (xc1 < 0 || yc1 < 0) {
                System.out.println(xc2 + " " + yc2);
            } else {
                System.out.println(xc1 + " " + yc1);
            }
        }
    }
}
