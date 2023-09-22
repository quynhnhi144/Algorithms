package SCPT.class2.batch3;

import java.util.*;

public class Decode {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int[] array = new int[105];
    static int[] originalArray = new int[105];

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        n = ip.nextInt();
        for (int i = 0; i < n; i++) {
            array[i] = ip.nextInt();
        }

        encode(array, n);

        for(int i = 0; i < n; i++){
            System.out.print(originalArray[i] + " ");
        }
    }

    static void encode(int[] arr, int n) {
        boolean[] mask = new boolean[105];
        for (int i = 0; i < n; i++) {
            mask[i] = false;
        }
        boolean cont = true;
        int idx = n / 2;
        int index = 0;
        while (cont) {
            if (!mask[idx]) {
                originalArray[idx] = arr[index];
                index++;
                mask[idx] = true;
                continue;
            }

            idx *= 2;
            idx %= n;

            for (int i = 0; i < n; ++i) {
                if (mask[idx]) {
                    ++idx;
                    idx %= n;
                } else {
                    cont = true;
                    break;
                }
                cont = false;
            }
        }
    }
}
