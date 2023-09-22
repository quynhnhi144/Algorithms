// Meetingroom
package SCPT.class2.Learning.greedy;

import java.util.*;

public class MeetingRoom {
    static Scanner ip = new Scanner(System.in);
    static long n;
    static long[] a = new long[5000 + 5];
    static long[] b = new long[5000 + 5];

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        n = ip.nextLong();
        List<Point> points = new ArrayList();
        long count = 0;
        for (int i = 0; i < n; i++) {
            points.add(new Point(ip.nextLong(), ip.nextLong()));
        }

        points.sort((a, b) -> (int) (a.end - b.end));
        long tem = 0;
        for (int i = 0; i < n; i++) {
            if(tem <= points.get(i).start){
                count++;
                tem = points.get(i).end;
            }
        }
        System.out.println(count);
    }

    static class Point {
        long start;
        long end;

        public Point(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}
