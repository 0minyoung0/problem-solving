import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<List<int[]>> edge = new ArrayList<>();
        for (int i = 0; i < N * N; i++) {
            edge.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N - 1; j++) {
                int roadLength = Integer.parseInt(st.nextToken());
                int x = i * N + j;
                int y = x + 1;
                edge.get(x).add(new int[] { roadLength, 0, y });
                edge.get(y).add(new int[] { roadLength, 0, x });
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int roadLength = Integer.parseInt(st.nextToken());
                int x = i * N + j;
                int y = x + N;
                edge.get(x).add(new int[] { roadLength, 1, y });
                edge.get(y).add(new int[] { roadLength, 1, x });
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N - 1; j++) {
            int roadLength = Integer.parseInt(st.nextToken());
            int x = (N - 1) * N + j;
            int y = x + 1;
            edge.get(x).add(new int[] { roadLength, 0, y });
            edge.get(y).add(new int[] { roadLength, 0, x });
        }

        int[] dis = new int[N * N];
        int[] fCount = new int[N * N];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        fCount[0] = -1;

        int maxFivotCount = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                }
                return o1[2] - o2[2];
            }
        });

        // 현재 정점까지 거리, 현재 정점까지 피봇턴 횟수, 현재 정점에 도달하기 직전 피봇턴 방향, 현재 정점의 위치
        pq.offer(new int[] { 0, -1, -1, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[0] != dis[cur[3]] || cur[1] != fCount[cur[3]]) {
                continue;
            }

            for (int[] e : edge.get(cur[3])) {
                int newDist = cur[0] + e[0];
                int newFivotCount = cur[1] + (cur[2] != e[1] ? 1 : 0);

                if (newDist > dis[e[2]] || (newDist == dis[e[2]] && newFivotCount < fCount[e[2]])) {
                    continue;
                }

                dis[e[2]] = newDist;
                fCount[e[2]] = newFivotCount;

                if (e[2] == N * N - 1) {
                    maxFivotCount = Math.max(maxFivotCount, newFivotCount);
                } else {
                    pq.offer(new int[] { newDist, newFivotCount, e[1], e[2] });
                }
            }
        }

        System.out.println(dis[N * N - 1] + " " + fCount[N * N - 1]);

    }
}