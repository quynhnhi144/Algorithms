package SCPT.class2batch3.codepro;

import java.util.*;

public class PictureRecognition {
    static Scanner ip = new Scanner(System.in);
    static int[][] array = new int[15][15];
    static int n;
    static int ans = 0;
    // status of number of colors are painted over or not
    static boolean[] isPaidOver = new boolean[10];

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        n = Integer.parseInt(ip.nextLine());
        for (int i = 1; i <= n; i++) {
            String s = " " + ip.nextLine();
            for (int j = 1; j <= n; j++) {
                array[i][j] = s.charAt(j) - '0';
            }
        }

        /**
         * Create the array for status of colors to check them painted other color or not
         * If the color doesn't belong on the array -> True
         * If the color painted over other color -> True
         * Count the amount of colors have status FALSE
         * */

        for (int i = 1; i <= 9; i++) {
            isPaidOver[i] = false;
        }

        for (int i = 1; i <= 9; i++) {
            int[] scope = findMinMaxColumnRow(i);
            // if having any colors do belong gave colors -> Change status to true
            if (scope[1] == n && scope[2] == 1 && scope[3] == n && scope[4] == 1) {
                isPaidOver[i] = true;
                continue;
            }
            iterateScope(scope, i);
        }

        for(int i = 1; i <= 9; i++){
            if(!isPaidOver[i]){
                ans++;
            }
        }

        System.out.println(ans);
    }

    static int[] findMinMaxColumnRow(int color) {
        int minRow = n;
        int maxRow = 1;
        int minColumn = n;
        int maxColumn = 1;
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (array[x][y] == color) {
                    minRow = Math.min(minRow, x);
                    maxRow = Math.max(maxRow, x);
                    minColumn = Math.min(minColumn, y);
                    maxColumn = Math.max(maxColumn, y);
                }
            }
        }
        return new int[]{0, minRow, maxRow, minColumn, maxColumn};
    }

    static void iterateScope(int[] scope, int color) {
        for (int i = scope[1]; i <= scope[2]; i++) {
            for (int j = scope[3]; j <= scope[4]; j++) {
                // if having any colors painted over the iterated color -> Change status them to true
                if (array[i][j] != color) {
                   isPaidOver[array[i][j]] = true;
                }
            }
        }
    }
}
