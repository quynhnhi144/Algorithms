package SCPT.class2.Learning.greedy;

import java.util.*;

public class MaximumProduct {
    static Scanner ip = new Scanner(System.in);
    static int t;
    static long ans;

    public static void main(String[] args) {
        t = Integer.parseInt(ip.nextLine());
        while (t-- > 0) {
            ans = Long.MIN_VALUE;
            solve();
        }
    }

    static void solve() {
        int n = ip.nextInt();
        long a[] = new long[n + 5];
        for (int i = 0; i < n; i++) {
            a[i] = ip.nextInt();
        }
        Arrays.sort(a, 0, n);
        // Case 1: All 5 elements are positive or negative numbers
        long m1 = a[n - 1] * a[n - 2] * a[n - 3] * a[n - 4] * a[n - 5];

        // Case 2: Having 2 negative numbers and 3 positive numbers
        long m2 = a[n - 1] * a[n - 2] * a[n - 3] * a[1] * a[0];

        long max12 = Math.max(m1, m2);

        // Case 3: Having 4 negative numbers and 1 positive number
        long m3 = a[n - 1] * a[3] * a[2] * a[1] * a[0];

        long max123 = Math.max(max12, m3);

        ans = Math.max(max123, ans);
        System.out.println(ans);
    }
}
