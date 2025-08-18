package parkmingu.백준문제.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수정렬하기 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        
        for(int i =1; i <= n; i++){
            arr[Integer.parseInt(br.readLine())] += 1;
        }

        for(int i = 1; i < 10001; i++){
            for(int j =0; j < arr[i]; j++){
                bw.write(i + "\n");
                // bw.flush();
            }
        }

        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory + " bytes");

        bw.close();
    }
}