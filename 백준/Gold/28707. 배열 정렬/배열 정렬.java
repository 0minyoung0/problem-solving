import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int start = 0;
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken()) - 1;
            start *= 10;
            start += A[i];
        }

        int[] copy = A.clone();
        Arrays.parallelSort(copy);
        int end = 0;
        for (int i = 0; i < N; i++) {
            end *= 10;
            end += copy[i];
        }

        int M = Integer.parseInt(br.readLine());

        int[][] lrc = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                lrc[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] E = new int[N + 1];
        E[N] = 1;
        for (int i = N - 1; i >= 1; i--) {
            E[i] = E[i + 1] * 10;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        pq.offer(new int[] { start, 0 });
        HashMap<Integer, Integer> distMap = new HashMap<>();
        distMap.put(start, 0);

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if (curNode == end) {
                System.out.println(distMap.get(end));
                return;
            }

            if (distMap.get(curNode) != curDist) {
                continue;
            }

            for (int i = 0; i < M; i++) {
                int l = lrc[i][0];
                int r = lrc[i][1];
                int c = lrc[i][2];

                int a = curNode / E[l] % 10;
                int b = curNode / E[r] % 10;
                int nxtNode = curNode - (a - b) * E[l] - (b - a) * E[r];
                int nxtDist = curDist + c;

                if (distMap.getOrDefault(nxtNode, Integer.MAX_VALUE) <= nxtDist) {
                    continue;
                }

                pq.offer(new int[] { nxtNode, nxtDist });
                distMap.put(nxtNode, nxtDist);
            }
        }

        System.out.println(-1);
    }
}
