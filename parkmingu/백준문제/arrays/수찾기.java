package parkmingu.백준문제.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class 수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N =sc.nextInt();

        int[] A = new int[N];

        for(int i =0; i < N; i++){
            String str = sc.next();
            if(str != " "){
                A[i] = Integer.parseInt(str);
            }
        }

        Arrays.sort(A);

        int M = sc.nextInt();

        for(int i =0; i < M; i++){
            String str = sc.next();
            if(str != " "){
                if(Arrays.binarySearch(A, Integer.parseInt(str)) >-1){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
        }
    }
}
