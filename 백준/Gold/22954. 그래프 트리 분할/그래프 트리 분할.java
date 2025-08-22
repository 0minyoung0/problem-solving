import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[N + 1];
        List<int[]>[] edges = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        List<int[]> edgeList = new ArrayList<>();
        edgeList.add(new int[] {});
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(new int[] { v, i });
            edges[v].add(new int[] { u, i });

            edgeList.add(new int[] { u, v });
        }

        Queue<Integer> q = new ArrayDeque<>();
        List<List<Integer>[]> trees = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (visit[i]) {
                continue;
            }

            List<Integer> treeNodes = new ArrayList<>();
            List<Integer> treeEdges = new ArrayList<>();

            treeNodes.add(i);
            visit[i] = true;
            q.offer(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int[] next : edges[cur]) {
                    int nextNode = next[0];
                    if (visit[nextNode]) {
                        continue;
                    }
                    treeNodes.add(nextNode);
                    visit[nextNode] = true;
                    q.offer(nextNode);
                    treeEdges.add(next[1]);
                }
            }

            trees.add(new List[] { treeNodes, treeEdges });
        }

        // 트리가 3개 이상인 경우
        if (trees.size() >= 3) {
            System.out.println(-1);
            return;
        }
        // 트리가 2개인 경우
        if (trees.size() == 2) {
            // 2개의 트리 사이즈가 같은 경우
            if (trees.get(0)[0].size() == trees.get(1)[0].size()) {
                System.out.println(-1);
                return;
            }
            // 2개의 트리 각각을 순회하며 정답 출력
            StringBuilder sb = new StringBuilder();
            sb.append(trees.get(0)[0].size()).append(' ').append(trees.get(1)[0].size());
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    sb.append('\n');
                    for (int x : trees.get(i)[j]) {
                        sb.append(x).append(' ');
                    }
                }
            }
            System.out.println(sb);
            return;
        }
        // 트리가 1개이면서 사이즈가 2이하인 경우
        if (N <= 2) {
            System.out.println(-1);
            return;
        }
        // 트리가 1개이면서 사이즈가 2보다 큰 경우
        List<Integer>[] tree = trees.get(0);
        List<Integer> treeEdges = tree[1];

        int[] count = new int[N + 1];
        for (int e : treeEdges) {
            int[] edge = edgeList.get(e);
            count[edge[0]]++;
            count[edge[1]]++;
        }

        int leafNode = 0;
        for (int i = 1; i <= N; i++) {
            if (count[i] == 1) {
                leafNode = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(1).append(' ').append(N - 1).append('\n').append(leafNode).append("\n\n");
        for (int i = 1; i <= N; i++) {
            if (i == leafNode) {
                continue;
            }
            sb.append(i).append(' ');
        }
        sb.append('\n');
        for (int e : treeEdges) {
            int[] edge = edgeList.get(e);
            if (edge[0] == leafNode || edge[1] == leafNode) {
                continue;
            }
            sb.append(e).append(' ');
        }
        System.out.println(sb);
    }
}