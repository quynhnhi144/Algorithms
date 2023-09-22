package SCPT.class2batch3.codepro;

import java.util.*;

public class Clearance {
    Scanner ip = new Scanner(System.in);
    int n;
    int m;
    int[] array = new int[100005];
    int[] mPhanPhoi = new int[10];
    boolean[] used = new boolean[10];
    int[] hv = new int[10];
    List<int[]> mHoanVi = new ArrayList<>();
    int[][] mDemSoPhanTu = new int[10][100005];
    int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Clearance m = new Clearance();
        m.solve();
    }

    void solve() {
        n = ip.nextInt();
        m = ip.nextInt();
        for (int i = 1; i <= n; i++) {
            array[i] = ip.nextInt();

            // Đếm phân phối số lần xuất hiện các phần tử trong mảng
            ++mPhanPhoi[array[i]];
        }

        //Đếm số lượng của mỗi phần tử trong mảng
        for (int item = 1; item <= m; item++) {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (item == array[i]) {
                    count++;
                }
                mDemSoPhanTu[item][i] = count;
            }

        }

        // Sinh hoán vị các types
        gen(1);
        
        System.out.println(result);
    }

    // Hoán vị các types
    void gen(int index) {
        if (index > m) {
            result = Math.min(countTheDifferent(hv), result);
        } else {
            for (int val = 1; val <= m; val++) {
                if (used[val]) continue;
                hv[index] = val;
                used[val] = true;
                gen(index + 1);
                used[val] = false;
            }
        }
    }

    int countTheDifferent(int[] arraySwap) {
//        for(int i =1 ; i<= m; i++){
//            System.out.print(arraySwap[i] + " ");
//        }
//        System.out.println();
        int ans = 0;
        int start = 1;
        for (int i = 1; i <= m; i++) {
            int end = start + mPhanPhoi[arraySwap[i]] - 1;
//            System.out.println("start " + start + " end " + end);

            int cntGoc = mDemSoPhanTu[arraySwap[i]][end] - mDemSoPhanTu[arraySwap[i]][start - 1];
            ans += mPhanPhoi[arraySwap[i]] - cntGoc;

            start = end + 1;
        }
        return ans;
    }

}
