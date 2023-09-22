package SCPT.class2.pretest;

import java.util.*;

public class RepeatingString {
    static Scanner ip = new Scanner(System.in);
    static int n;

    public static void main(String[] args) {
        n = Integer.parseInt(ip.nextLine());
        while (n-- > 0) {
            String t = ip.next();
            if (isSubstring(t)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean isSubstring(String inp) {
        int size = inp.length();
        for (int i = 0; i < size; i++) {
            if (inp.charAt(i) != 'a' && inp.charAt(i) != 'b' && inp.charAt(i) != 'c') {
                return false;
            }
        }

        for (int i = 0; i < size - 1; i++) {
            if (inp.charAt(i) == 'a' && (inp.charAt(i + 1) != 'b' || inp.charAt(i + 1) == 'c'))
                return false;
            if (inp.charAt(i) == 'b' && (inp.charAt(i + 1) != 'c' || inp.charAt(i + 1) == 'a'))
                return false;
        }
        return true;
    }
}
