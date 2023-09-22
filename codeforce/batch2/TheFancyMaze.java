package SCPT.codeforce.batch2;

import java.util.*;

public class TheFancyMaze {
    // Maze
    static Scanner ip = new Scanner(System.in);
    static int n, m, k;
    static char[][] array = new char[505][505];
    static boolean[][] visited = new boolean[505][505];
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        n = ip.nextInt();
        m = ip.nextInt();
        k = ip.nextInt();

        for (int i = 1; i <= n; i++) {
            String s = " " + ip.next();
            for (int j = 1; j <= m; j++) {
                array[i][j] = s.charAt(j);
                visited[i][j] = false;
            }
        }
        List<Point> points = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (visited[i][j] == false && array[i][j] == '.') {
                    points = bfs(i, j);
                }
            }
        }

        points.sort((p1, p2) -> {
            if (p1.dist < p2.dist) {
                return 1;
            }
            return -1;
        });

        for (int index = 0; index < k; index++) {
            array[points.get(index).x][points.get(index).y] = 'X';
        }

//        for(Point p : points){
//            System.out.println(p.x + " " + p.y);
//        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    static List<Point> bfs(int s1, int s2) {
        visited[s1][s2] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(s1, s2, 0));
        List<Point> points = new ArrayList<>();

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            points.add(currentPoint);

            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i], currentPoint.dist + 1);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && array[newPoint.x][newPoint.y] == '.') {
                    visited[newPoint.x][newPoint.y] = true;
                    queue.add(newPoint);
                }
            }
        }
        return points;
    }

    static boolean isValid(Point p) {
        if (p.x < 1 || p.x > n || p.y < 1 || p.y > m) {
            return false;
        }
        return true;
    }

    static class Point {
        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
