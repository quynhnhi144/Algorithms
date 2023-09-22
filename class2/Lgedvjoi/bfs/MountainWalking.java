package SCPT.class2.Learning.bfs;

import java.util.*;

public class MountainWalking {
    static Scanner ip = new Scanner(System.in);
    static int n, m;
    static int[][] array = new int[105][105];
    static boolean[][] visited = new boolean[105][105];
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        n = ip.nextInt();
        m = ip.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                array[i][j] = ip.nextInt();
                visited[i][j] = false;
            }
        }

        for (int i = 0; i <= 110; i++) {
            for (int j = i; j <= 110; j++) {
                if (array[1][1] >= i && array[1][1] <= j) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(ans);
    }

    static void bfs(int begin, int end) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                visited[i][j] = false;
            }
        }

        Point o = new Point(1, 1, array[1][1]);

        visited[1][1] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.add(o);

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            for (int i = 0; i <= 3; i++) {
                int newPointX = currentPoint.x + dx[i];
                int newPointY = currentPoint.y + dy[i];
                Point newPoint = new Point(newPointX, newPointY, array[newPointX][newPointY]);
                if (isValid(newPoint) && visited[newPointX][newPointY] == false && newPoint.dist >= begin && newPoint.dist <= end) {
                    visited[newPointX][newPointY] = true;
                    queue.add(newPoint);
                }
            }
        }
        if (visited[n][m]) {
            ans = Math.min(ans, end - begin);
        }
    }

    static boolean isValid(Point p) {
        if (p.x < 1 || p.x > n || p.y < 1 || p.y > m) {
            return false;
        }
        return true;
    }

    static class Point {
        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
