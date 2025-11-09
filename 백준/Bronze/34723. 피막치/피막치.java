import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int X = Integer.parseInt(br.readLine());

        int ans = Integer.MAX_VALUE;
        for (int p = 1; p <= P; p++) {
            for (int m = 1; m <= M; m++) {
                for (int c = 1; c <= C; c++) {
                    int diff = Math.abs((p + m) * (m + c) - X);
                    if (ans > diff) {
                        ans = diff;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
