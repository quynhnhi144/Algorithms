package SCPT.class2.Learning.bfs;

import java.util.*;

public class EruptingVolcano {
    static Scanner ip = new Scanner(System.in);
    static int n, m;
    static int[][] array = new int[105][105];
    static boolean[][] visited = new boolean[105][105];
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int ans = 0;

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

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (array[i][j] < 0 && visited[i][j] == false) {
                   ans += bfs(new Point(i, j));
                }
            }
        }

        System.out.println("count: " + ans);
    }

    static int bfs(Point p) {
        int count = 1;
        visited[p.x][p.y] = true;
        Queue<Point> queue = new LinkedList();
        queue.add(p);

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i]);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && Math.abs(array[newPoint.x][newPoint.y]) <= Math.abs(array[currentPoint.x][currentPoint.y])) {
                    visited[newPoint.x][newPoint.y] = true;
                    queue.add(newPoint);
                    count++;
                }
            }
        }
        return count;
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

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
