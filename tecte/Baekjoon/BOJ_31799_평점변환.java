/*
 * 문제: 백준 31799번 - 평점 변환 (https://www.acmicpc.net/problem/31799)
 *
 * 시간 복잡도: O(n)
 */

package Baekjoon;

import java.io.*;

public class BOJ_31799_평점변환 {
    // public class Main {
    private static char gradeLetter, gradeSign, prevLetter, prevSign;

    private static char getGrade() {
        if (gradeLetter == 'C') {
            return 'B';
        } else if (gradeLetter == 'B' && gradeSign != '+') {
            return (prevLetter == 'A' || prevLetter == 'B') ? 'B' : 'D';
        } else if (gradeLetter == 'B' || (gradeLetter == 'A' && gradeSign == '-')) {
            return (prevLetter == 'A' || (prevLetter == 'B' && prevSign == '+')) ? 'D' : 'P';
        } else if (gradeLetter == 'A' && gradeSign == '+') {
            return 'E';
        } else {
            return (prevLetter == 'A' && prevSign != '-') ? 'P' : 'E';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        gradeLetter = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            char g = str.charAt(i);

            if (Character.isLetter(g)) {
                sb.append(getGrade());
                prevLetter = gradeLetter;
                prevSign = gradeSign;
                gradeLetter = g;
                gradeSign = 0;
            } else {
                gradeSign = g;
            }
        }

        bw.write(sb.append(getGrade()).toString());
        br.close();
        bw.close();
    }
}
