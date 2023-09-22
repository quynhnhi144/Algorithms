package SCPT.class2.Learning.stack;

import java.util.*;

public class Stack1 {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int[] a = new int[100006];
    static Stack<Integer> stack = new Stack();
    static int[] result = new int[100006];

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        n = ip.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = ip.nextInt();
        }

        stack.push(0);
        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
                result[stack.peek()] = a[i];
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            result[stack.peek()] = -1;
            stack.pop();
        }

        for(int i = 1; i <= n; i++){
            System.out.print(result[i] + " ");
        }
    }

}
