package SCPT.class2.Learning.dijkstra;

import java.util.*;

public class ShortestPathOnMatrix4 {
    static Scanner ip = new Scanner(System.in);
    static int n, m;
    static char[][] array = new char[105][105];
    static boolean[][][] visited = new boolean[105][105][4];
    static long[][][] dist = new long[105][105][4];
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static final int HP = 3;

    static long oo = (long) 1e18;

    static int s1, s2, d1, d2;
    static long ans = 0;

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
                for (int hp = 1; hp <= HP; hp++) {
                    visited[i][j][hp] = false;
                    dist[i][j][hp] = oo;
                }
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
        if (dist[d1][d2][1] == oo && dist[d1][d2][2] == oo && dist[d1][d2][3] == oo) {
            System.out.println(-1);
            return;
        }
        // for (int i = 1; i <= n; i++) {
        // for (int j = 1; j <= m; j++) {
        // System.out.print(dist[i][j] + " ");
        // }
        // System.out.println();
        // }

        ans = Math.min(Math.min(dist[d1][d2][1], dist[d1][d2][2]), dist[d1][d2][3]);

        System.out.println(ans);
    }

    static void bfs(int o1, int o2) {
        visited[o1][o2][3] = true;
        dist[o1][o2][3] = 0;

        Queue<Point> queue = new PriorityQueue<Point>((p1, p2) -> {
            if (p1.d > p2.d) {
                return 1;
            }
            return -1;
        });

        queue.add(new Point(o1, o2, 0, HP));

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            visited[currentPoint.x][currentPoint.y][currentPoint.hp] = true;

            for (int i = 0; i <= 3; i++) {
                int x = currentPoint.x + dx[i];
                int y = currentPoint.y + dy[i];
                int newPointDist = currentPoint.d + 1;
                int newPointHp = currentPoint.hp;
                if (array[x][y] == '+') {
                    newPointHp = currentPoint.hp - 1;
                }
                Point newPoint = new Point(x, y, newPointDist, newPointHp);

                if (isValid(newPoint) && visited[newPoint.x][newPoint.y][newPoint.hp] == false && dist[newPoint.x][newPoint.y][newPointHp] > newPointDist && newPointHp > 0) {
                    dist[newPoint.x][newPoint.y][newPoint.hp] = newPointDist;
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
        int hp;

        public Point(int x, int y, int d, int hp) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.hp = hp;
        }
    }
}
