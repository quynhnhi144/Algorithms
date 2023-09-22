//Max assignments count
package SCPT.class2.Learning.greedy;
import java.util.*;

public class MaxAssignmentsCount {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static long c;

    public static void main(String[] args) {
        n = ip.nextInt();
        c = ip.nextLong();
        solve();
    }

    static void solve(){
        List<Point> points = new ArrayList();
        for(int i = 0; i < n; i++){
           points.add(new Point(ip.nextLong(), ip.nextLong()));
        }

        points.sort((p1, p2) -> (int)(p1.skill - p2.skill));
        int count = 0;
        for(int i = 0; i < n; i++){
            if(c >= points.get(i).skill){
                count++;
                c += points.get(i).priceNumber;
            } else{
                break;
            }
        }
        System.out.println(count);

    }

    static class Point {
        long skill;
        long priceNumber;

        public Point(long skill, long priceNumber) {
            this.skill = skill;
            this.priceNumber = priceNumber;
        }
    }
}
