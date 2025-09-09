import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = st.nextToken();
            if (i < N - 2) {
                continue;
            }
            if (i == N - 2) {
                ans -= Integer.parseInt(str);
            }
            if (i == N - 1) {
                ans += 2 * Integer.parseInt(str);
            }
        }
        System.out.println(ans);
    }
}