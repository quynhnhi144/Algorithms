package SCPT.codeforce.batch2;

import java.util.*;

public class CrazyChat {
    // Chat Ban
    static Scanner ip = new Scanner(System.in);
    static int t;

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        t = ip.nextInt();
        while (t-- > 0) {
            long k = ip.nextLong();
            long x = ip.nextLong();
            sumOfEmoji(k, x);
        }
    }

    /**
     * Cong thuc tong day so lien tiep: ((so dau + so cuoi)* so luong) / 2
     * Ex: Tong nua dau tien (1 2 3 4): (1 + k) * k / 2
     * Tong nua sau(3 2 1): (1 + k-1)*(k-1) / 2
     */

    static void sumOfEmoji(long k, long x) {
        long pos = 0;
        // TH1: x > tong cua cac emoji
        if (x > ((1 + k) * k / 2 + (1 + k - 1) * (k - 1) / 2)) {
            pos = 2 * k - 1;
        } else {
            // Ex: k = 4, x = 15
            /**
             * pos:            1 2 3 4   5  6  7
             * so luong emoji: 1 2 3 4   3  2  1
             * tong emoji:     1 3 6 10 13 15 16
             * -> pos = 6
             **/
            // Tim vi tri pos nho nhat sao cho tong emoji[pos] >= x -> Tim kiem nhi phan
            // Khong tao mang nhung tim cach tinh tong
            long l = 1;
            long r = 2 * k - 1;
            long tongEmoji = 0;
            while (l <= r) {
                long mid = (l + r) / 2;
                /**
                 * if pos <= k: tong_emoji[mid] = tong tu 1 den pos*/
                if (mid <= k) {
                    tongEmoji = (1 + mid) * mid / 2;

                } else {
                    long countEmoji = mid - k;
                    long posEndNumber = k - countEmoji;
                    // tong_emoji = tong 1 -> k + tong k-1 den so_luong_emoji
                    tongEmoji = ((1 + k) * k / 2) + ((k - 1 + posEndNumber) * countEmoji / 2);
                }
                if (tongEmoji >= x) {
                    pos = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

        }
        System.out.println(pos);
    }
}
