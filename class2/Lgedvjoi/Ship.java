package SCPT.class2.batch4;

import java.util.*;

public class Ship {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int[] array = new int[10];
    static boolean[] used = new boolean[10];
    static int[] hv = new int[10];
    static Point[] points = new Point[10];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        n = ip.nextInt();

        // Create the an array from 1 -> n
        for (int i = 1; i <= n; i++) {
            points[i] = new Point(ip.nextInt(), ip.nextInt());
            array[i] = i;
            used[i] = false;
        }

        Point a = new Point(ip.nextInt(), ip.nextInt());
        Point b = new Point(ip.nextInt(), ip.nextInt());

        generationSwap(1, array, a, b);
        System.out.println(min);
    }

    static void generationSwap(int index, int[] array, Point a, Point b) {
        if (index > n) {
            int count = 0;
            while(count <= n){
                List<Point> arrayA = new ArrayList<>();
                arrayA.add(a);
                List<Point> arrayB = new ArrayList<>();
                arrayB.add(b);

                for (int i = 1; i <= n; i++) {
                    if(i <= count){
                        arrayA.add(points[hv[i]]);
                    }else{
                        arrayB.add(points[hv[i]]);
                    }
                }
                arrayA.add(a);
                arrayB.add(b);
                count++;
                min = Math.min(min, minimumFuelConsumption(arrayA) + minimumFuelConsumption(arrayB));
            }
        }
        //Hoan vi tu 1 -> n
        for (int val = 1; val <= n; val++) {
            if (used[val] == true) {
                continue;
            }
            hv[index] = array[val];
            used[val] = true;
            generationSwap(index + 1, array, a, b);
            used[val] = false;
        }
    }

    static int minimumFuelConsumption(List<Point> points){
        int fuelConsumption = 0;
        int khoangsan = 0;
       for(int i = 0; i < points.size() - 1; i++){
           fuelConsumption += (Math.abs(points.get(i).x - points.get(i + 1).x) + Math.abs(points.get(i).y - points.get(i + 1).y)) * khoangsan;
           khoangsan++;
       }
       return fuelConsumption;
    }

    static void printArray(List<Point> points){
        for(int i = 0; i < points.size(); i++){
            System.out.print(points.get(i) + " ");
        }
        System.out.println();
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" + x +
                    "," + y +
                    '}';
        }
    }
}
