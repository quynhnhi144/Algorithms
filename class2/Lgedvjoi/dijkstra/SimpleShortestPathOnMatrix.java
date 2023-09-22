//Simple Shortest Path On Matrix
package SCPT.class2.Learning.dijkstra;

import java.util.*;

public class SimpleShortestPathOnMatrix {
    static Scanner ip = new Scanner(System.in);
    static int n, m;
    static char[][] a = new char[105][105];
    static int s1, s2, d1, d2;
    static int oo = 100000000;
    static int[][] dist = new int[105][105];
    static boolean[][] visited = new boolean[105][105];
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) {
        n = ip.nextInt();
        m = ip.nextInt();
        for (int i = 1; i <= n; i++) {
            String tmpString = ip.next();
            tmpString = " " + tmpString;
            for (int j = 1; j <= m; j++) {
                a[i][j] = tmpString.charAt(j);
                if (a[i][j] == 'S') {
                    s1 = i;
                    s2 = j;
                }
                if (a[i][j] == 'D') {
                    d1 = i;
                    d2 = j;
                }
            }
        }
        bfs(s1, s2);
        if(dist[d1][d2] == oo){
            System.out.println(-1);
            return;
        }
        System.out.println(dist[d1][d2]);
    }

    static boolean isValid(Point point) {
        if (point.x <= 0 || point.x > n || point.y <= 0 || point.y > m) {
            return false;
        }
        return true;
    }

    static void bfs(int s1, int s2) {
        // Khoi tao gia tri ban dau cho mang D
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dist[i][j] = oo;
            }
        }

        visited[s1][s2] = true;
        dist[s1][s2] = 0;


        Queue<Point> queue = new LinkedList();
        queue.add(new Point(s1, s2));
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(current.x + dx[i], current.y + dy[i]);
                // dieu kien loang bfs
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && a[newPoint.x][newPoint.y] != '+') {
                    visited[newPoint.x][newPoint.y] = true;
                    // luu khoang cach
                    dist[newPoint.x][newPoint.y] = dist[current.x][current.y] + 1;
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
