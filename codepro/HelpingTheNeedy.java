package SCPT.class2batch3.codepro;

import java.util.*;

public class HelpingTheNeedy {
    int N;//The number of goods to send
    int C[] = new int[10];//The number of BOXes(in order of 1, 5, 10, 50, 100, 500, 1000, 3000, 6000, 12000)
    int sol[] = new int[10];//The number of boxes to send
    int A[] = new int[]{1, 5, 10, 50, 100, 500, 1000, 3000, 6000, 12000};

    void InputData() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < 10; i++) {
            C[i] = sc.nextInt();
        }
    }

    void solve(int ans) {
        for (int i = 0; i < 9; i++) {
            //amount of boxes
            int t = Math.min(C[i], N / A[i]);
            N = N - t * A[i];

            // amount of missing number to divide for the second number
            int missingNumber = A[i + 1] - N % A[i + 1];

            // amount of missing boxes to divide for the second number
            t = t - missingNumber / A[i];

            N = N + missingNumber;

            ans = ans + t;
            sol[i] = t;
        }
        ans = N / A[9];
        sol[9] = N / A[9];
    }

    void OutputData(int ans) {
        System.out.println(ans);
        for (int i = 0; i < 10; i++) {
            System.out.print(sol[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int ans = -1;
        HelpingTheNeedy m = new HelpingTheNeedy();
        m.InputData();//Input function

        //	Create the code
        m.solve(ans);
        m.OutputData(ans);//	Output function
    }
}
