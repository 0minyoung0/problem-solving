import java.io.*;
import java.util.*;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        List<int[]>[] edges = new List[N + 1];
        Set<Integer>[] trackingSet = new HashSet[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            trackingSet[i] = new HashSet<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[a].add(new int[] { b, c });
            edges[b].add(new int[] { a, c });
        }

        long[] dis = new long[N + 1];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[A] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            public int compare(long[] o1, long[] o2) {
                return o1[1] != o2[1] ? Long.compare(o1[1], o2[1]) : Long.compare(o1[0], o2[0]);
            }
        });
        pq.offer(new long[] { A, 0 });

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();

            int startNode = (int) cur[0];
            long startCost = cur[1];

            if (startCost > dis[startNode]) {
                continue;
            }

            for (int[] edge : edges[startNode]) {
                int edgeNode = edge[0];
                int edgeCost = edge[1];

                if (dis[edgeNode] < startCost + edgeCost) {
                    continue;
                }
                if (dis[edgeNode] > startCost + edgeCost) {
                    trackingSet[edgeNode].clear();
                    dis[edgeNode] = startCost + edgeCost;
                    pq.offer(new long[] { edgeNode, dis[edgeNode] });
                }
                trackingSet[edgeNode].add(startNode);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        set.add(B);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(B);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int prev : trackingSet[cur]) {
                if (set.contains(prev)) {
                    continue;
                }
                set.add(prev);
                q.offer(prev);
            }
        }

        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append('\n');
        for (int a : ans) {
            sb.append(a).append(' ');
        }
        System.out.print(sb);
    }
}