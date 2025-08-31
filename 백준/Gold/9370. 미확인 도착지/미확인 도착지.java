import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            List<int[]>[] edges = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                edges[i] = new ArrayList<>();
            }

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                edges[a].add(new int[] { b, d });
                edges[b].add(new int[] { a, d });
            }

            int[] x = new int[t];
            for (int i = 0; i < t; i++) {
                x[i] = Integer.parseInt(br.readLine());
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] != o2[1]) {
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[1];
                }
            });

            int[] sDis = new int[n + 1];
            Arrays.fill(sDis, 100_000_000);
            sDis[s] = 0;
            pq.offer(new int[] { s, 0 });
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (sDis[cur[0]] != cur[1]) {
                    continue;
                }
                for (int[] e : edges[cur[0]]) {
                    if (sDis[e[0]] <= cur[1] + e[1]) {
                        continue;
                    }
                    sDis[e[0]] = cur[1] + e[1];
                    pq.offer(new int[] { e[0], cur[1] + e[1] });
                }
            }

            int[] gDis = new int[n + 1];
            Arrays.fill(gDis, 100_000_000);
            gDis[g] = 0;
            pq.offer(new int[] { g, 0 });
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (gDis[cur[0]] != cur[1]) {
                    continue;
                }
                for (int[] e : edges[cur[0]]) {
                    if (gDis[e[0]] <= cur[1] + e[1]) {
                        continue;
                    }
                    gDis[e[0]] = cur[1] + e[1];
                    pq.offer(new int[] { e[0], cur[1] + e[1] });
                }
            }

            int[] hDis = new int[n + 1];
            Arrays.fill(hDis, 100_000_000);
            hDis[h] = 0;
            pq.offer(new int[] { h, 0 });
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (hDis[cur[0]] != cur[1]) {
                    continue;
                }
                for (int[] e : edges[cur[0]]) {
                    if (hDis[e[0]] <= cur[1] + e[1]) {
                        continue;
                    }
                    hDis[e[0]] = cur[1] + e[1];
                    pq.offer(new int[] { e[0], cur[1] + e[1] });
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                if (sDis[x[i]] == sDis[g] + gDis[h] + hDis[x[i]] || sDis[x[i]] == sDis[h] + hDis[g] + gDis[x[i]]) {
                    ans.add(x[i]);
                }
            }
            Collections.sort(ans);
            for (int a : ans) {
                sb.append(a).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}