// Bai toan ba lo
package SCPT.class2.Learning.dynamic_programming;

import java.util.*;

public class Knapsack {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int largestWeight;
    static long w[] = new long[100 + 5];
    static long v[] = new long[100 + 5];
    static long dp[][] = new long[100 + 5][100000 + 5];

    public static void main(String[] args) {
        n = ip.nextInt();
        largestWeight = ip.nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = ip.nextLong();
            v[i] = ip.nextLong();
        }
        solve();
    }

    public static void solve() {
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= largestWeight; j++) {
                // dp[i][j]: Max value of bag when choosing item 1, 2, 3, ... i
                // Don't choose the item i order to push into bag
                dp[i][j] = dp[i - 1][j];

                // Choose the item i order to push into bag
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - (int)w[i]] + v[i]);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
//        System.out.println(dp[n][largestWeight]);
        System.out.println(ans);
    }
}
