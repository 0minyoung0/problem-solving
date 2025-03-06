import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[] D = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                D[i] = Integer.parseInt(st.nextToken());
            }

            String S = br.readLine();

            int[] R = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                R[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 1;
            for (int i = N - 1; i >= 0; i--) {
                char oper = S.charAt(i);
                if (oper == '+') {
                    ans -= R[i];
                } else {
                    ans = (int) Math.ceil((double) ans / R[i]);
                }
                if (ans < 1) {
                    ans = 1;
                }

                ans += D[i];
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}