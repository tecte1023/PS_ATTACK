package parkmingu.백준문제.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추 {

    public static boolean[][] field;
    public static boolean[][] check;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");


            // m가로 n세로
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int count = 0;

            // 초기화
            field = new boolean[n][m];
            check = new boolean[n][m];

            for(int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = true;
            }

            // for(int y = 0; y < n; y++){
            //     for(int x = 0; x < m; x++){
            //         System.out.print(field[y][x] + " ");
            //     }
            //     System.out.println();
            // }


            for(int y = 0; y < n; y++){
                for(int x = 0; x < m; x++){
                    if((field[y][x] == true) && dfs(y, x)) {
                        count++;
                    }
                }
            }
            
            System.out.println(count);
        }
    }

    // 현재 좌표값을 받아옴
    public static boolean dfs(int y, int x){

        // 범위를 벗어나면 리턴
        if(y < 0 || y > check.length - 1 || x < 0 || x > check[y].length -1) return false;

        // 현재 노드에 배추가 있고 노드를 방문하지 않았다면
        if(field[y][x] == true && check[y][x] == false){
            // 해당 노드 방문처리
            check[y][x] = true;

            // 상 좌 하 우 순서로 방문하기
            dfs(y -1, x);
            dfs(y, x-1);
            dfs(y + 1, x);
            dfs(y, x + 1);

            // 연결된 모든 노드를 탐색하면 탈출
            return true;
        }

        // 방문한 노드면 false
        return false;
    }
}