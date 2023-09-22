package SCPT.class2.batch4;

import java.util.*;

public class MKnezConstructiveForcesTask {
    static Scanner ip = new Scanner(System.in);
    static int t;
    static int n;

    public static void main(String[] args) {
        t = ip.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        n = ip.nextInt();
        /**
         * Nếu n chẵn thì các số trong mảng để đơn giản là : -1 1
         * Vd: n = 4 -> -1 1 -1 1
         *
         * Nếu n lẻ thì phải xem số lượng xuất hiện và giá trị của số đó sao cho tổng 2 số liên tiếp
         * bằng tổng của tất cả các thành phần trong mảng
         * vd: n = 5: a1 a2 a3 a4 a5
         *            a1 + a2 = a2 + a3 -> a1 = a3
         *          -> a1 + a2 + a1 + a2 + a1
         *            (n + 1)a/2 + (n-1)b/2 = a + b
         *            a(n-1) = b(3 - n)
         *          -> a= 3 - n
         *             b = n - 1*/

        if (n % 2 == 0) {
            System.out.println("Yes");
            for (int i = 0; i < n / 2; i++) {
                System.out.println("-1 1");
            }
            System.out.println();
        } else if (n == 1 || n == 3) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
            for (int i = 0; i < n / 2; i++) {
                System.out.print((3 - n) + " " + (n - 1) + " ");
            }
            System.out.println(3 - n + " ");
        }
    }
}
