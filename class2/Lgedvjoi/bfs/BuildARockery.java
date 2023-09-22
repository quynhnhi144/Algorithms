//Build a rockery
package SCPT.class2.Learning.bfs;

import java.util.*;

public class BuildARockery {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int[][] a = new int[55][55];
    static boolean[][] visited = new boolean[55][55];
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) {
        n = ip.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = ip.nextInt();
            }
        }
        int hmin = 11;
        int max = Integer.MIN_VALUE;
        for (int h = 1; h <= 10; h++) {
            int count = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    visited[i][j] = false;
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (visited[i][j] == false && a[i][j] > h) {
                        bfs(i, j, h);
                        count++;
                    }
                }
            }
            if (max < count) {
                max = count;
                hmin = h;
            }

        }

        System.out.println(hmin);

    }

    static boolean isValid(Point point) {
        if (point.x <= 0 || point.x > n || point.y <= 0 || point.y > n) {
            return false;
        }
        return true;
    }

    static void bfs(int s1, int s2, int level) {
        visited[s1][s2] = true;
        Queue<Point> queue = new LinkedList();
        queue.add(new Point(s1, s2));

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i]);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && a[newPoint.x][newPoint.y] > level) {
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
