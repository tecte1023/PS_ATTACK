/*
 * 문제: 백준 2134번 - 창고 이전 (https://www.acmicpc.net/problem/2134)
 *
 * 시간 복잡도: O(n + m)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2134_창고이전 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] a = new long[n + 1];
        int floor = 1;
        long x = 0;
        long y = 0;

        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(br.readLine());
        }

        for (int i = 1; i <= m; i++) {
            long cnt = Integer.parseInt(br.readLine());

            while (floor <= n) {
                if (a[floor] > cnt) {
                    x += cnt;
                    y += cnt * floor + cnt * i;
                    a[floor] -= cnt;
                    break;
                }

                x += a[floor];
                y += a[floor] * floor + a[floor] * i;
                cnt -= a[floor++];
            }
        }

        bw.write(x + " " + y);
        br.close();
        bw.close();
    }
}
