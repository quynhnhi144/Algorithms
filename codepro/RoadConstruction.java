package SCPT.class2batch3.codepro;

import java.util.*;

public class RoadConstruction {
    Scanner ip = new Scanner(System.in);
    int[][] array = new int[15][15];
    int n;
    int[][] dist = new int[15][15];
    boolean[][] visited = new boolean[15][15];
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{-1, 1, 0, 0};

    int oo = (int)1e9;

    int d1, d2;

    public static void main(String[] args) {

        RoadConstruction m = new RoadConstruction();
        m.solve();
    }

    void solve() {
        n = Integer.parseInt(ip.nextLine());
        for (int i = 1; i <= n; i++) {
            String s = " " + ip.nextLine();
            for (int j = 1; j <= n; j++) {
                array[i][j] = s.charAt(j) - '0';
                dist[i][j] = oo;
                visited[i][j] = false;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != 1 && j != 1 && array[i][j] == 0) {
                    d1 = i;
                    d2 = j;
                }
            }
        }
        bfs(1, 1);
        System.out.println(dist[d1][d2]);

    }

    void bfs(int o1, int o2) {
        visited[o1][o2] = true;

        dist[o1][o2] = 0;

        Queue<Point> queue = new PriorityQueue<Point>((p1, p2) -> {
            if (p1.d > p2.d) {
                return 1;
            }
            return -1;
        });
        queue.add(new Point(o1, o2, 0));

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            visited[currentPoint.x][currentPoint.y] = true;
            for (int i = 0; i <= 3; i++) {
                int x = currentPoint.x + dx[i];
                int y = currentPoint.y + dy[i];
                int newPointDist = currentPoint.d + array[x][y];
                Point newPoint = new Point(x, y, newPointDist);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && dist[newPoint.x][newPoint.y] > newPointDist) {
                    dist[newPoint.x][newPoint.y] = newPointDist;
                    queue.add(newPoint);
                }
            }
        }
    }

    boolean isValid(Point point) {
        if (point.x <= 0 || point.x > n || point.y <= 0 || point.y > n) {
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
