import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (s >= 1000)
                ans++;
            else if (c >= 1600)
                ans++;
            else if (a >= 1500)
                ans++;
            else if (r > 0 && r <= 30)
                ans++;
        }
        System.out.println(ans);
    }
}
