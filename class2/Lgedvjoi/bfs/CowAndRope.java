//Cow and rope
package SCPT.class2.Learning.bfs;

import java.util.*;

public class CowAndRope {
    static Scanner ip = new Scanner(System.in);
    static int n, m;
    static boolean[] visited = new boolean[1005];
    static int[][] a = new int[1005][1005];

    public static void main(String[] args) {
        n = ip.nextInt();
        m = ip.nextInt();
        solve();
    }

    static void solve() {
        int u, v;
        // khoi tao cac canh
        for (int i = 1; i <= m; i++) {
            u = ip.nextInt();
            v = ip.nextInt();
            a[u][v] = 1;
            a[v][u] = 1;
        }

        for (int i = 1; i <= n; i++) {
            visited[i] = false;
        }

        for (int i = 1; i <= n; i++) {
            int count = bfs(1);
            if (count == n) {
                System.out.println(0 + " ");
            }
            if (visited[i] == false) {
                System.out.print(i + " ");
            }
        }
    }

    // Danh dau tat ca nhung dinh co the di tu s
    static int bfs(int s) {
        int count = 1;
        visited[s] = true;

        //Them s vao queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        // Duyet cac dinh trong queue
        while (!queue.isEmpty()) {
            // Lay dinh tiep theo can duyet
            int u = queue.peek();
            queue.poll();

            // Duyet qua cac dinh ke voi u
            for (int v = 1; v <= n; v++) {
                if (a[u][v] == 1 && visited[v] == false) {
                    queue.add(v);
                    visited[v] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
