import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 주사위의 수
        int M = Integer.parseInt(br.readLine());

        // 답을 저장할 변수
        long ans = 0;

        // i번째 주사위의 값 계산
        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            long N = Integer.parseInt(st.nextToken());
            long S = Integer.parseInt(st.nextToken());
            if (S % N == 0) ans += S / N;
            else {
                long GCD = GCD(Math.max(S, N), Math.min(S, N));
                ans = (ans + (long)(S / GCD) * pow(N / GCD, 1000000005)) % 1000000007;
            }
        }

        // 답 출력
        System.out.println(ans);
    }
    private static long GCD(long a, long b) {
        if (a % b == 0) return b;
        return GCD(b, a % b);
    }
    private static long pow(long n, long k) {
        if (k == 1) return n;
        long sq = pow(n, k/2);
        if (k % 2 == 0) return sq * sq % 1000000007;
        else return sq * sq % 1000000007 * n % 1000000007;
    }
}
