package SCPT.class2;

import java.util.*;

public class PleasantPairs {
    static Scanner ip = new Scanner(System.in);
    static long t;

    public static void main(String[] args) {
        t = Long.parseLong(ip.nextLine());
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() {
        long n = ip.nextLong();
        List<Point> points = new ArrayList();
        for (long i = 1; i <= n; i++) {
            points.add(new Point(ip.nextLong(), i));
        }

        points.sort((x, y) -> {
            if(x.value >= y.value) return 1;
            else return  -1;
        });


//        points.sort(Comparator.comparingLong(Point:));
        /**
         * polong[i].value * polong[j].value = i + j = n + n = 2n
         * polong[i].value <= sqrt(2n)
         * */
        long count = 0;
        for (int i = 0; i < n - 1; i++) {
            // filter i
            if (points.get(i).value > (long)Math.sqrt(2 * n)) break;
            for (int j = i + 1; j < n; j++) {
                if (points.get(i).value * points.get(j).value == (points.get(i).index + points.get(j).index)) {
                    count++;
                    // filter j
                } else if (points.get(i).value * points.get(j).value > 2 * n) {
                    break;
                }
            }
        }
        System.out.println(count);
    }

    static class Point {
        long value;
        long index;

        public Point(long value, long index) {
            this.value = value;
            this.index = index;
        }
    }
}
