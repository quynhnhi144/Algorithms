//Buy Books
package SCPT.class2.Learning.binarysearch;

import java.util.*;

public class BuyBooks {
    static int n;
    static List<Long> a = new ArrayList();
    static Scanner ip = new Scanner(System.in);

    public static void main(String[] args) {
        n = Integer.parseInt(ip.nextLine());
        for (int i = 0; i < n; i++) {
            a.add(Long.parseLong(ip.nextLine()));
        }
        solve();
    }

    static void solve() {
        long sum = 0;
        Collections.sort(a, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 3 != 0) {
                sum += a.get(i);
            }
        }
        System.out.println(sum);
    }
}
