import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        long[] ans = new long[1_000_001];
        for (int i=1; i<=1_000_000; i++) {
            for (int j=i; j<=1_000_000; j+=i) {
                ans[j] += i;
            }
            ans[i] += ans[i-1];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(ans[N]).append("\n");
        }
        System.out.print(sb);
    }
}
