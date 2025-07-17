/*
 * 문제: 백준 1015번 - 수열 정렬 (https://www.acmicpc.net/problem/1015)
 *
 * 시간 복잡도: O(n log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1015_수열정렬 {
    // public class Main {
    private static class Element {
        int idx, num;

        public Element(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Element[] a = new Element[n];
        int[] p = new int[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            a[i] = new Element(i, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(a, Comparator.comparingInt(e -> e.num));

        for (int i = 0; i < n; i++) {
            p[a[i].idx] = i;
        }

        for (int i = 0; i < n; i++) {
            sb.append(p[i]).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
