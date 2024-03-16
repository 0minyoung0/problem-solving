import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 게임판의 크기
        int N = Integer.parseInt(br.readLine());

        // 게임판 위의 상태
        int[][] plate = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                plate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 경로의 개수를 저장할 배열
        long[][] ans = new long[N][N];
        ans[0][0] = 1;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (i == N - 1 && j == N - 1) break;
                if (i + plate[i][j] < N) ans[i + plate[i][j]][j] += ans[i][j];
                if (j + plate[i][j] < N) ans[i][j + plate[i][j]] += ans[i][j];
            }
        }

        // 답 출력
        System.out.println(ans[N-1][N-1]);
    }
}