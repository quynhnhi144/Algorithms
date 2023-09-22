package SCPT.class2.pretest;

import java.util.*;

public class NumberOfIsolatedArea {
    static Scanner ip = new Scanner(System.in);
    static int n, m;
    static int[][] array = new int[105][105];
    static boolean[][] visited = new boolean[105][105];
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static boolean isSide = false;

    public static void main(String[] args) {
        n = ip.nextInt();
        m = ip.nextInt();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                array[i][j] = ip.nextInt();
                visited[i][j] = false;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i == 1 || i == m || j == 1 || j == n) && visited[i][j] == false && array[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        int count = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (visited[i][j] == false && array[i][j] == 0) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static void bfs(int s1, int s2) {
        Point o = new Point(s1, s2);
        visited[s1][s2] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.add(o);

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i]);

                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && array[newPoint.x][newPoint.y] == 0) {
                    visited[newPoint.x][newPoint.y] = true;
                    queue.add(newPoint);
                }
            }
        }
    }

    static boolean isValid(Point p) {
        if (p.x < 1 || p.x > m || p.y < 1 || p.y > n) {
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
