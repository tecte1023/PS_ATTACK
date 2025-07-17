/*
 * 문제: 백준 21968번 - 선린의 터를 (https://www.acmicpc.net/problem/21968)
 * 문제 풀이
 *  n을 2의 거듭제곱들의 합으로 표현하고 밑인 2를 3으로 바꾸어 계산.
 *
 * 시간 복잡도: O(t)
 */

package Baekjoon;

import java.io.*;

public class BOJ_21968_선린의터를 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            long num = 1;
            long result = 0;

            for (int i = 0; i < 64; i++) {
                if ((n & (1L << i)) != 0) {
                    result += num;
                }

                num *= 3;
            }

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
