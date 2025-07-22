/*
 * 문제: 백준 20115번 - 에너지 드링크 (https://www.acmicpc.net/problem/20115)
 * 문제 풀이
 *  용량이 가장 큰 에너지 드링크에 나머지 에너지 드링크를 부으면 합친 에너지 드링크의 최대 용량을 구할 수 있음.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_20115_에너지드링크 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double max = 0;
        double drink = 0;

        for (int i = 0; i < n; i++) {
            double x = Double.parseDouble(st.nextToken()) / 2;

            max = Math.max(max, x);
            drink += x;
        }

        drink += max;
        bw.write(Double.toString(drink));
        br.close();
        bw.close();
    }
}
