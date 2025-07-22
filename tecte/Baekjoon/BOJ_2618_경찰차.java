/*
 * 문제: 백준 2618번 - 경찰차 (https://www.acmicpc.net/problem/2618)
 * 문제 풀이
 *  DP를 사용하여 사건을 어떤 경찰차가 맡았는지를 저장.
 *  각 상태에서 경찰차의 위치를 저장하여 역추적함.
 *
 * 시간 복잡도: O(w^2)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2618_경찰차 {
    // public class Main {
    private static Pos[] events;
    private static Pos p1, p2;

    private static Pos getPos(int e, int p) {
        if (e == 0) {
            return p == 1 ? p1 : p2;
        }

        return events[e];
    }

    private static int getDist(Pos a, Pos b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
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
        int n = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());
        int[][] memo = new int[w + 1][w + 1];
        Pos[][] trace = new Pos[w + 1][w + 1];
        StringBuilder sb = new StringBuilder();

        events = new Pos[w + 1];
        p1 = new Pos(1, 1);
        p2 = new Pos(n, n);
        Arrays.fill(memo[0], Integer.MAX_VALUE >> 1);
        memo[0][0] = 0;

        for (int i = 1; i <= w; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            events[i] = new Pos(x, y);
            Arrays.fill(memo[i], Integer.MAX_VALUE >> 1);
        }

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < w; j++) {
                int next = Math.max(i, j) + 1;
                int dist1 = memo[i][j] + getDist(getPos(i, 1), events[next]);
                int dist2 = memo[i][j] + getDist(getPos(j, 2), events[next]);
                Pos pos = new Pos(i, j);

                if (dist1 < memo[next][j]) {
                    memo[next][j] = dist1;
                    trace[next][j] = pos;
                }

                if (dist2 < memo[i][next]) {
                    memo[i][next] = dist2;
                    trace[i][next] = pos;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int x = 0;
        int y = 0;

        for (int i = 0; i < w; i++) {
            if (min > memo[w][i]) {
                min = memo[w][i];
                x = w;
                y = i;
            }

            if (min > memo[i][w]) {
                min = memo[i][w];
                x = i;
                y = w;
            }
        }

        for (int i = 0; i < w; i++) {
            Pos pos = trace[x][y];

            if (y == pos.y) {
                sb.append("1\n");
                x = pos.x;
            } else {
                sb.append("2\n");
                y = pos.y;
            }
        }

        bw.write(Integer.toString(min));
        bw.write(sb.reverse().toString());
        br.close();
        bw.close();
    }
}
