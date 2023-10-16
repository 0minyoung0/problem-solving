import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] C = new int[N+1];
        for (int i=1; i<=N; i++){
            C[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer>[] graph = new List[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        List<Integer> value = new ArrayList<>();
        List<Integer> cost = new ArrayList<>();
        value.add(0);
        cost.add(0);
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[N+1];
        for (int i=1; i<=N; i++) {
            if (vis[i]) continue;
            int v = C[i];
            int c = 1;
            q.offer(i);
            vis[i] = true;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nx : graph[cur]) {
                    if (vis[nx]) continue;
                    v += C[nx];
                    c++;
                    q.offer(nx);
                    vis[nx] = true;
                }
            }
            value.add(v);
            cost.add(c);
        }

        int[][] ans = new int[value.size()][K];
        for (int i=1; i<value.size(); i++) {
            for (int j=1; j<K; j++) {
                if (j < cost.get(i)) ans[i][j] = ans[i-1][j];
                else ans[i][j] = Math.max(ans[i-1][j-cost.get(i)] + value.get(i), ans[i-1][j]);
            }
        }
        System.out.print(ans[value.size()-1][K-1]);

    }
}
