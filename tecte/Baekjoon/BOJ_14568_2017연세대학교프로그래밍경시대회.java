/*
 * 문제: 백준 14568번 - 2017 연세대학교 프로그래밍 경시대회 (https://www.acmicpc.net/problem/14568)
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;

public class BOJ_14568_2017연세대학교프로그래밍경시대회 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                int candy = n - i - j;

                if (candy > 0 && candy % 2 == 0) {
                    cnt++;
                }
            }
        }

        bw.write(Integer.toString(cnt));
        br.close();
        bw.close();
    }
}
