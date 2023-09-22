package SCPT.class2;

import java.util.*;

public class Permutations {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int k;
    static int a[] = new int[10];
    static int hv[] = new int[10];
    static boolean used[] = new boolean[10];
    static String[] strings = new String[10];
    static int ans = 1000000000;

    public static void main(String[] args) {
        n = ip.nextInt();
        k = ip.nextInt();
        for (int i = 1; i <= n; i++) {
            strings[i] = ip.next();
            strings[i] = strings[i] + " ";
        }
        gen(1, k);
        System.out.println(ans);

    }

    static void gen(int index, int k) {

        for (int val = 1; val <= k; val++) {
            if (used[val] == false) {
                hv[index] = val;
                used[val] = true;
                if (index == k) {
                    outputGen();
                } else {
                    gen(index + 1, k);

                }
                used[val] = false;
            }
        }
    }

    static void outputGen() {
        for (int i = 1; i <= k; i++) {
            System.out.println(hv[i]);
        }
        System.out.println();

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            // 1 string mới có 1 số tại  1 hoán vị
            String string = strings[i];
            char[] tmp = new char[10];

            for (int j = 1; j <= k; j++) {
                tmp[j] = string.charAt(hv[j] - 1);

            }
            maxValue = Math.max(maxValue, toInt(tmp));
            minValue = Math.min(minValue, toInt(tmp));
        }
        ans = Math.min(ans, maxValue - minValue);
    }

    static int toInt(char[] cArr) {
        int res = 0;
        for (int i = 1; i <= k; i++) {
            res = res * 10 + cArr[i] - '0';
        }
        return res;
    }

}
