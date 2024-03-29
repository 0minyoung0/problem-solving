import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<int[]> ho = new ArrayList<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int ho1 = Integer.parseInt(st.nextToken());
            int ho2 = Integer.parseInt(st.nextToken());
            ho.add(new int[] {Math.min(ho1, ho2), Math.max(ho1, ho2)});
        }
        Collections.sort(ho, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        int d = Integer.parseInt(br.readLine());

        int ans = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        for (int i=0; i<n; i++) {
            pq.offer(ho.get(i));
            while (!pq.isEmpty() && pq.peek()[0] < ho.get(i)[1] - d) {
                pq.poll();
            }
            if (ans < pq.size()) ans = pq.size();
        }

        System.out.println(ans);
    }
}