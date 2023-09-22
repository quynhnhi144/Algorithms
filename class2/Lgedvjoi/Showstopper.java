package SCPT.class2.batch4;

import java.util.*;

public class Showstopper {
    static Scanner ip = new Scanner(System.in);
    static int t;
    static int n;
    static int[] a = new int[105];
    static int[] b = new int[105];

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        t = ip.nextInt();
        while (t-- > 0) {
            n = ip.nextInt();
            for (int i = 1; i <= n; i++) {
                a[i] = ip.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                b[i] = ip.nextInt();

                /**
                 * Chuyen tat ca phan tu cua array a lon hon b
                 * Chuyen tat ca phan tu cua array b nho hon a
                 */
                if (a[i] < b[i]) {
                    int temp = a[i];
                    a[i] = b[i];
                    b[i] = temp;
                }
            }

            int maxA = Integer.MIN_VALUE;
            int maxB = Integer.MIN_VALUE;

            for (int i = 1; i <= n; i++) {
                maxA = Math.max(maxA, a[i]);
                maxB = Math.max(maxB, b[i]);
            }
            if (maxA == a[n] && maxB == b[n]) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
