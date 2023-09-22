//Rising of sear level
package SCPT.class2.Learning.bfs;

import java.util.*;

public class RisingOfSeaLevel {
    static Scanner ip = new Scanner(System.in);
    static int n, m;
    static int[][] a = new int[105][105];
    static boolean[][] visited = new boolean[105][105];
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) {
        n = ip.nextInt();
        m = ip.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = ip.nextInt();
            }
        }

        for (int level = 0; level <= 1000; level++) {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    visited[i][j] = false;
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if ((i == 1 || i == n || j == 1 || j == m) && visited[i][j] == false && a[i][j] <= level) {
                        bfsFillWater(i, j, level);
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (visited[i][j] == false) {
                        bfsFillGrand(i, j, level);
                        count++;
                    }
                }
            }

            if (count >= 2) {
                System.out.println(level);
                return;
            }
        }
        System.out.println(-1);

    }

    static boolean isValid(Point point) {
        if (point.x <= 0 || point.x > n || point.y <= 0 || point.y > m) {
            return false;
        }
        return true;
    }

    static void bfsFillWater(int x, int y, int level) {
        visited[x][y] = true;

        Queue<Point> queue = new LinkedList();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i]);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && a[newPoint.x][newPoint.y] <= level) {
                    visited[newPoint.x][newPoint.y] = true;
                    queue.add(newPoint);
                }
            }

        }
    }

    static void bfsFillGrand(int x, int y, int level) {
        visited[x][y] = true;

        Queue<Point> queue = new LinkedList();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i]);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false) {
                    visited[newPoint.x][newPoint.y] = true;
                    queue.add(newPoint);
                }
            }

        }
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
