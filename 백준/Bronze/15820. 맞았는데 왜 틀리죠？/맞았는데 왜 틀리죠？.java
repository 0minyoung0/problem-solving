import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());

        int[] ans = new int[2];
        while (s1-- > 0) {
            st = new StringTokenizer(br.readLine());
            ans[0] = Integer.parseInt(st.nextToken());
            ans[1] = Integer.parseInt(st.nextToken());
            if (ans[0] != ans[1]) {
                System.out.println("Wrong Answer");
                return;
            }
        }
        while (s2-- > 0) {
            st = new StringTokenizer(br.readLine());
            ans[0] = Integer.parseInt(st.nextToken());
            ans[1] = Integer.parseInt(st.nextToken());
            if (ans[0] != ans[1]) {
                System.out.println("Why Wrong!!!");
                return;
            }
        }
        System.out.println("Accepted");
    }
}
