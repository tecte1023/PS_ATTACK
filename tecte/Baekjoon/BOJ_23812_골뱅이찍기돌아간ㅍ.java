/*
 * 문제: 백준 23812번 - 골뱅이 찍기 - 돌아간 ㅍ (https://www.acmicpc.net/problem/23812)
 *
 * 시간 복잡도: O(n^2)
 */

package Baekjoon;

import java.io.*;

public class BOJ_23812_골뱅이찍기돌아간ㅍ {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < n; l++) {
                        if (i == 1 || i == 3 || k == 0 || k == 4) {
                            sb.append('@');
                        } else {
                            sb.append(' ');
                        }
                    }
                }

                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
