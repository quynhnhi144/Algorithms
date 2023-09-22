package SCPT.class2.Learning.bfs;

import java.util.*;

public class TheHyruleIsLand {
    static Scanner ip = new Scanner(System.in);
    static int r, c, n;
    static char[][] array = new char[105][105];
    static boolean[][] visited = new boolean[105][105];
    static int[][] dist = new int[105][105];
    static int oo = (int) 1e9;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int[][] minPath = new int[105][105];
    static boolean[] used = new boolean[105];
    static int[] hv = new int[105];
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        r = ip.nextInt();
        c = ip.nextInt();
        n = ip.nextInt();

        for (int i = 1; i <= r; i++) {
            String s = " " + ip.next();
            for (int j = 1; j <= c; j++) {
                array[i][j] = s.charAt(j);
                visited[i][j] = false;
                dist[i][j] = oo;
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (array[i][j] != '#' && array[i][j] != '.') {
                    resetData();
                    bfs(i, j);
                }
            }
        }

        // Swap position of elements
        gen(1);
        System.out.println(ans);

    }

    static void resetData() {
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                visited[i][j] = false;
                dist[i][j] = oo;
            }
        }
    }

    static void gen(int index) {
        for (int value = 1; value <= n; value++) {
            if (used[value]) {
                continue;
            }
            hv[index] = value;
            used[value] = true;
            if (index == n) {
                int sum = 0;
                for (int i = 1; i < n; i++) {
                    sum += minPath[hv[i]][hv[i + 1]];
                    if (minPath[hv[i]][hv[i + 1]] == 0) {
                        ans = -1;
                        return;
                    }

                }
                ans = Math.min(ans, sum);
            } else {
                gen(index + 1);

            }
            used[value] = false;
        }
    }

    static void bfs(int o1, int o2) {
        visited[o1][o2] = true;
        dist[o1][o2] = 0;

        Queue<Point> queue = new LinkedList();
        queue.add(new Point(o1, o2));

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i]);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && array[newPoint.x][newPoint.y] != '#') {
                    visited[newPoint.x][newPoint.y] = true;
                    dist[newPoint.x][newPoint.y] = dist[currentPoint.x][currentPoint.y] + 1;
                    queue.add(newPoint);
                }

            }
        }

        // save the distance from start to end points
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (array[i][j] != '#' && array[i][j] != '.') {
                    if (dist[i][j] != oo) {
                        minPath[array[o1][o2] - '0'][array[i][j] - '0'] = dist[i][j];
                    }
                }
            }
        }
    }

    static boolean isValid(Point p) {
        if (p.x < 1 || p.x > r || p.y < 1 || p.y > c) {
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