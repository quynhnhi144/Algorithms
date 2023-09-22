package SCPT.class2;

import java.util.*;

public class VisitingAFriend {
    static Scanner ip = new Scanner(System.in);
    // the number of teleports
    static int n;
    // the location of the friend's house
    static int m;
    static List<Point> points = new ArrayList();

    public static void main(String[] args) {
        n = ip.nextInt();
        m = ip.nextInt();

        for (int i = 0; i < n; i++) {
            points.add(new Point(ip.nextInt(), ip.nextInt()));
        }
        solve();
    }

    /**
     * max Distance Pig can move >= the next location teleport
     *
     * */

    static void solve() {
        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            if (points.get(i).index <=maxDistance) {
               if(maxDistance <= points.get(i).limit){
                   maxDistance = Math.max(maxDistance, points.get(i).limit);
               }
            }
        }

        if(maxDistance >= m){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static class Point {
        int index;
        int limit;

        public Point(int index, int limit) {
            this.index = index;
            this.limit = limit;
        }
    }
}
