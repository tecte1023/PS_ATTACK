/*
 * 문제: 백준 9324번 - 진짜 메시지 (https://www.acmicpc.net/problem/9324)
 *
 * 시간 복잡도: O(t * l) - t: 테스트 케이스 수, l: 문자열의 길이
 */

package Baekjoon;

import java.io.*;

public class BOJ_9324_진짜메시지 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String m = br.readLine();
            int[] alphabet = new int[26];
            char add = 0;

            for (char c : m.toCharArray()) {
                if (add == 0) {
                    if (++alphabet[c - 'A'] % 3 == 0) {
                        add = c;
                    }
                } else if (add == c) {
                    add = 0;
                } else {
                    break;
                }
            }

            sb.append(add == 0 ? "OK" : "FAKE").append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
