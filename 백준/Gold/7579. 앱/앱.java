import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] m = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        int[] c = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        // 특정 앱까지 고려했을때 특정 비용으로 확보가능한 메모리 구하기
        int[] dp = new int[10001];
        for (int i=0; i<N; i++) {
            for (int j=10000; j>=c[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - c[i]] + m[i]);
            }
        }

        // M바이트를 확보하기 위한 최소 비용 계산
        for (int i=0; i<=10000; i++) {
            if (dp[i] >= M) {
                System.out.print(i);
                return;
            }
        }
    }
}
