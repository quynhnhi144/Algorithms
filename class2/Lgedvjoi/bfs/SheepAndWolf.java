package SCPT.class2.Learning.bfs;

import java.util.*;

public class SheepAndWolf {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int m;
    static char[][] a = new char[255][255];
    static boolean[][] visited = new boolean[255][255];
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int numberOfSheepInAField;
    static int numberOfWolfInAField;
    static boolean isSide = false;

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        n = ip.nextInt();
        m = ip.nextInt();
        for (int i = 1; i <= n; i++) {
            String s = ip.next();
            s = " " + s;
            for (int j = 1; j <= m; j++) {
                a[i][j] = s.charAt(j);
                visited[i][j] = false;
            }
        }
        int numberOfWolf = 0;
        int numberOfSheep = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (visited[i][j] == false && a[i][j] != '#') {
                    numberOfSheepInAField = 0;
                    numberOfWolfInAField = 0;
                    isSide = false;

                    bfs(i, j);

                    if (isSide) {
                        numberOfSheep += numberOfSheepInAField;
                        numberOfWolf += numberOfWolfInAField;
                    } else if (numberOfSheepInAField > numberOfWolfInAField) {
                        numberOfSheep += numberOfSheepInAField;
                    } else {
                        numberOfWolf += numberOfWolfInAField;
                    }
                }
            }
        }
        System.out.println(numberOfSheep + " " + numberOfWolf);
    }

    static void bfs(int s1, int s2) {
        visited[s1][s2] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(s1, s2));

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            // duyet dem cuu dem soi
            if (a[currentPoint.x][currentPoint.y] == 'k') {
                numberOfSheepInAField++;
            }
            if (a[currentPoint.x][currentPoint.y] == 'v') {
                numberOfWolfInAField++;
            }

            // duyet dinh ke voi curPoint
            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i]);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && a[newPoint.x][newPoint.y] != '#') {
                    visited[newPoint.x][newPoint.y] = true;
                    queue.add(newPoint);
                }
                if (!isValid(newPoint)) {
                    isSide = true;
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
