import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<int[]> bucketList = new ArrayList<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            bucketList.add(new int[] { g, x });
        }

        bucketList.sort(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int ans = 0;
        int sum = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int[] bucket : bucketList) {
            q.offer(bucket);
            int g = bucket[0];
            sum += g;
            int x = bucket[1];
            while (q.peek()[1] < x - 2 * K) {
                int iceCount = q.poll()[0];
                sum -= iceCount;
            }
            if (ans < sum) {
                ans = sum;
            }
        }
        System.out.println(ans);
    }
}