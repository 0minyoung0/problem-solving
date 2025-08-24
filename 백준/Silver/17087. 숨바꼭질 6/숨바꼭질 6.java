import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] diff = new int[N];
        for (int i = 0; i < N; i++) {
            diff[i] = Math.abs(Integer.parseInt(st.nextToken()) - S);
        }

        int ans = diff[0];
        for (int i = 1; i < N; i++) {
            ans = GCD(ans, diff[i]);
        }
        System.out.println(ans);
    }

    private static int GCD(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);

        if (max % min == 0) {
            return min;
        }
        return GCD(min, max % min);
    }
}