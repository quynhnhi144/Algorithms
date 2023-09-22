package SCPT.class2.Learning.bfs;

import java.util.*;

public class ProctectFarm {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int m;
    static int[][] a = new int[105][105];
    static boolean[][] visited = new boolean[105][105];
    static int[] dx = new int[]{0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};
    static boolean isTop;

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
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (visited[i][j] == false) {
                    isTop = true;
                    bfs(i, j);

                    if(isTop){
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);

    }

    static void bfs(int s1, int s2) {
        visited[s1][s2] = true;

        Queue<Point> queque = new LinkedList<>();
        queque.add(new Point(s1, s2));

        while (!queque.isEmpty()) {
            Point currentPoint = queque.poll();

            for (int i = 0; i <= 7; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i]);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && a[newPoint.x][newPoint.y] == a[currentPoint.x][currentPoint.y]) {
                    visited[newPoint.x][newPoint.y] = true;
                    queque.add(newPoint);
                }
                if (isValid(newPoint) && a[newPoint.x][newPoint.y] > a[currentPoint.x][currentPoint.y]) {
                    isTop = false;
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

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
