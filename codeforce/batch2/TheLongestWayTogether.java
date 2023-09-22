package SCPT.codeforce.batch2;

import java.util.*;

public class TheLongestWayTogether {
    // Come Together
    static Scanner ip = new Scanner(System.in);
    static int t;

    public static void main(String[] args) {
        solve();
    }

    /**
     * If two points lie 2 sides -> Result = Min distance x AND distance y between original point(A) and each point (B and C)
     * If two points lie 1 side -> Result = Min distance x OR distance y between original point(A) and each point (B and C)
     * * * * C
     * B * *
     * A
     * ----------------
     * * * * C
     * * * * * B
     * A
     */
    static void solve() {
        int t = ip.nextInt();

        while (t-- > 0) {
            int xA = ip.nextInt();
            int yA = ip.nextInt();

            int xB = ip.nextInt();
            int yB = ip.nextInt();

            int xC = ip.nextInt();
            int yC = ip.nextInt();

            // Default beginning point is A -> ans = 1;
            int ans = 1;

            if ((xB > xA && xC > xA) || (xB < xA && xC < xA)) {
                ans += Math.min(Math.abs(xB - xA), Math.abs(xC - xA));
            }

            if ((yB > yA && yC > yA) || (yB < yA && yC < yA)) {
                ans += Math.min(Math.abs(yB - yA), Math.abs(Math.abs(yC - yA)));
            }

            System.out.println(ans);
        }
    }
}
