package SCPT.class2.batch4;

import java.util.*;

public class GraduationExhibitionLite {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int m;
    static int[] v = new int[1000005];
    static int[] a = new int[1000005];
    static int[] b = new int[1000005];

    static int[][] array = new int[1000005][10];

    static boolean[] used = new boolean[1000005];
    static int[] hv = new int[1000005];
    static int ans = Integer.MIN_VALUE;
    static int count = 1;

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        n = ip.nextInt();
        m = ip.nextInt();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= 3; j++) {
                array[i][j] = ip.nextInt();
            }
        }

        for (int i = 1; i <= m; i++) {
            v[i] = array[i][1];
            a[i] = array[i][2];
            b[i] = array[i][3];
        }
        gen(1);
        System.out.println(ans + " " + count);
    }

    static void gen(int index) {
        for (int value = 1; value <= n; value++) {
            if (used[value]) {
                continue;
            }
            hv[index] = value;
            used[value] = true;
            if (index == n) {
                output();
            } else {
                gen(index + 1);
            }
            used[value] = false;
        }
    }

    static void output() {
        int indexA = 0;
        int indexB = 0;
        int sumScore = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i] == hv[j]) {
                    indexA = j;
                }
                if (b[i] == hv[j]) {
                    indexB = j;
                }
            }

            if (indexA <= indexB && indexA != 0 && indexB != 0) {
                sumScore += v[i];
            }
        }

        if (sumScore == ans) {
            count++;
        } else if (sumScore >= ans) {
            ans = sumScore;
            count = 1;
        }
    }

    static void print(int[] array) {
        for (int i = 1; i <= m; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
