import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int ans = 0;

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (st.nextToken().equals("1")) {
                ans += a[i];
                a[i] = -a[i];
            }
        }

        int[] max = new int[N];
        max[0] = a[0];

        for (int i = 1; i < N; i++) {
            max[i] = Math.max(max[i - 1] + a[i], a[i]);
        }

        int maxDiff = -5000;
        for (int i = 0; i < N; i++) {
            if (maxDiff < max[i]) {
                maxDiff = max[i];
            }
        }

        System.out.println(ans + maxDiff);
    }
}