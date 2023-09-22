package SCPT.class2.batch2;

import java.util.*;
import java.util.stream.*;

public class LargestScore {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int[] a = new int[105];

    public static void main(String[] args) {
        n = ip.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = ip.nextInt();
        }
        solve();
    }

    static void solve() {
        int result = 1;
        result = Math.max(result, getScore(n, a));
        for (int i = 0; i < n; i++) {
            int[] newArray = removeAnElement(i, a);
            result = Math.max(result, getScore(n, newArray));
        }
        System.out.println(result);
    }

    static int[] removeAnElement(int index, int[] array) {
        List<Integer> newArray = IntStream.of(array).boxed().collect(Collectors.toList());
        newArray.remove(index);
        return newArray.stream().mapToInt(Integer::intValue).toArray();
    }

    static int getScore(int size, int[] array) {
        int res = 1;
        int count = 1;
        for (int i = 0; i < size - 1; i++) {
            if (array[i + 1] == array[i]) {
                count++;
            } else {
                count = 1;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}