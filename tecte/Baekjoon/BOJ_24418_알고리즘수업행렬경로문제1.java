/*
 * 문제: 백준 24418번 - 알고리즘 수업 - 행렬 경로 문제 1 (https://www.acmicpc.net/problem/24418)
 *
 * 시간 복잡도: O(4^n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_24418_알고리즘수업행렬경로문제1 {
    // public class Main {
    private static int n;
    private static int[][] matrix;
    private static int code1 = 0;
    private static int code2 = 0;

    private static int matrixPathRec(int i, int j) {
        if (i == 0 || j == 0) {
            code1++;

            return 0;
        } else {
            return matrix[i][j] + Math.max(matrixPathRec(i - 1, j), matrixPathRec(i, j - 1));
        }
    }

    private static void matrixPath() {
        int[][] d = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                d[i][j] = matrix[i][j] + Math.max(d[i - 1][j], d[i][j - 1]);
                code2++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        matrix = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        matrixPathRec(n, n);
        matrixPath();
        bw.write(code1 + " " + code2);
        br.close();
        bw.close();
    }
}
