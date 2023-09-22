//Lucky money
package SCPT.class2.Learning.greedy;

import java.util.*;

public class LuckyNumber {
    static Scanner ip = new Scanner(System.in);
    static int n;

    public static void main(String[] args) {
        n = ip.nextInt();
        solve();
    }

    static void solve() {
        List<Point> points = new ArrayList();
        long sum = 0;
        long sumAmount = 1;
        for (int i = 1; i <= n; i++) {
            points.add(new Point(ip.nextInt(), ip.nextInt()));
        }

//        points.sort((p1, p2) -> p1.amount - p2.amount);
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.amount == o2.amount && o1.value < o2.value) {
                    return 1;
                } else if (o2.amount - o1.amount > 0) {
                    return 1;
                }
                return -1;
            }
        });
        for (int i = 0; i < n; i++) {
            if (sumAmount > 0) {
                sumAmount--;
                sum += points.get(i).value;
                sumAmount += points.get(i).amount;
            }

        }
        System.out.println(sum);
    }

    static class Point {
        int value;
        int amount;

        public Point(int value, int amount) {
            this.value = value;
            this.amount = amount;
        }
    }
}
