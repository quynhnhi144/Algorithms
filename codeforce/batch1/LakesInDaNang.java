package SCPT.codeforce.batch1;

import java.util.*;

public class LakesInDaNang {
    static Scanner ip = new Scanner(System.in);
    static int n, m, k;
    static char[][] array = new char[55][55];
    static boolean[][] visited = new boolean[55][55];
    static int ans = 0;
    static List<ListWater> listWaters = new ArrayList<>();

    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static boolean isSide = false;

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

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (visited[i][j] == false && array[i][j] == '.') {
                    isSide = false;
                    List<Point> points = bfs(i, j);
                    if (!isSide) {
                        listWaters.add(new ListWater(points.size(), points));
                    }
                }
            }
        }

        listWaters.sort((l1, l2) -> {
            if (l1.numberOfCham > l2.numberOfCham) {
                return 1;
            } else if ((l1.numberOfCham == l2.numberOfCham) && (l1.points.get(0).x > l2.points.get(0).x)) {
                return 1;
            } else if ((l1.numberOfCham == l2.numberOfCham) && (l1.points.get(0).x == l2.points.get(0).x)
                    && ((l1.points.get(0).y > l2.points.get(0).y))) {
                return 1;
            }
            return -1;
        });

//        for (ListWater listWater : listWaters) {
//            System.out.print(listWater.numberOfCham + ": ");
//            for (Point point : listWater.points) {
//                System.out.print(point.x + " " + point.y);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }

        int numberOfWater = listWaters.size();


        for (ListWater listWater : listWaters) {
            if (numberOfWater > k) {
                for (Point point : listWater.points) {
                    array[point.x][point.y] = '*';
                }
                ans += listWater.numberOfCham;
                numberOfWater--;
            } else {
                break;
            }
        }
        System.out.println(ans);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

    }

    static List<Point> bfs(int o1, int o2) {
        List<Point> points = new ArrayList<>();
        visited[o1][o2] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(o1, o2));

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            points.add(currentPoint);
            if ((currentPoint.x == 1 || currentPoint.x == n || currentPoint.y == 1 || currentPoint.y == m)) {
                isSide = true;
            }
            for (int i = 0; i <= 3; i++) {
                Point newPoint = new Point(currentPoint.x + dx[i], currentPoint.y + dy[i]);
                if (isValid(newPoint) && visited[newPoint.x][newPoint.y] == false && array[newPoint.x][newPoint.y] == '.') {
                    visited[newPoint.x][newPoint.y] = true;
                    queue.add(newPoint);
                }

            }
        }
        return points;
    }

    static boolean isValid(Point point) {
        if (point.x < 1 || point.x > n || point.y < 1 || point.y > m) {
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

    static class ListWater {
        int numberOfCham;
        List<Point> points;

        ListWater(int numberOfCham, List<Point> points) {
            this.numberOfCham = numberOfCham;
            this.points = points;
        }
    }
}
