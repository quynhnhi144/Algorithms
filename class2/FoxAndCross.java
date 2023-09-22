package SCPT.class2;

import java.util.*;

public class FoxAndCross {
    static Scanner ip = new Scanner(System.in);
    static char[][] cArr = new char[100 + 5][100 + 5];
    static int n;

    public static void main(String[] args) {

        n = Integer.parseInt(ip.nextLine());
        if (solve() > 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    static int solve() {
        for (int i = 0; i < n; i++) {
            String s = ip.nextLine();
            for (int j = 0; j < n; j++) {
                cArr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n - 2; i++) {
            if (cArr[0][0] == '#') {
                return -1;
            }
            for (int j = 0; j < n - 1; j++) {
                if (cArr[i][j + 1] == '#' && cArr[i + 1][j + 1] == '#' && cArr[i + 2][j + 1] == '#' && cArr[i + 1][j] == '#' && cArr[i + 1][j + 2] == '#') {
                    cArr[i][j + 1] = '.';
                    cArr[i + 1][j + 1] = '.';
                    cArr[i + 2][j + 1] = '.';
                    cArr[i + 1][j] = '.';
                    cArr[i + 1][j + 2] = '.';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cArr[i][j] == '#') {
                    return -1;
                }
            }
        }
        return 1;
    }
}
