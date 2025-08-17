/*
 * 문제: 백준 21276번 - 계보 복원가 호석 (https://www.acmicpc.net/problem/21276)
 * 문제 풀이
 *  위상 정렬과 TreeSet을 사용하여 사전순 대로 사람의 이름과 자식의 수, 자식들의 이름을 구함.
 *
 * 시간 복잡도: O(n^2
 */

package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_21276_계보복원가호석 {
    // public class Main {
    private static class Node {
        List<String> ancestors = new ArrayList<>();
        List<String> children = new ArrayList<>();
        int inDegree = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Map<String, Node> people = new HashMap<>();
        Set<String> root = new TreeSet<>();
        Set<String> leaf = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, StringBuilder> map = new TreeMap<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String name = st.nextToken();

            people.put(name, new Node());
            leaf.add(name);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            String y = st.nextToken();

            people.get(x).ancestors.add(y);
            people.get(y).children.add(x);
            people.get(y).inDegree++;
            leaf.remove(y);
        }

        leaf.forEach(queue::offer);

        while (!queue.isEmpty()) {
            String name = queue.poll();
            Node person = people.get(name);
            StringBuilder sb = new StringBuilder();
            Set<String> children = new TreeSet<>();

            if (person.ancestors.isEmpty()) {
                root.add(name);
            }

            for (String ancestor : person.ancestors) {
                if (--people.get(ancestor).inDegree == 0) {
                    queue.offer(ancestor);
                }
            }

            for (String child : person.children) {
                if (people.containsKey(child)) {
                    children.add(child);
                    people.remove(child);
                }
            }

            sb.append(name).append(" ").append(children.size());
            children.forEach(s -> sb.append(" ").append(s));
            map.put(name, sb);
        }

        result.append(root.size()).append("\n");
        root.forEach(s -> result.append(s).append(" "));
        result.append("\n");
        map.values().forEach(v -> result.append(v).append("\n"));
        bw.write(result.toString());
        br.close();
        bw.close();
    }
}
