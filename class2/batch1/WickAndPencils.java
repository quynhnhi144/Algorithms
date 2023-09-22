package SCPT.class2.batch1;

import java.util.*;

public class WickAndPencils {
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
        int count = 0;
        Arrays.sort(a, 1, n + 1);
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (a[i] + a[j] > a[k]) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }

}
