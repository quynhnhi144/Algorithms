// Average Value
package SCPT.class2.Learning.binarysearch;

import java.util.*;

public class TheAverageValue {

    static Scanner ip = new Scanner(System.in);
    static int n;
    static long[] a = new long[1000005];
    static long[] average = new long[1000005];
    static int q;

    public static void main(String[] args) {
        n = ip.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = ip.nextLong();
        }
        Arrays.sort(a, 1, n + 1);
        calculateAverage(a);
        q = ip.nextInt();
        while (q-- > 0) {
            long k = ip.nextLong();
            System.out.println(solve(k));
        }
    }

    static void calculateAverage(long[] a) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += a[i];
            average[i] = sum / i;
        }
    }

    static long solve(long k) {
        int l = 1;
        int r = n;
        long pos = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid, k)) {
                pos = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return pos;
    }

    static boolean check(int mid, long k) {
        if (average[mid] < k) {
            return true;
        }
        return false;
    }
}
