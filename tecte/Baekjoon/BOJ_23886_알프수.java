/*
 * 문제: 백준 23886번 - 알프수 (https://www.acmicpc.net/problem/23886)
 *
 * 시간 복잡도: O(n) - n: x의 자릿수
 */

package Baekjoon;

import java.io.*;

public class BOJ_23886_알프수 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String x = br.readLine();
        int s = 0;
        boolean ascent = false;
        boolean descent = false;
        String result = "ALPSOO";

        for (int i = 1; i < x.length(); i++) {
            int n = (x.charAt(i) - '0') - (x.charAt(i - 1) - '0');

            if (s > 0) {
                if (s == n || n < 0) {
                    s = n;
                } else {
                    result = "NON ALPSOO";
                    break;
                }
            } else if (s < 0) {
                if (s == n || n > 0) {
                    s = n;
                } else {
                    result = "NON ALPSOO";
                    break;
                }
            } else {
                if (n > 0) {
                    s = n;
                } else {
                    result = "NON ALPSOO";
                    break;
                }
            }
        }

        if (s > 0) {
            result = "NON ALPSOO";
        }

        bw.write(result);
        br.close();
        bw.close();
    }
}
