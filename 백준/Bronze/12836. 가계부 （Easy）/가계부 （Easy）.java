import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        long[] money = new long[N + 1];
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("1")) {
                int p = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                money[p] += x;
            } else {
                long ans = 0;
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                for (int i = p; i <= q; i++) {
                    ans += money[i];
                }
                System.out.println(ans);
            }
        }
    }
}
