import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] row = new int[n];
            int[] col = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int a = Integer.parseInt(st.nextToken());
                    row[i] += a;
                    col[j] += a;
                }
            }

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(st.nextToken()) - 1;
                int c1 = Integer.parseInt(st.nextToken()) - 1;
                int r2 = Integer.parseInt(st.nextToken()) - 1;
                int c2 = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken());

                for (int i = r1; i <= r2; i++) {
                    row[i] += v * (c2 - c1 + 1);
                }
                for (int i = c1; i <= c2; i++) {
                    col[i] += v * (r2 - r1 + 1);
                }
            }

            for (int i = 0; i < n; i++) {
                sb.append(row[i]).append(' ');
            }
            sb.append('\n');
            for (int i = 0; i < n; i++) {
                sb.append(col[i]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}