package SCPT.class2;

import java.util.*;

public class CustomisingTheTrack {
    static Scanner ip = new Scanner(System.in);
    static int t;

    public static void main(String[] args) {
        t = ip.nextInt();
        while (t-- > 0) {
            long n = ip.nextLong();
            long[] a = new long[(int)n + 5];
            for (int i = 1; i <= n; i++) {
                a[i] = ip.nextInt();
            }
            solve(n, a);
        }
    }

    static void solve(long n, long[] a) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += a[i];
        }
        /**
         * average = sum / n
         * full fill elements = average
         * add remain to element
         * Choose the number of number > average and they are the same
         * Choose the number of number = average and they are the same
         * Ex: 3 5 7 4
         * Average = (3 + 5 + 7 + 4) / 4 = 19 / 4 = 4
         * Remain = (3 + 5 + 7 + 4) % 4 = 3
         * new a[] = (4 + 1) (4 + 1) (4 + 1) 4
         * the number of number > average(a[i]) = 3 = remain
         * the number of number = average(a[j]) = 1 = n - remain = 4 - 3
         * */
        long remain = sum % n;
        long numbersEqualAverage = n - remain;
        System.out.println(remain * numbersEqualAverage);

    }
}
