import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] edge = new int[2 * M - 1];
        Arrays.fill(edge, 1);

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int c0 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            for (int i = c0; i < c0 + c1; i++) {
                edge[i] += 1;
            }
            for (int i = c0 + c1; i < 2 * M - 1; i++) {
                edge[i] += 2;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (i != 0) sb.append(' ');
            sb.append(edge[i + M - 1]);
        }
        for (int i = 1; i < M; i++) {
            sb.append('\n').append(edge[M - 1 - i]);
            for (int j = 1; j < M; j++) {
                sb.append(' ').append(edge[M - 1 + j]);
            }
        }
        System.out.println(sb);
    }
}
