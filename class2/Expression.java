//Expression
package SCPT.class2;

import java.util.*;

public class Expression {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int k;
    static Long[] a;

    public static void main(String[] args) {
        n = ip.nextInt();
        k = ip.nextInt();
        solve();
    }

    static void solve() {
        a = new Long[n + 5];
        for (int i = 0; i < n; i++) {
            a[i] = ip.nextLong();
        }
        long expresionResult = a[0];
        Arrays.sort(a, 1, n, ((o1, o2) -> (int) (o2 - o1)));
        for(int i = 1; i < n; i++){
            if(i <= k){
                expresionResult += a[i];
            } else{
                expresionResult -= a[i];
            }
        }
        System.out.println(expresionResult);
    }
}
