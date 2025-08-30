import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] e = new int[(1 << (k + 1))];
        int ans = 0;
        for (int i = 2; i < (1 << (k + 1)); i++) {
            e[i] = Integer.parseInt(st.nextToken());
            ans += e[i];
        }
        for (int i = k; i > 0; i--) {
            int start = 1 << i;
            int end = 1 << (i + 1);
            for (int j = start; j < end; j += 2) {
                ans += Math.abs(e[j] - e[j + 1]);
                e[j / 2] += Math.max(e[j], e[j + 1]);
            }
        }

        System.out.println(ans);
    }
}