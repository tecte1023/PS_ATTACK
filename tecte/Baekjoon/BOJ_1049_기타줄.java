/*
 * 문제: 백준 1049번 - 기타줄 (https://www.acmicpc.net/problem/1049)
 *
 * 시간 복잡도: O(m)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1049_기타줄 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int pack = Integer.MAX_VALUE;
        int unit = Integer.MAX_VALUE;
        int min;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            pack = Math.min(pack, p);
            unit = Math.min(unit, u);
        }

        if (pack / 6.0 > unit) {
            min = unit * n;
        } else {
            min = Math.min(pack * (n / 6) + unit * (n % 6), pack * (n / 6 + 1));
        }

        bw.write(Integer.toString(min));
        br.close();
        bw.close();
    }
}
