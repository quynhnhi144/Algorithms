// BinarySearch
package SCPT.class2.Learning.binarysearch;

import java.util.*;

public class BinarySearch1 {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static long[] a = new long[100005];
    static int q;

    public static void main(String[] args) {
        n = ip.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = ip.nextLong();
        }
        Arrays.sort(a, 1, n + 1);
        q = ip.nextInt();
        while (q-- > 0) {
            long k = ip.nextLong();
            if (solve(k)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean solve(long k) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] == k) {
                return true;
            }
            if (a[mid] < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
