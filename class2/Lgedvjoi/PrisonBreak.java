package SCPT.class2.batch4;

import java.util.*;

public class PrisonBreak {
    static Scanner ip = new Scanner(System.in);
    static int t;
    static long n, m, r, c;

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        t = ip.nextInt();
        while (t-- > 0) {
            n = ip.nextLong();
            m = ip.nextLong();
            r = ip.nextLong();
            c = ip.nextLong();

            /**
             * Tìm khoảng thời gian(số bước) để đi từ 1 cell bất kỳ đến cel(r,c)
             * Nếu cell(i,j) càng xa thì số bước càng lớn
             * Những điểm phù hợp: 4 điểm ở 4 góc của hình chữ nhật
             * Số bước đi theo chiều ngang (r - 1, n - r) + số bước đi theo chiều dọc(c - 1, m - c)
             */

            long maxRowSteps = Math.max(r - 1, n - r);
            long maxColumSteps = Math.max(c - 1, m - c);
            System.out.println(maxRowSteps + maxColumSteps);
        }
    }
}
