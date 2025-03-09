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

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.parallelSort(b);

            long c = 0;
            for (int i = 0; i < n; i++) {
                int idx = Arrays.binarySearch(b, a[i]);
                if (idx < 0) {
                    if (idx == -1) {
                        idx = 0;
                    } else if (idx == -m - 1) {
                        idx = m - 1;
                    } else {
                        int left = b[-idx - 2];
                        int right = b[-idx - 1];
                        if (Math.abs(a[i] - left) <= Math.abs(a[i] - right)) {
                            idx = -idx - 2;
                        } else {
                            idx = -idx - 1;
                        }
                    }
                }
                c += b[idx];
            }
            sb.append(c).append('\n');
        }
        System.out.print(sb);
    }
}