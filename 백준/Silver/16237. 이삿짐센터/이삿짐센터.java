import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int ans = E;

        ans += D;
        A -= Math.min(A, D);

        ans += C;
        int temp = Math.min(B, C);
        C -= temp;
        B -= temp;
        A -= Math.min(A, C * 2);

        ans += B / 2;
        A -= Math.min(B / 2, A);
        if (B % 2 == 1) {
            ans += 1;
            A -= Math.min(A, 3);
        }

        ans += (A / 5) + (A % 5 == 0 ? 0 : 1);
        System.out.println(ans);
    }
}
