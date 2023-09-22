// Slick
package SCPT.class2.Learning.bfs;

import java.util.*;

public class Slick {
    static Scanner ip = new Scanner(System.in);
    static int n, m;
    static int[][] a = new int[255][255];
    static boolean[][] visited = new boolean[255][255];
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] D = new int[100005];

    public static void main(String[] args) {
        n = ip.nextInt();
        m = ip.nextInt();
        while (n > 0 && m > 0) {
            //input matrix
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    a[i][j] = ip.nextInt();
                    visited[i][j] = false;
                }
            }
            for (int i = 1; i <= n * m; i++) {
                D[i] = 0;
            }
            int count = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (visited[i][j] == false && a[i][j] == 1) {
                        // phat hien 1 thanh phan lien thong moi lien ket voi o(vi tri i,j)
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);

            //in
            for (int i = 1; i <= n * m; i++) {
                if (D[i] > 0) {
                    System.out.println(i + " " + D[i]);
                }
            }

            n = ip.nextInt();
            m = ip.nextInt();
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
        // tao queue
        Queue<Point> queue = new LinkedList();
        queue.add(new Point(s1, s2));
        int size = 1;
        // duyet queue
        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            // duyet dinh ke voi currentPoint(trên, dưới, trái, phải)
            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i]);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && a[newPoint.x][newPoint.y] == 1) {
                    visited[newPoint.x][newPoint.y] = true;
                    size++;
                    queue.add(newPoint);
                }
            }
        }
        D[size] += 1;
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
