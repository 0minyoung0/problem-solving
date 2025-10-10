import java.io.*;
import java.util.*;

public class Main {
    static int id, sccId;
    static int[] ids, sccIds, inDegree;
    static boolean[] finished;
    static List<Integer>[] edges;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            id = 0;
            sccId = 0;
            ids = new int[N + 1];
            sccIds = new int[N + 1];
            finished = new boolean[N + 1];
            edges = new List[N + 1];
            for (int i = 1; i <= N; i++) {
                edges[i] = new ArrayList<>();
            }

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                edges[x].add(y);
            }

            for (int i = 1; i <= N; i++) {
                if (ids[i] == 0) {
                    dfs(i);
                }
            }

            inDegree = new int[sccId];
            for (int i = 1; i <= N; i++) {
                for (int j : edges[i]) {
                    if (sccIds[i] != sccIds[j]) {
                        inDegree[sccIds[j]]++;
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < sccId; i++) {
                if (inDegree[i] == 0) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

    private static int dfs(int x) {
        ids[x] = ++id;
        dq.offerFirst(x);

        int parent = ids[x];
        for (int y : edges[x]) {
            if (ids[y] == 0) {
                parent = Math.min(parent, dfs(y));
            } else if (!finished[y]) {
                parent = Math.min(parent, ids[y]);
            }
        }

        if (parent == ids[x]) {
            while (true) {
                int cur = dq.poll();
                sccIds[cur] = sccId;
                finished[cur] = true;
                if (cur == x) {
                    break;
                }
            }
            sccId++;
        }

        return parent;
    }
}
