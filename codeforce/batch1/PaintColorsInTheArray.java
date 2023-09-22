package SCPT.codeforce.batch1;

import java.util.*;

public class PaintColorsInTheArray {
    static Scanner ip = new Scanner(System.in);
    static int t;
    static int n;
    static int[] array = new int[55];

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        t = ip.nextInt();

        while (t-- > 0) {
            n = ip.nextInt();
            for (int i = 1; i <= n; i++) {
                array[i] = ip.nextInt();
            }
            Arrays.sort(array, 1, n + 1);
//            for(int i = 1; i <= n; i++){
//                System.out.print(array[i] + " ");
//            }
//            System.out.println();
            findMaxCost(n, array);
        }
    }

    static void findMaxCost(int n, int[] array) {
        int maxCostEachColor = 0;
        for (int i = 1; i <= n / 2; i++) {
            maxCostEachColor += array[n - i + 1] - array[i];
        }
        System.out.println(maxCostEachColor);
    }
}
