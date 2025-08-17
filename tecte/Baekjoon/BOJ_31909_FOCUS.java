/*
 * 문제: 백준 31909번 - FOCUS (https://www.acmicpc.net/problem/31909)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_31909_FOCUS {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[8];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            int a = 0;
            int b = 0;
            int cnt = 0;

            for (int j = 0; j < 32; j++) {
                if ((p & (1 << j)) != 0) {
                    if (a == 0) {
                        a = j;
                    } else if (b == 0) {
                        b = j;
                    }

                    cnt++;
                }
            }

            if (cnt == 2) {
                int tmp = arr[a];

                arr[a] = arr[b];
                arr[b] = tmp;
            }
        }

        bw.write(Integer.toString(arr[k]));
        br.close();
        bw.close();
    }
}
