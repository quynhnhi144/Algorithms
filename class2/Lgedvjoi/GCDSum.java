package SCPT.class2.batch4;

import java.util.*;

public class GCDSum {
    static Scanner ip = new Scanner(System.in);
    static int t;
    static long n;

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        t = ip.nextInt();
        while (t-- > 0) {
            n = ip.nextLong();
            long gcd  = 0;
            while(gcd <= 1){
                String nString = n + "";
                String[] c = nString.split("");
                long sum = 0;
                for (int i = 0; i < c.length; i++) {
                    sum += Integer.parseInt(c[i]);
                }
                gcd = gcd(n,sum);
                if(gcd > 1){
                    break;
                }
                n = n + 1;
            }

            System.out.println(n);

        }
    }

    static long gcd(long a, long b) {
        //find bcnn
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
