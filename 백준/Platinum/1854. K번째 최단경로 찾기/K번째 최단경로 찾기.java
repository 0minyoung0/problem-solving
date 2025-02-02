import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<int[]>[] edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new int[] {c, b});
        }

        PriorityQueue<Integer>[] dis = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            dis[i] = new PriorityQueue<>(Collections.reverseOrder());
        }
        dis[1].offer(0);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        pq.offer(new int[] {0, 1});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curCost = cur[0];
            int curIdx = cur[1];

            for (int[] next : edges[curIdx]) {
                int nextCost = curCost + next[0];
                int nextIdx = next[1];

                // 이미 k개가 있고, cost가 peek()한 값보다 크거나 같은 경우 추가할 필요 없음
                if (dis[nextIdx].size() == k && dis[nextIdx].peek() <= nextCost) continue;

                // 그 외의 경우에는 추가하기
                if (dis[nextIdx].size() == k) dis[nextIdx].poll();
                dis[nextIdx].offer(nextCost);
                pq.offer(new int[] {nextCost, nextIdx});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dis[i].size() < k) sb.append("-1\n");
            else sb.append(dis[i].peek()).append('\n');
        }
        System.out.print(sb);
    }
}
