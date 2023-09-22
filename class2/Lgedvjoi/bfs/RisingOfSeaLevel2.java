//Rising of sear level2
package SCPT.class2.Learning.bfs;

import java.util.*;

public class RisingOfSeaLevel2 {
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
        int count = 0;
        int docao = 0;
        while(docao <= 1000){
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (visited[i][j] == false && a[i][j] > docao) {
                        bfs(i, j, docao);
                        count++;
                    }
                }
            }

            for(int h = 1; h <= n; h++){
                for(int l = 1; l <= m; l++){
                    visited[h][l] = false;
                }
            }

            if(count >= 2){
                System.out.println(docao);
                break;
            }
            count = 0;
            docao++;
        }
        if(count == 0){
            System.out.println(-1 + " ");
        }
    }

    static void bfs(int x, int y, int level) {
        visited[x][y] = true;
        Queue<Point> queue = new LinkedList();
        queue.add(new Point(x, y));

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
