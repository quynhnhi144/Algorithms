package SCPT.class2.Learning.generation;

import java.util.*;

public class GenerationBit {
    static int[] a = new int[12 + 1];
    static int n;
    static boolean isFinal = false;

    static Scanner ip = new Scanner(System.in);

    public static void main(String[] args) {
        n = Integer.parseInt(ip.nextLine());
        initilizeFirstElement();
        while (!isFinal) {
            // print elements
            for (int i = 1 ; i <= n; i++) {
                System.out.print(a[i]);
            }
            System.out.println();

            generationBit();
        }
    }

    static void initilizeFirstElement() {
        for (int i = 1; i <= n; i++) {
            a[i] = 0;
        }
    }

    static void generationBit() {
        // Start from last bit and find the first bit 0
        int i = n;
        while (i >= 1 && a[i] == 1) {
            a[i] = 0;
            i--;
        }
        // Clarify there is 0 first or not
        if (i == 0) {
            isFinal = true;
        } else {
            a[i] = 1;
        }
    }
}
