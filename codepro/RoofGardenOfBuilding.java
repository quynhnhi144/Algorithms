// Roof Garden Of Building
package SCPT.class2batch3.codepro;

import java.util.*;

public class RoofGardenOfBuilding {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int[] h = new int[80010];
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        n = ip.nextInt();
        for (int i = 0; i < n; i++) {
            h[i] = ip.nextInt();
        }
        solve();
    }

    static void solve() {
        int ans = 0;
        // tao phan tu linh canh tai vi tri n
        h[n] = 1000000002;
        // dua toa nha dau tien vao stack
        stack.push(0);
        // duyet qua cac toa nha tu vi tri thu i ve phia ben trai va i = 1 -> n
        // cac vi tri toa nha trong stack co do cao giam dan
        for (int i = 1; i <= n; i++) {
            // tim ra toa nha ko theo thu tu giam dan
            if (h[i] >= h[stack.peek()]) {
                while (!stack.isEmpty() && h[i] >= h[stack.peek()]) {
                    // tinh cac toa nha duoc nhin thay tu toa nha trong stack
                    ans += i - stack.peek() - 1;
                    // xoa toa nha do ra khoi stack
                    stack.pop();
                }
            }
            stack.push(i);
        }
        System.out.println(ans);
    }
}
