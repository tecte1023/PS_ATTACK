/*
 * 문제: 백준 11116번 - 교통량 (https://www.acmicpc.net/problem/11116)
 *
 * 시간 복잡도: O(n * m)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11116_교통량 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Set<Integer> left = new HashSet<>();
            Set<Integer> right = new HashSet<>();
            int cnt = 0;

            for (int i = 0; i < m; i++) {
                left.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) {
                right.add(Integer.parseInt(st.nextToken()));
            }

            for (int i : left) {
                if (left.contains(i + 500) && right.contains(i + 1000) && right.contains(i + 1500)) {
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
