package SCPT.class2.batch2;

import java.util.*;

public class WickAndPencils2 {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int[] a = new int[5005];

    public static void main(String[] args) {
        n = ip.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = ip.nextInt();
        }
        solve();
    }

    static void solve() {
        Arrays.sort(a, 1, n + 1);
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (((a[i] + a[j] + a[k]) != (a[i] * 3)) && (a[i] + a[j] > a[k])) {
                        if (a[i] == a[j] || a[i] == a[k] || a[j] == a[k]) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
