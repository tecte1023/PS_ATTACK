/*
 * 문제: 백준 25239번 - 가희와 카오스 파풀라투스 (https://www.acmicpc.net/problem/25239)
 *
 * 시간 복잡도: O(l)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_25239_가희와카오스파풀라투스 {
    // public class Main {
    static int time;
    static int[] area;

    private static void event(String command) {
        if (command.equals("^")) {
            if (time % 120 == 0) {
                return;
            }

            area[time / 120] = 0;
        } else if (command.charAt(2) == 'M') {
            int t = (command.charAt(0) - '0') * 10 + (command.charAt(1) - '0');

            time = (time + t) % 720;
        } else {
            int t = (command.charAt(0) - '0') * 60;

            time = (time + t) % 720;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");

        time = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        area = new int[6];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            area[i] = Integer.parseInt(st.nextToken());
        }

        int l = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            event(st.nextToken());
        }

        for (int i = 0; i < 6; i++) {
            result += area[i];
        }

        bw.write(Integer.toString(Math.min(result, 100)));
        br.close();
        bw.close();
    }
}
