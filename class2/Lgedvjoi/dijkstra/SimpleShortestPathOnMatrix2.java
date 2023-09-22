package SCPT.class2.Learning.dijkstra;

import static java.lang.Integer.parseInt;

import java.util.*;
import java.io.*;

public class SimpleShortestPathOnMatrix2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Scanner ip = new Scanner(System.in);
    static int n, m;
    static long oo = (long) 1e18;
    static int[][] a = new int[105][105];
    static long[][] dist = new long[105][105];
    static boolean[][] visited = new boolean[105][105];
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine());
//        n = parseInt(st.nextToken());
//        m = parseInt(st.nextToken());

        n= ip.nextInt();
        m = ip.nextInt();

        // doc tung gia tri tren 1 line
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
//                a[i][j] = parseInt(st.nextToken());
                a[i][j] = ip.nextInt();
            }
        }
        initializeData();
        bfs();
        System.out.println(dist[n][m]);
    }

    static void initializeData() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dist[i][j] = oo;
                visited[i][j] = false;
            }
        }
    }

    static void bfs() {
        // danh dau diem nguon
        visited[1][1] = true;
        dist[1][1] = a[1][1];

        // day vao queue
        Queue<Point> queue = new PriorityQueue<>((p1, p2) -> {
            if (p1.dist > p2.dist) {
                return 1;
            }
            return -1;
        });
        queue.add(new Point(1, 1, a[1][1]));

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            visited[currentPoint.x][currentPoint.y] = true;

            // duyet cac phan tu ke cua currentPoint(4 diem: tren, duoi, trai, phai)
            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i], currentPoint.dist + a[currentPoint.x + dx[i]][currentPoint.y + dy[i]]);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && newPoint.dist < dist[newPoint.x][newPoint.y]) {
                    dist[newPoint.x][newPoint.y] = newPoint.dist;
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
        long dist;

        public Point(int x, int y, long dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
