package SCPT.class2.Learning.stack;

import java.util.*;

public class Stack3 {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int[] a = new int[100006];
    static int[] ans = new int[100006];
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        solve();
    }

    static void solve(){
        n = ip.nextInt();
        for(int i = 1; i <= n; i++){
            a[i] = ip.nextInt();
        }

        for(int i = 1; i <= n; i++){
            while(!stack.isEmpty() && a[i] <= a[stack.peek()]){
                ans[stack.peek()] = a[stack.peek()] - a[i];
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            ans[stack.peek()] = a[stack.peek()];
            stack.pop();
        }

        for(int i = 1; i <= n; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
