import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        List<Integer> s = new ArrayList<>();
        for (int i=0; i<N; i++) {
            s.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(s);

        int ans = 0;
        for (int i=0; i<N; i++) {
            int cur = s.get(i);
            ans = (ans + mul(cur, pow(i))) % 1_000_000_007;
            ans = (ans - mul(cur, pow(N - 1 - i)) + 1_000_000_007) % 1_000_000_007;
        }

        System.out.println(ans);
    }
    private static int pow(int p) {
        if (p == 0) return 1;
        int sqrt = pow(p/2);
        if (p % 2 == 0) return mul(sqrt, sqrt);
        else return mul(2, mul(sqrt, sqrt));
    }
    private static int mul(int a, int b) {
        return (int)((long)a * (long)b % 1_000_000_007);
    }
}