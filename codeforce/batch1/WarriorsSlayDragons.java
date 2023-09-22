package SCPT.codeforce.batch1;

import java.io.*;
import java.util.*;

public class WarriorsSlayDragons {
    static BufferedReader ip = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static long[] arrayHeroes = new long[200005];

    static int m;
    static long totalStrength = 0;
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        solve();
    }

    static void solve() throws IOException {
        n = Integer.parseInt(ip.readLine());
        String[] tokens = ip.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            arrayHeroes[i] = Long.parseLong(tokens[i - 1]);
            totalStrength += arrayHeroes[i];
        }

        m = Integer.parseInt(ip.readLine());
        Arrays.sort(arrayHeroes, 1, n + 1);
        for (int i = 1; i <= m; i++) {
            tokens = ip.readLine().split(" ");
            System.out.println(minimumNumberOfCoin(new Dragon(Long.parseLong(tokens[0]), Long.parseLong(tokens[1]))));
        }
    }

    static long minimumNumberOfCoin(Dragon dragon) {
        // binarysearch to find the greatest number less than Dragon.x
        int l = 1;
        int r = n;
        int pos = 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arrayHeroes[mid] < dragon.x) {
                pos = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // Choose the greatest number lesser than dragon.x
        ans = Math.max(0, dragon.x - arrayHeroes[pos]) + Math.max(0, dragon.y - (totalStrength - arrayHeroes[pos]));

        // Choose the smallest number greater than dragon.x
        if (pos != n) {
            ans = Math.min(ans, Math.max(0, dragon.x - arrayHeroes[pos + 1]) + Math.max(0, dragon.y - (totalStrength - arrayHeroes[pos + 1])));
        }
        return ans;
    }

    static class Dragon {
        long x;
        long y;

        Dragon(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
