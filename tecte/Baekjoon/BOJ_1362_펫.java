/*
 * 문제: 백준 1362번 - 펫 (https://www.acmicpc.net/problem/1362)
 *
 * 시간 복잡도: O(n * m) - n: 시나리오 수, m: 시나리오에서 펫에 가할 작용 횟수
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1362_펫 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (o == 0) {
                break;
            }

            while (true) {
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (c == '#') {
                    break;
                } else if (w > 0) {
                    w += c == 'E' ? -n : n;
                }
            }

            sb.append(i).append(" ").append((w > o / 2 && w < o * 2) ? ":-)" : (w > 0 ? ":-(" : "RIP")).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
