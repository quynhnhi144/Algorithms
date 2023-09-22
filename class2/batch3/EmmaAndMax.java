package SCPT.class2.batch3;

import java.util.*;

public class EmmaAndMax {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int[] array = new int[105];
    static long p, q;

    public static void main(String[] args) {
        solve2();
    }

    static void solve2() {
        n = ip.nextInt();
        for (int i = 1; i <= n; i++) {
            array[i] = ip.nextInt();
        }
        p = ip.nextLong();
        q = ip.nextLong();
        long max = Integer.MAX_VALUE;
        long minq = Integer.MAX_VALUE;

        // p
        for (int i = 1; i <= n; i++) {
            max = Math.min(max, Math.abs(p - array[i]));
        }

        long saveM = p;

        // mid
        for (int i = 1; i < n; i++) {
            int mid = (array[i] + array[i + 1]) / 2;
            if (mid >= p && mid <= q) {
                if (max < Math.abs(mid - array[i])){
                    max = Math.abs(mid - array[i]);
                    saveM = mid;
                }
            }
        }

        // max
        for (int i = 1; i <= n; i++) {
            minq = Math.min(minq, Math.abs(q - array[i]));
        }

        if(max < minq){
            saveM = q;
        }
        System.out.println(saveM);

    }
}
