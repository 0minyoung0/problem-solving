import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int ans = 0;
        int thumb = 200000;
        int pinky = 1;
        while (N-- > 0) {
            int a = Integer.parseInt(st.nextToken());
            if (thumb > a) thumb = a;
            if (pinky < a) pinky = a;
            if (pinky - thumb >= K) {
                ans++;
                thumb = pinky = a;
            }
        }
        System.out.println(ans);
    }
}
