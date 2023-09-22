package SCPT.class2batch3.codepro;

import java.util.*;

public class Virus {
    private static int n;
    private static int m;
    private static int[] a = new int[20000 + 10]; // original array
    private static int[] b = new int[10 + 10]; // virus array
    private static int[] c = new int[10 + 10];
    private static int sol;

    public static void main(String[] args) {
        Virus v = new Virus();
        v.inputData();
        solve();
        v.outputData();
    }

    public void inputData() {
        Scanner ip = new Scanner(System.in);
        n = ip.nextInt();
        m = ip.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = ip.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = ip.nextInt();
        }
        ip.close();
    }

    public void outputData() {
        System.out.println(sol);
    }

    public static void solve() {
        Arrays.sort(b, 0, m);
        for (int i = 0; i <= n - m; i++) {
            if (findVirus(i) == 1) {
                sol++;
            }
        }
    }

    public static int findVirus(int startIndex) {
        for (int i = 0; i < m; i++) {
            c[i] = a[startIndex + i];
        }
        Arrays.sort(c, 0, m);
        int distance = c[0] - b[0];
        for (int j = 1; j < m; j++) {
            if (c[j] - b[j] != distance) {
                return 0;
            }
        }
        return 1;
    }

}
