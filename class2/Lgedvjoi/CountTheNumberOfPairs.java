package SCPT.class2.batch4;

import java.util.*;

public class CountTheNumberOfPairs {
    static Scanner ip = new Scanner(System.in);
    static long n, l, r;
    static int t;

    public static void main(String[] args) {
        t = ip.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        n = ip.nextLong();
        l = ip.nextLong();
        r = ip.nextLong();

        List<Integer> array = new ArrayList();

        int count = 0;
        for (int i = 0; i < n; i++) {
            array.add(ip.nextInt());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((array.get(i) + array.get(j)) >= l && (array.get(i) + array.get(j)) <= r) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
