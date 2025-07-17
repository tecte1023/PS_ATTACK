/*
 * 문제: 백준 1014번 - 컨닝 (https://www.acmicpc.net/problem/1014)
 * 문제 풀이
 *  각 열마다 학생이 앉을 수 있는 자리의 상태를 비트마스크로 표현.
 *  비트마스크 DP를 사용하여 부서진 자리와 컨닝할 수 있는 자리를 제외하고 최대 학생 수를 계산.
 *
 * 시간 복잡도: O(m * 4^n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1014_컨닝 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (c-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] broken = new int[m + 1];
            int[][] memo = new int[1 << n][m + 1];
            int max = 0;

            for (int i = 0; i < n; i++) {
                String l = br.readLine();

                for (int j = 0; j < l.length(); j++) {
                    if (l.charAt(j) == 'x') {
                        broken[j + 1] |= (1 << i);
                    }
                }
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < memo.length; j++) {
                    if ((broken[i] & j) != 0) {
                        continue;
                    }

                    int cnt = Integer.bitCount(j);

                    for (int k = 0; k < memo.length; k++) {
                        if (((k & (j >> 1)) | (k & j) | (k & (j << 1))) == 0) {
                            memo[j][i] = Math.max(memo[j][i], memo[k][i - 1] + cnt);
                        }
                    }
                }
            }

            for (int i = 0; i < memo.length; i++) {
                max = Math.max(max, memo[i][m]);
            }

            sb.append(max).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
