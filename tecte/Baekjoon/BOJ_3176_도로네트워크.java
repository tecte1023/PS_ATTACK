/*
 * 문제: 백준 3176번 - 도로 네트워크 (https://www.acmicpc.net/problem/3176)
 * 문제 풀이
 *  Binary Lifting을 사용하여 LCA를 구함.
 *  전처리 과정에서 각 노드의 조상뿐만 아니라, 조상으로 가는 경로에서 가장 짧은 도로의 길이와 가장 긴 도로의 길이를 구함.
 *  두 노드를 LCA까지 끌어올리면서 LCA까지의 경로에서 가장 짧은 도로의 길이와 가장 긴 도로의 길이를 구함.
 *
 * 시간 복잡도: O((n + k) log n)
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_3176_도로네트워크 {
    // public class Main {
    private static int h;
    private static Node[] nodes;
    private static List<List<Edge>> graph = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    private static void dfs(int lv, int n, int p) {
        nodes[n].level = lv;
        nodes[n].ancestor[0] = p;

        for (Edge edge : graph.get(n)) {
            if (edge.to != p) {
                nodes[edge.to].min[0] = nodes[edge.to].max[0] = edge.w;
                dfs(lv + 1, edge.to, n);
            }
        }
    }

    private static void lca(int a, int b) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int tmp = a;

        if (nodes[a].level > nodes[b].level) {
            a = b;
            b = tmp;
        }

        for (int i = h; i >= 0; i--) {
            if (nodes[a].level <= nodes[nodes[b].ancestor[i]].level) {
                min = Math.min(min, nodes[b].min[i]);
                max = Math.max(max, nodes[b].max[i]);
                b = nodes[b].ancestor[i];
            }
        }

        if (a == b) {
            sb.append(min).append(" ").append(max).append("\n");

            return;
        }

        for (int i = h; i >= 0; i--) {
            if (nodes[a].ancestor[i] != nodes[b].ancestor[i]) {
                min = Math.min(min, Math.min(nodes[a].min[i], nodes[b].min[i]));
                max = Math.max(max, Math.max(nodes[a].max[i], nodes[b].max[i]));
                a = nodes[a].ancestor[i];
                b = nodes[b].ancestor[i];
            }
        }

        min = Math.min(min, Math.min(nodes[a].min[0], nodes[b].min[0]));
        max = Math.max(max, Math.max(nodes[a].max[0], nodes[b].max[0]));
        sb.append(min).append(" ").append(max).append("\n");
    }

    private static class Edge {
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    private static class Node {
        int level;
        int[] ancestor = new int[h + 1];
        int[] min = new int[h + 1];
        int[] max = new int[h + 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        h = (int) (Math.log(n) / Math.log(2));
        nodes = new Node[n + 1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node();
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        dfs(1, 1, 0);

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                int ancestor = nodes[j].ancestor[i - 1];

                nodes[j].ancestor[i] = nodes[ancestor].ancestor[i - 1];
                nodes[j].min[i] = Math.min(nodes[j].min[i - 1], nodes[ancestor].min[i - 1]);
                nodes[j].max[i] = Math.max(nodes[j].max[i - 1], nodes[ancestor].max[i - 1]);
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            lca(d, e);
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
