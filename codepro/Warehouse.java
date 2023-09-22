package SCPT.class2batch3.codepro;

import java.util.*;

public class Warehouse {
    Scanner ip = new Scanner(System.in);
    int n, m;
    int[][] array = new int[105][105];
    boolean[] visited = new boolean[105];
    int[] dist = new int[105];
    int oo = (int) 1e9;

    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        w.solve();
    }

    void solve() {
        // n : the number of factories
        n = ip.nextInt();

        // m: the number of lines
        m = ip.nextInt();

        for (int i = 1; i <= m; i++) {
            int u = ip.nextInt();
            int v = ip.nextInt();
            array[u][v] = ip.nextInt();
            array[v][u] = array[u][v];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int[] result = bfs(i);
            ans = Math.min(ans, result[n]);
        }
        System.out.println(ans);

    }

    int[] bfs(int s) {
        visited[s] = true;

        for (int i = 1; i <= n; i++) {
            visited[i] = false;
            dist[i] = oo;
        }

        dist[s] = 0;

        Queue<Point> queue = new PriorityQueue<>((p1, p2) -> {
            if (p1.d > p2.d) {
                return 1;
            }
            return -1;
        });
        queue.add(new Point(s, 0));

        while (!queue.isEmpty()) {
            Point currentEdge = queue.poll();
            visited[currentEdge.edge] = true;
            for (int v = 1; v <= n; v++) {
                Point newEdge = new Point(v, currentEdge.d + array[currentEdge.edge][v]);
                if (s != v && array[currentEdge.edge][v] != 0 && visited[v] == false && dist[v] > newEdge.d) {
                    dist[newEdge.edge] = newEdge.d;
                    queue.add(newEdge);
                }
            }
        }

        Arrays.sort(dist, 1, n + 1);
        return dist;
    }

    static class Point {
        int edge;
        int d;

        public Point(int edge, int d) {
            this.edge = edge;
            this.d = d;
        }
    }
}
