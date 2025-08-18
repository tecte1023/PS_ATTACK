package parkmingu.백준문제.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 욕심쟁이판다 {
    // 해결 X
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] forest = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < forest.length; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            for (int j = 0; j < forest[i].length; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] disX = { 0, 1, 0, -1 };
        int[] disY = { 1, 0, -1, 0 };
        boolean[][] visited;

        // 왼쪽 위 부터 탐색 시작
        for (int i = 0; i < forest.length; i++) {
            for (int j = 0; j < forest[i].length; j++) {
                bfs(i, j);
            }
        }

    }

    // 시작 좌표
    public static int bfs(int x, int y) {
        int max = 0;

        if(){
            
        }

        return 0;
    }
}
