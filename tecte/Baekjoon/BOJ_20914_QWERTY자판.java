/*
 * 문제: 백준 20914번 - QWERTY 자판 (https://www.acmicpc.net/problem/20914)
 * 문제 풀이
 *  키보드 자판을 배열로 정의.
 *  플로이드-워셜 알고리즘을 사용하여 각 알파벳 간의 최소 이동 거리를 계산.
 *
 * 시간 복잡도: O(n^3 + t * l) - n: 알파벳 개수, l: 문자열의 길이
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_20914_QWERTY자판 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        char[] key = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
        int[][] floyd = new int[26][26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < floyd.length; i++) {
            Arrays.fill(floyd[i], Integer.MAX_VALUE >> 1);
            floyd[i][i] = 0;
        }

        for (int i = 0; i < key.length; i++) {
            if (i != 9 && i != 18 && i != 25) {
                floyd[key[i] - 'A'][key[i + 1] - 'A'] = 2;
            }

            if (i != 0 && i != 10 && i != 19) {
                floyd[key[i] - 'A'][key[i - 1] - 'A'] = 2;
            }

            if (i < 10) {
                if (i > 0) {
                    floyd[key[i] - 'A'][key[i + 9] - 'A'] = 2;
                }

                if (i < 9) {
                    floyd[key[i] - 'A'][key[i + 10] - 'A'] = 2;
                }
            } else if (i < 19) {
                floyd[key[i] - 'A'][key[i - 10] - 'A'] = 2;
                floyd[key[i] - 'A'][key[i - 9] - 'A'] = 2;

                if (i != 10 && i != 18) {
                    floyd[key[i] - 'A'][key[i + 8] - 'A'] = 2;
                }

                if (i < 17) {
                    floyd[key[i] - 'A'][key[i + 9] - 'A'] = 2;
                }
            } else {
                floyd[key[i] - 'A'][key[i - 9] - 'A'] = 2;
                floyd[key[i] - 'A'][key[i - 8] - 'A'] = 2;
            }
        }

        for (char i : key) {
            for (char k : key) {
                for (char j : key) {
                    int s = i - 'A';
                    int m = k - 'A';
                    int e = j - 'A';

                    floyd[s][e] = Math.min(floyd[s][e], floyd[s][m] + floyd[m][e]);
                }
            }
        }

        while (t-- > 0) {
            String str = br.readLine();
            int sec = 1;

            for (int i = 1; i < str.length(); i++) {
                sec += floyd[str.charAt(i - 1) - 'A'][str.charAt(i) - 'A'] + 1;
            }

            sb.append(sec).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
