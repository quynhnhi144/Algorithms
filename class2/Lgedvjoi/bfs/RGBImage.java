package SCPT.class2.Learning.bfs;

import java.util.*;

public class RGBImage {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int m;
    static char[][] array = new char[105][105];
    static boolean[][] visited = new boolean[105][105];
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        n = ip.nextInt();
        m = ip.nextInt();
        ip.nextLine();
        List<RGB> rgbs = new ArrayList<>();
        rgbs.add(new RGB('R', 0, 0));
        rgbs.add(new RGB('G', 0, 0));
        rgbs.add(new RGB('B', 0, 0));

        // create the input array
        for (int i = 1; i <= n; i++) {
            String s = " " + ip.nextLine();
            for (int j = 1; j <= m; j++) {
                if (s.charAt(j) == 'R') {
                    rgbs.get(0).numberOfTotalAre += 1;
                } else if (s.charAt(j) == 'G') {
                    rgbs.get(1).numberOfTotalAre += 1;
                } else {
                    rgbs.get(2).numberOfTotalAre += 1;
                }
                array[i][j] = s.charAt(j);
            }
        }

        // create value for visited array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                visited[i][j] = false;
            }
        }

        // bfs to find the blocks
        char[] symbols = new char[]{' ', 'R', 'G', 'B'};
        for (int symbol = 1; symbol < symbols.length; symbol++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (visited[i][j] == false && array[i][j] == symbols[symbol]) {
                        bfs(i, j, symbols[symbol]);
                        rgbs.get(symbol - 1).numberOfBlocks += 1;
                    }
                }
            }
        }

        // compare the number of block and number of total area
        rgbs.sort((o1, o2) -> {
            if (o1.numberOfBlocks < o2.numberOfBlocks) {
                return 1;
            } else if (o1.numberOfBlocks == o2.numberOfBlocks && o1.numberOfTotalAre < o2.numberOfTotalAre) {
                return 1;
            } else if(o1.numberOfBlocks == o2.numberOfBlocks && o1.numberOfTotalAre == o2.numberOfTotalAre && (int)o1.name < (int)o2.name){
                return 1;
            }
            return -1;
        });

//        System.out.println();
//        for (RGB rgb : rgbs) {
//            System.out.println(rgb.name + " " + rgb.numberOfBlocks + " " + rgb.numberOfTotalAre);
//        }

        System.out.println(rgbs.get(0).name);

    }

    static void bfs(int x, int y, char symbol) {
        visited[x][y] = true;
        Queue<Point> points = new LinkedList<>();
        points.add(new Point(x, y));

        while (!points.isEmpty()) {
            Point currentPoint = points.poll();
            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i]);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && array[newPoint.x][newPoint.y] == symbol) {
                    visited[newPoint.x][newPoint.y] = true;
                    points.add(newPoint);
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

    static class RGB {
        char name;
        int numberOfBlocks;
        int numberOfTotalAre;

        public RGB(char name, int numberOfBlocks, int numberOfTotalAre) {
            this.name = name;
            this.numberOfBlocks = numberOfBlocks;
            this.numberOfTotalAre = numberOfTotalAre;
        }
    }
}
