import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        List<Integer>[] edges = new List[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken()) - 1;
            int V = Integer.parseInt(st.nextToken()) - 1;
            edges[U].add(V);
            edges[V].add(U);
        }

        int leafCount = 0;
        boolean[] visit = new boolean[N];

        Queue<Integer> q = new ArrayDeque<>();
        visit[0] = true;
        q.offer(0);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nx : edges[cur]) {
                if (visit[nx]) {
                    continue;
                }
                visit[nx] = true;
                if (edges[nx].size() == 1) {
                    leafCount++;
                } else {
                    q.offer(nx);
                }
            }
        }

        System.out.println((double) W / leafCount);
    }
}