//So lon nha be hon k
package SCPT.class2.Learning.binarysearch;

import java.util.*;

public class BinarySearch3 {
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
            long pos = solve(k);
            if (pos > 0) {
                System.out.println(a[(int)pos]);
            } else {
                System.out.println("NONE");
            }
        }
    }

    static long solve(long k) {
        int l = 1;
        int r = n;
        long pos = -1;
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

    static boolean check(int mid, long k){
        if(a[mid] < k){
            return true;
        }
        return false;
    }
}
