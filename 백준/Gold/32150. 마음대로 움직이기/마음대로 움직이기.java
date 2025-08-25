import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        int[] A = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int key = Arrays.binarySearch(A, P);
            int insertionPoint = -key - 1;

            int min = P - T;
            if (insertionPoint > 0) {
                min = Math.max(min, A[insertionPoint - 1] + 1);
                if (Math.abs(P - T - min) % 2 == 1) {
                    min++;
                }
            }
            int max = P + T;
            if (insertionPoint < K) {
                max = Math.min(max, A[insertionPoint] - 1);
                if (Math.abs(P + T + min) % 2 == 1) {
                    max--;
                }
            }

            sb.append((max - min) / 2 + 1).append('\n');
        }
        System.out.print(sb);
    }
}