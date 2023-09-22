package SCPT.class2.pretest;

import java.util.*;

public class Books {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static long t;
    static int[] dp;
    static List<Integer> array = new ArrayList<>();

    public static void main(String[] args) {
        n = ip.nextInt();
        t = ip.nextLong();
        for (int i = 0; i < n; i++) {
            array.add(ip.nextInt());
        }
        array.sort((o1, o2) -> o1 - o2);
        long timeReaded = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = array.get(i);
            for (int j = 0; j < i; j++) {
                timeReaded += array.get(j);
                if (t >= timeReaded) {
//                    dp[i] = Math.min(dp[i], dp[j] + points.get(i).money);
//                    ans = Math.max(ans, dp[i]);
                }

            }
            timeReaded += array.get(i);
            if (t >= timeReaded) {
                count++;
            }
        }

        System.out.println(count);
    }
}
