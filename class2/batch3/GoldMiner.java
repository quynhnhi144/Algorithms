package SCPT.class2.batch3;

import java.util.*;

public class GoldMiner {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int m;
    static char[][] array = new char[55][55];
    static boolean[][] visited = new boolean[55][55];


    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        n = ip.nextInt();
        m = ip.nextInt();
        int demGold = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                String s = " " + ip.next();
                array[i][j] = s.charAt(j);
                if (array[i][j] == 'G') {
                    demGold++;
                }
            }
        }
    }

    static void bfs(Point p) {
        visited[p.x][p.y] = true;

        Queue<Point> queue = new LinkedList();
        queue.add(p);
        int sumG = 0;

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            int x = currentPoint.x;
            int y = currentPoint.y;
            char value = array[x][y];
            if (value >= '1' && value <= '5') {
                int soLuong = (2 * (value - '0') + 1) / 2;
                int minR = x - soLuong;
                int maxR = x + soLuong;
                int minCol = y - soLuong;
                int maxCol = y + soLuong;
                for (int r = minR; r <= maxR; r++) {
                    for (int c = minCol; c <= maxCol; c++) {
                        Point newPoint = new Point(r, c);
                        if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false) {
                            visited[r][c] = true;
                            if (array[r][c] == 'G') {
                                sumG++;
                            }
                            if (array[r][c] >= '1' && array[r][c] <= '5') {
                                queue.add(newPoint);
                            }
                        }

                    }
                }

                for(int r2 = minR - 1; r2 <= maxR + 1; r2++){
                    for(int c2 = minCol - 1; c2 <= maxCol + 1; maxCol++){
                        Point newPoint2 = new Point(r2, c2);
                        if (isValid(newPoint2) && visited[newPoint2.x][newPoint2.y] == false) {
                            visited[r2][c2] = true;
                            if (array[r2][c2] == 'G') {
                                sumG++;
                            }
                            if (array[r2][c2] >= '1' && array[r2][c2] <= '5') {
                                queue.add(newPoint2);
                            }
                        }
                    }
                }
            }
        }
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

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
