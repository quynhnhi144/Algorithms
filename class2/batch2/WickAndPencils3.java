package SCPT.class2.batch2;


import static java.lang.Integer.parseInt;

import java.io.*;
import java.util.*;

public class WickAndPencils3 {
    static Scanner ip = new Scanner(System.in);

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] a = new int[5005];

    static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args)  throws IOException {
//        n = ip.nextInt();

        n = parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = parseInt(st.nextToken());
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        solve();
    }

    static long nC2(long n) {
        return n * (n - 1) / 2;
    }

    static void solve() {
        Arrays.sort(a, 1, n + 1);
        long count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= 2) {
                for (Map.Entry<Integer, Integer> e2: map.entrySet()) {
                    if(e2.getKey().equals(entry.getKey())) continue;
                    if(e2.getKey() >= 2 * entry.getKey()) break;
                    count += nC2(entry.getValue()) * e2.getValue();
                }
            }
        }
        System.out.println(count);
    }
}
