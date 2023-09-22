//MeetingRoom2
package SCPT.class2.Learning.greedy;

import java.util.*;

public class MeetingRoom2 {
    static Scanner ip = new Scanner(System.in);
    static long n;
    static long[] dp;

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        n = ip.nextLong();
        dp = new long[(int) n + 5];
        List<Point> points = new ArrayList();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            points.add(new Point(ip.nextLong(), ip.nextLong(), ip.nextLong()));
        }

        points.sort((a, b) -> (int) (a.end - b.end));
        for (int i = 0; i < n; i++) {
            dp[i] = points.get(i).money; // dp[i] lon nhat khi chon meeting thu i
            for (int j = 0; j < i; j++) {
                if (points.get(i).start >= points.get(j).end) {
                    dp[i] = Math.max(dp[i], dp[j] + points.get(i).money);
                    ans = Math.max(ans, dp[i]);
                }

            }

        }
        System.out.println(ans);
    }

    static class Point {
        long start;
        long end;
        long money;

        public Point(long start, long end, long money) {
            this.start = start;
            this.end = end;
            this.money = money;
        }
    }
}