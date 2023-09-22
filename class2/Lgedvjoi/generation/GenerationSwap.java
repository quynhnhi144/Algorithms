package SCPT.class2.Learning.generation;

import java.util.Scanner;

public class GenerationSwap {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int a[] = new int[10];
    static int hv[] = new int[10];
    static boolean used[] = new boolean[10];

    public static void main(String[] args) {
        n = Integer.parseInt(ip.nextLine());
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        gen(1, a);
    }

    static void gen(int index, int[] a) {
        if (index > n) {
            for (int i = 1; i <= n; i++) {
                System.out.print(hv[i]);
            }
            System.out.println();
        } else {
            for (int val = 1; val <= n; val++) {
                if (used[val]) continue;
                hv[index] = a[val - 1];
                used[val] = true;
                gen(index + 1, a);
                used[val] = false;
            }
        }
    }
}
