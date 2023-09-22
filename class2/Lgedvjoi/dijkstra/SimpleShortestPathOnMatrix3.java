package SCPT.class2.Learning.dijkstra;

import java.util.*;

public class SimpleShortestPathOnMatrix3 {
    static Scanner ip = new Scanner(System.in);
    static int n, m;
    static char[][] array = new char[105][105];
    static boolean[][] visited = new boolean[105][105];
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static long[][] dist = new long[105][105];
    static long oo = (long) 1e18;
    static int s1, s2, d1, d2;

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        n = ip.nextInt();
        m = ip.nextInt();

        for (int i = 1; i <= n; i++) {
            String s = " " + ip.next();
            for (int j = 1; j <= m; j++) {
                array[i][j] = s.charAt(j);
                visited[i][j] = false;
                dist[i][j] = oo;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (array[i][j] == 'S') {
                    s1 = i;
                    s2 = j;
                }
                if (array[i][j] == 'D') {
                    d1 = i;
                    d2 = j;
                }
            }
        }

        bfs(s1, s2);
        System.out.println(dist[d1][d2]);
    }

    static void bfs(int o1, int o2) {
        visited[o1][o2] = true;
//        dist[o1][o2] = 0;

        Queue<Point> queue = new PriorityQueue<>((p1,p2)->{
            if(p1.d > p2.d){
                return 1;
            }
            return -1;
        });
        queue.add(new Point(o1, o2, 0));

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            visited[currentPoint.x][currentPoint.y] = true;

            for (int i = 0; i <= 3; i++) {
                int x = currentPoint.x;
                int y = currentPoint.y;
                int newPointDist = currentPoint.d + 1;
                if (array[x][y] == '+') {
                    newPointDist = currentPoint.d + 4;
                }
                // Cập nhật dist cho newPoint
                Point newPoint = new Point(x + dx[i], y + dy[i], newPointDist);

                /**
                 * Kiem tra xem newPoint đã duyệt và cập nhật lại dist hay chưa
                 * Những point chưa được duyệt và cập nhật thì dist[x][y] = oo
                 */
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && dist[newPoint.x][newPoint.y] > newPointDist) {
                    dist[newPoint.x][newPoint.y] = newPointDist;
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
        int d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
