package SCPT.class2.Learning.bfs;

import java.util.*;

public class MinimumKnightMoves {
    static Scanner ip = new Scanner(System.in);
    static int t;
    static boolean[][] visited = new boolean[10][10];
    static long[][] dist = new long[10][10];
    static int[] dx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
    static long oo = (long) 1e18;

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        t = ip.nextInt();
        while (t-- > 0) {
            String s1 = ip.next();
            String s2 = ip.next();
            int t1, t2, d1, d2;
            /**
             * a1 h8
             * => 11 88
             * */
            // - a + 1 = 1
            t1 = s1.charAt(0) - 'a' + 1;
            t2 = s1.charAt(1) - '0';

            d1 = s2.charAt(0) - 'a' + 1;
            d2 = s2.charAt(1) - '0';
            bfs(t1, t2);
            System.out.println(dist[d1][d2]);
        }
    }

    static void bfs(int o1, int o2) {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                visited[i][j] = false;
                dist[i][j] = oo;
            }
        }

        visited[o1][o2] = true;
        dist[o1][o2] = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(o1, o2));

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            for (int i = 0; i <= 7; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i]);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false) {
                    visited[newPoint.x][newPoint.y] = true;
                    dist[newPoint.x][newPoint.y] = dist[currentPoint.x][currentPoint.y] + 1;
                    queue.add(newPoint);
                }
            }
        }
    }

    static boolean isValid(Point point) {
        if (point.x <= 0 || point.x > 8 || point.y <= 0 || point.y > 8) {
            return false;
        }
        return true;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
