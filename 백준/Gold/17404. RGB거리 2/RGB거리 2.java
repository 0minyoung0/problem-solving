import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][][] cost = new int[N][3][3];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                cost[0][i][j] = 10000;
            }
        }
        cost[0][0][0] = Integer.parseInt(st.nextToken());
        cost[0][1][1] = Integer.parseInt(st.nextToken());
        cost[0][2][2] = Integer.parseInt(st.nextToken());

        for (int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] costRow = new int[3];
            costRow[0] = Integer.parseInt(st.nextToken());
            costRow[1] = Integer.parseInt(st.nextToken());
            costRow[2] = Integer.parseInt(st.nextToken());

            for (int j=0; j<3; j++) {
                for (int k=0; k<3; k++) {
                    cost[i][j][k] = Math.min(cost[i-1][j][(k+1)%3], cost[i-1][j][(k+2)%3]) + costRow[k];
                }
            }

        }

        int ans = 1000000;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i == j) continue;
                if (ans > cost[N-1][i][j]) ans = cost[N-1][i][j];
            }
        }
        System.out.print(ans);

    }
}
