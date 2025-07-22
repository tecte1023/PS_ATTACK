/*
 * 문제: 백준 32622번 - 카드 뒤집기 게임 (https://www.acmicpc.net/problem/32622)
 * 문제 풀이
 *  1부터 x까지의 카드를 모두 뒤집을 수 있으므로 색이 바뀌는 경계 직전 번호까지 뒤집는 경우, 최대 점수를 구할 수 있음.
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_32622_카드뒤집기게임 {
    // public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String state = "0";
        int len = 0;
        List<Integer> list = new ArrayList<>();
        int max;

        for (int i = 1; i <= n; i++) {
            String a = st.nextToken();

            if (!a.equals(state)) {
                list.add(len);
                state = a;
                len = 0;
            }

            len++;
        }

        list.add(len);
        max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            max = Math.max(max, list.get(i - 1) + list.get(i));
        }

        bw.write(Integer.toString(max));
        br.close();
        bw.close();
    }
}
