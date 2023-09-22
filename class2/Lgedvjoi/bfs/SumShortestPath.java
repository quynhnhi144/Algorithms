//Sum Shortest Path
package SCPT.class2.Learning.bfs;

import java.util.*;

public class SumShortestPath {
    static Scanner ip = new Scanner(System.in);
    static int n, m;
    static char[][] a = new char[105][105];
    static int s1, s2, d1, d2;
    static int oo = 100000000;
    static int[][] dist = new int[105][105];
    static boolean[][] visited = new boolean[105][105];
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[][] minPath = new int[105][105];

    public static void main(String[] args) {
        n = ip.nextInt();
        m = ip.nextInt();
        for (int i = 1; i <= n; i++) {
            String tmpString = ip.next();
            tmpString = " " + tmpString;
            for (int j = 1; j <= m; j++) {
                a[i][j] = tmpString.charAt(j);
            }
        }

        // bfs cho tat ca cac dinh tu 1 ->9
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] != '+' && a[i][j] != '-') {
                    bfs(i, j);
                    //co mang dist
                    // lay cac gia tri tai Dist lap vao mang minPath
                    for (int x = 1; x <= n; x++) {
                        for (int y = 1; y <= m; y++) {
                            // i, j: diem nguon
                            // x, y: diem dich bat ky
                            if (a[x][y] != '+' && a[x][y] != '-') {
                                if (dist[x][y] != oo) {
                                    // minPath thu nguon, dich
                                    minPath[a[i][j] - '0'][a[x][y] - '0'] = dist[x][y];
                                }
                            }
                        }
                    }
                }
            }
        }
        int sum = 0;
        // tinh tong doan duong ngan nhat giua moi cap diem
        for (int i = 1; i <= 9; i++) {
            for (int j = i + 1; j <= 9; j++) {
                sum += minPath[i][j];
            }
        }
        System.out.println(sum);
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
                visited[i][j] = false;
            }
        }

        visited[s1][s2] = true;
        dist[s1][s2] = 1;


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
