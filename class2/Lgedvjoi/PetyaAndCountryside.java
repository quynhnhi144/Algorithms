package SCPT.class2.batch4;

import java.util.*;
public class PetyaAndCountryside {
    static Scanner ip = new Scanner(System.in);
    static int n;
    static int[] array = new int[1005];
    public static void main(String[] args) {
        solve();
    }

    static void solve(){
        n = ip.nextInt();
        for(int i = 1; i <= n; i++){
            array[i] = ip.nextInt();
        }

        int max = -1;
        for(int i = 1; i <= n; i++){
            // height of water section used
            int h = array[i];
            int count = 1;

            // Duyet cac cot tu trai qua phai sao cho chieu cao cac cot phai giam dan
            int prevH = array[i];
            for(int j = i + 1; j <= n; j++){
                if(array[j] <= prevH){
                    prevH = array[j];
                    count++;
                }else{
                    break;
                }
            }

            prevH = array[i];
            for(int k = i - 1; k >= 1; k--){
                if(array[k] <= prevH){
                    prevH = array[k];
                    count++;
                }else{
                    break;
                }
            }
           max = Math.max(max,count);
        }
        System.out.println(max);
    }
}
