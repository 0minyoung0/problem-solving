import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final static int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 집의 수, 질문의 수
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // 길의 정보, i번까지만 마실 수 있을때의 데이터 : data[i]
        int[][][] data = new int[N + 1][N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                data[0][i][j] = Integer.parseInt(st.nextToken());
                if (i != j && data[0][i][j] == 0) {
                    data[0][i][j] = INF;
                }
            }
        }

        // 플로이드 워셜
        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    data[k][i][j] = Math.min(data[k-1][i][j], data[k-1][i][k] + data[k-1][k][j]);
                }
            }
        }

        // 답 출력
        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(data[C-1][s][e] == INF ? -1 : data[C-1][s][e]).append("\n");
        }
        System.out.print(sb);
    }
}