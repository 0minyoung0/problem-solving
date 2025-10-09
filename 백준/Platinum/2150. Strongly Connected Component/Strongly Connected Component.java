import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static int[] ids;
    static int id = 0;
    static boolean[] finished;
    static List<Integer>[] edges;
    static Deque<Integer> dq = new ArrayDeque<>();
    static List<List<Integer>> sccList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ids = new int[V + 1];
        finished = new boolean[V + 1];
        edges = new List[V + 1];
        for (int i = 1; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            edges[A].add(B);
        }

        for (int i = 1; i <= V; i++) {
            if (ids[i] == 0) {
                dfs(i);
            }
        }

        for (List<Integer> scc : sccList) {
            Collections.sort(scc);
        }
        Collections.sort(sccList, new Comparator<List<Integer>>() {
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(sccList.size());
        for (List<Integer> scc : sccList) {
            sb.append('\n');
            for (int node : scc) {
                sb.append(node).append(' ');
            }
            sb.append(-1);
        }
        System.out.println(sb);
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
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int cur = dq.poll();
                scc.add(cur);
                finished[cur] = true;
                if (cur == x) {
                    break;
                }
            }
            sccList.add(scc);
        }

        return parent;
    }
}
