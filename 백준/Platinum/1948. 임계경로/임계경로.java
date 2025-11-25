import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<int[]>[] fEdges = new List[n + 1];
        List<int[]>[] bEdges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            fEdges[i] = new ArrayList<>();
            bEdges[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // 거리 범위가 안주어져서 그냥 int로 품
            int d = Integer.parseInt(st.nextToken());
            fEdges[s].add(new int[] { e, d });
            bEdges[e].add(new int[] { s, d });
            indegree[e]++;
        }

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];

        Queue<int[]> fQueue = new ArrayDeque<>();
        fQueue.offer(new int[] { startNode, 0 });
        while (!fQueue.isEmpty()) {
            int[] cur = fQueue.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            for (int[] edge : fEdges[curNode]) {
                int nextNode = edge[0];
                int nextDist = curDist + edge[1];

                if (dist[nextNode] < nextDist) {
                    dist[nextNode] = nextDist;
                }

                if (--indegree[nextNode] == 0) {
                    fQueue.offer(new int[] { nextNode, dist[nextNode] });
                }
            }
        }
        sb.append(dist[endNode]).append('\n');

        Arrays.fill(indegree, 1);
        int count = 0;

        Queue<Integer> bQueue = new ArrayDeque<>();
        bQueue.offer(endNode);
        while (!bQueue.isEmpty()) {
            int curNode = bQueue.poll();
            int curDist = dist[curNode];

            for (int[] edge : bEdges[curNode]) {
                int prevNode = edge[0];
                int prevDist = curDist - edge[1];

                if (dist[prevNode] != prevDist) {
                    continue;
                }

                count++;

                if (--indegree[prevNode] == 0) {
                    bQueue.offer(prevNode);
                }
            }
        }
        sb.append(count);

        System.out.print(sb);
    }
}
