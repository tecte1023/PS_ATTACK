/*
 * 문제: 백준 23805번 - 골뱅이 찍기 - 돌아간 ㄹ (https://www.acmicpc.net/problem/23805)
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;

public class BOJ_23805_골뱅이찍기돌아간ㄹ {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < 5; j++) {
                char c = ((j == 1 && i != 0) || (j == 3 && i != 4)) ? ' ' : '@';

                for (int k = 0; k < n; k++) {
                    row.append(c);
                }
            }

            row.append("\n");

            for (int j = 0; j < n; j++) {
                sb.append(row);
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
