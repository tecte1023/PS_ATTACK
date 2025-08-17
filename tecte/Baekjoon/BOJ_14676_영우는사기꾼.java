/*
 * 문제: 백준 14676번 - 영우는 사기꾼? (https://www.acmicpc.net/problem/14676)
 * 문제 풀이
 *  진입차수 개념을 이용하여 건설 가능 여부 판단.
 *
 * 시간 복잡도: O(n + m + k)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14676_영우는사기꾼 {
    // public class Main {
    private static class Node {
        int from = 0;
        List<Integer> to = new ArrayList<>(3);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Node[] buildings = new Node[n + 1];
        int[] built = new int[n + 1];
        boolean isLier = false;

        for (int i = 1; i <= n; i++) {
            buildings[i] = new Node();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            buildings[x].to.add(y);
            buildings[y].from++;
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (isLier) {
                continue;
            }

            if (a == 1) {
                if (buildings[b].from == 0) {
                    if (built[b]++ == 0) {
                        for (int to : buildings[b].to) {
                            buildings[to].from--;
                        }
                    }
                } else {
                    isLier = true;
                }
            } else {
                if (built[b] > 0) {
                    if (--built[b] == 0) {
                        for (int to : buildings[b].to) {
                            buildings[to].from++;
                        }
                    }
                } else {
                    isLier = true;
                }
            }
        }

        bw.write(isLier ? "Lier!" : "King-God-Emperor");
        br.close();
        bw.close();
    }
}
