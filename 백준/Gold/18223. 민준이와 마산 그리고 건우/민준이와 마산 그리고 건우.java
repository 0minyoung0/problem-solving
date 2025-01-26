import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        final int INF = 1_000_000_000;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken()) - 1;

        List<int[]>[] edges = new List[V];
        for (int i = 0; i < V; i++) {
            edges[i] = new ArrayList<>();
        }
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new int[] { c, b });
            edges[b].add(new int[] { c, a });
        }

        int[] dis = new int[V];
        Arrays.fill(dis, INF);
        dis[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        pq.offer(new int[] { 0, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cDis = cur[0];
            int cIdx = cur[1];

            if (cDis != dis[cIdx])
                continue;

            for (int[] edge : edges[cIdx]) {
                int eLength = edge[0];
                int eNextNode = edge[1];

                if (cDis + eLength >= dis[eNextNode])
                    continue;
                pq.offer(new int[] { cDis + eLength, eNextNode });
                dis[eNextNode] = cDis + eLength;
            }
        }

        int shortestDis = dis[V - 1];

        Arrays.fill(dis, INF);
        dis[P] = 0;

        pq.offer(new int[] { 0, P });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cDis = cur[0];
            int cIdx = cur[1];

            if (cDis != dis[cIdx])
                continue;

            for (int[] edge : edges[cIdx]) {
                int eLength = edge[0];
                int eNextNode = edge[1];

                if (cDis + eLength >= dis[eNextNode])
                    continue;
                pq.offer(new int[] { cDis + eLength, eNextNode });
                dis[eNextNode] = cDis + eLength;
            }
        }

        if (shortestDis == dis[0] + dis[V - 1])
            System.out.println("SAVE HIM");
        else
            System.out.println("GOOD BYE");
    }
}
