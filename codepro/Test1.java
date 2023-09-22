package SCPT.class2batch3.codepro;

import java.util.*;

public class Test1 {
    private static Scanner ip = new Scanner(System.in);
    private static int n;
    private static int[] d = new int[100000 + 10];
    private static int sol = -30001;
    private static int[] dp = new int[100000 + 10];

    public static void main(String[] args) {
        n = ip.nextInt();
        for (int i = 0; i < n; i++) {
            d[i] = ip.nextInt();
        }
//        solve();
        solve3();
        System.out.println(sol);
    }

    public static int solve() {
        for (int i = 0; i < n; i++) {
            int  sum = 0;
            for (int j = i; j < n; j++) {
                sum += d[j];
                sol = (int) Math.max(sum, sol);
            }
        }
        return sol;
    }

    public static int solveDynamicProgramming() {
        for (int i = 0; i < n; i++) {
           dp[i] = d[i];
           if(i > 0 && dp[i - 1] > 0){
               dp[i] += dp[i  -1];
           }
           sol = Math.max(sol, dp[i]);
        }
        return sol;
    }

    void solve2(){
        boolean isCheck = false;
        for(int i = 0; i < n; i++){
            dp[i] = d[i];
            if(i > 0 && dp[i - 1] > 0){
                dp[i] += dp[i - 1];
                sol = Math.max(sol, dp[i]);
            } else if(i > 0 && d[i] <= 0 && (d[i] - d[i + 1] == 0)){
                isCheck = true;
                continue;
            }
        }
        if(isCheck){
            sol = d[0];
        }
    }

    static void solve3(){
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += d[i];
            sol = Math.max(sol, sum);
            sum = Math.max(sum, 0);
        }
    }
}
