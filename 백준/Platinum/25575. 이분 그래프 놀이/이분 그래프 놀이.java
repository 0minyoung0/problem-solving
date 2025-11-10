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
            int k = Integer.parseInt(st.nextToken());

            int[] x = new int[n];
            int[] y = new int[m];

            int[][] edges = new int[k][];
            for (int idx = 0; idx < k; idx++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken()) - 1;
                int j = Integer.parseInt(st.nextToken()) - 1;
                x[i]++;
                y[j]++;
                edges[idx] = new int[] { i, j };
            }
            int[] sortedX = x.clone();
            Arrays.sort(sortedX);
            int[] sortedY = y.clone();
            Arrays.sort(sortedY);

            HashMap<Integer, Integer> xCost = new HashMap<>();
            HashMap<Integer, Integer> yCost = new HashMap<>();

            int ans1 = 0;
            for (int idx = n - 1; idx >= 0; idx--) {
                int v = idx + 1;
                ans1 += sortedX[idx] * v;
                xCost.put(sortedX[idx], v);
            }
            for (int idx = m - 1; idx >= 0; idx--) {
                int w = idx + 1;
                ans1 += sortedY[idx] * w;
                yCost.put(sortedY[idx], w);
            }

            int ans2 = 0;
            for (int[] e : edges) {
                ans2 = Math.max(ans2, ans1 - xCost.get(x[e[0]]) - yCost.get(y[e[1]]));
            }

            sb.append(ans1).append(' ').append(ans2).append('\n');
        }
        System.out.print(sb);
    }
}
