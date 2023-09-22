package SCPT.class2.Learning.stack;

import java.util.*;

public class Stack2 {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int[] a = new int[100006];
    static Stack<Integer> stack = new Stack();
    static int[] result = new int[100006];

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        n = ip.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = ip.nextInt();
        }

        /**
         * Circular array means: array = {8, 3, 7} => circular array: {8, 3, 7, 8, 3, 7}
         * KO tao ra mang circular array.
         * Duyet mang tu phai sang trai
         * Day cac phan tu cua array vao stack stack: [7, 3, 8]
         * Duyet lai cai phan tu array(7, 3, 8) voi stack -> tao ra duoc mang circular array: {8, 3, 7, 8, 3, 7}
         * i = 2*n - 1
         * thực hiện kiểm tra a[i % n] và a[stack.peek()]*/

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[i % n] >= stack.peek()) {
                stack.pop();
            }

            if (i < n) {
                if (!stack.isEmpty()) {
                    result[i] = stack.peek();
                } else {
                    result[i] = -1;
                }
            }

            stack.push(a[i % n]);
        }


        // in mang result
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
