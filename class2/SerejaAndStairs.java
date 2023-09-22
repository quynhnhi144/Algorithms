package SCPT.class2;

import java.util.*;

public class SerejaAndStairs {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int[] a = new int[1000005];
    static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) {

        solve();

    }

    static void solve() {
        n = ip.nextInt();

        /**
         * Create array with index is the number of element
         * 1 1 2 2 3 3
         * a[1] = 2
         * a[2] = 2
         * a[3] = 2
         * */

        for (int i = 1; i <= n; i++) {
            int x = ip.nextInt();
            a[x]++;
        }

        int max = 0;
        for (int i = 1; i <= 5005; i++) {
            if (a[i] >= 1) {
                max = i;
                results.add(i);
                a[i]--;
            }
        }

        for (int i = max - 1; i >= 1; i--) {
            if (a[i] >= 1) {
                results.add(i);
                a[i]--;
            }
        }
        System.out.println(results.size());
        for (int i = 0; i < results.size(); i++) {
            System.out.print(results.get(i) + " ");
        }
    }
}
