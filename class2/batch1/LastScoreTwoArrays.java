package SCPT.class2.batch1;

import java.util.*;
import java.util.stream.*;

public class LastScoreTwoArrays {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int[] a = new int[105];
    static int[] b = new int[105];

    public static void main(String[] args) {
        n = ip.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = ip.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = ip.nextInt();
        }
        solve();
    }

    /**
     * Requirement: Remove an element of array A and an element of array B
     * -> Then making a comparetion between 2 new arrays
     * */
    static void solve() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] newA = removeElement(i, a);
            for (int j = 0; j < n; j++) {
                int[] newB = removeElement(j, b);
                max = Math.max(max, generateScore(newA, newB));
            }
        }
        System.out.println(max);
    }

    static int[] removeElement(int index, int[] array) {
        List<Integer> arrayList = IntStream.of(array).boxed().collect(Collectors.toList());

        arrayList.remove(index);
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }

    static int generateScore(int[] a, int[] b) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {

            if (a[i] == b[i]) {
                count++;
            } else {
                count = 0;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
