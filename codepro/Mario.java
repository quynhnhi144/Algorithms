package SCPT.class2batch3.codepro;

import java.util.*;

public class Mario {
    int N;//Number of mushrooms
    int P[] = new int[150000 + 10];//Mushroom value
    int MaxPlus[] = new int[150000 + 10];
    int MaxSub[] = new int[150000 + 10];

    public void inputData() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            P[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        Mario m = new Mario();
//        int ans = -1;
        m.inputData();                //	Input function
        //	Write the code
        m.solve();
//        System.out.println(ans);    //	Output answer
    }

    void solve() {
        int maxAdd = P[1];
        int maxSub = -P[1];
        MaxPlus[1] = P[1];
        MaxSub[1] = -P[1];

        for (int i = 1; i <= N; i++) {
            maxAdd = Math.max(maxAdd, MaxPlus[i]);
            maxSub = Math.max(maxSub, MaxSub[i]);
            MaxPlus[i + 1] = maxSub + P[i + 1];
            MaxSub[i + 1] = maxAdd - P[i + 1];
        }

        System.out.println(maxAdd);

    }
}
