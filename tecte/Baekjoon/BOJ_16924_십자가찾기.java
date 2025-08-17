/*
 * 문제: 백준 16924번 - 십자가 찾기 (https://www.acmicpc.net/problem/16924)
 *
 * 시간 복잡도: O(n^2 * m)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_16924_십자가찾기 {
    // public class Main {
    private static int n, m;
    private static char[][] board;

    private static int find(int x, int y) {
        if (board[x][y] == '.') {
            return 0;
        }

        for (int i = 1; ; i++) {
            int minX = x - i;
            int maxX = x + i;
            int minY = y - i;
            int maxY = y + i;

            if (minX <= 0 || maxX > n || minY <= 0 || maxY > m
                    || board[minX][y] == '.' || board[maxX][y] == '.' || board[x][minY] == '.' || board[x][maxY] == '.') {
                return i - 1;
            }

            board[x][y] = board[minX][y] = board[maxX][y] = board[x][minY] = board[x][maxY] = 0;
        }
    }

    private static boolean hasAsterisk() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == '*') {
                    return true;
                }
            }
        }

        return false;
    }

    private static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();

            for (int j = 1; j <= m; j++) {
                board[i][j] = str.charAt(j - 1);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int size = find(i, j);

                if (size > 0) {
                    cnt++;
                    sb.append("\n").append(i).append(" ").append(j).append(" ").append(size);
                }
            }
        }

        if (hasAsterisk()) {
            sb = new StringBuilder("-1");
        } else {
            sb.insert(0, cnt);
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
