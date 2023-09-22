package SCPT.class2.batch4;

import java.util.*;

public class LuckyNumber {
    static Scanner ip = new Scanner(System.in);
    static int t;
    static int l, r;

    public static void main(String[] args) {
        t = ip.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        l = ip.nextInt();
        r = ip.nextInt();
        int luckiest = -1;
        int ans = 0;
        for (int i = r; i >= l; i--) {
            int largestNumber = -1;
            int smallestNumber = Integer.MAX_VALUE;
            int a = i;
            while (a > 0) {
                largestNumber = Math.max(largestNumber, a % 10);
                smallestNumber = Math.min(smallestNumber, a % 10);
                a = a / 10;
            }
            if (largestNumber - smallestNumber > luckiest) {
                luckiest = largestNumber - smallestNumber;
                ans = i;
            }
            if (luckiest == 9) {
                break;
            }
        }
        System.out.println(ans);
    }
}
