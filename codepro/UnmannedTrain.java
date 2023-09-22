package SCPT.class2batch3.codepro;

import java.util.*;

public class UnmannedTrain {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int m;
    static int[][] a = new int[55][55];
    static boolean[][] visited = new boolean[55][55];
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static Queue<Point> points1 = new LinkedList();
    static int[][] dist = new int[55][55];
    static int oo = 100000000;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        n = ip.nextInt();
        m = ip.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = ip.nextInt();
                visited[i][j] = false;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] == 1) {
                    bfs(i, j);
                    bfs2(points1);
                    System.out.println(ans);
                    return;
                }
            }
        }
    }

    static boolean isValid(Point point) {
        if (point.x <= 0 || point.x > n || point.y <= 0 || point.y > m) {
            return false;
        }
        return true;
    }

    static void bfs(int s1, int s2) {
        visited[s1][s2] = true;
        Queue<Point> queue = new LinkedList();
        queue.add(new Point(s1, s2));

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            points1.add(currentPoint);
            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i]);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && a[newPoint.x][newPoint.y] == 1) {
                    visited[newPoint.x][newPoint.y] = true;
                    queue.add(newPoint);
                }
            }
        }
    }

    static void bfs2(Queue<Point> points) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dist[i][j] = oo;
            }
        }

        for (Point point : points) {
            dist[point.x][point.y] = 0;
        }

        while (!points.isEmpty()) {
            Point currentPoint = points.poll();
            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i]);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false) {
                    if (a[newPoint.x][newPoint.y] != 1) {
                        visited[newPoint.x][newPoint.y] = true;
                        dist[newPoint.x][newPoint.y] = dist[currentPoint.x][currentPoint.y] + 1;
                        points.add(newPoint);
                    } else {
                        ans = Math.min(ans, dist[currentPoint.x][currentPoint.y]);
                    }
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
