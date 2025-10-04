import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<int[]> edges = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = i + 1; j <= N; j++) {
                int c = Integer.parseInt(st.nextToken());
                edges.add(new int[] { i, j, c });
            }
        }

        Collections.sort(edges, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[2] != o2[2] ? o1[2] - o2[2] : o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        List<Integer>[] ans = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            ans[i] = new ArrayList<>();
        }

        int connectCount = 0;
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                continue;
            }
            ans[edge[0]].add(edge[1]);
            ans[edge[1]].add(edge[0]);
            if (++connectCount == N - 1) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            Collections.sort(ans[i]);
            sb.append(ans[i].size());
            for (int a : ans[i]) {
                sb.append(' ').append(a);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        }

        parent[Math.max(x, y)] = Math.min(x, y);
        return true;
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
