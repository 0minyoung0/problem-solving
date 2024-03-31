import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] combi = new int[53][53];
        for (int i=0; i<=52; i++) {
            combi[i][0] = 1;
        }
        for (int i=1; i<=52; i++) {
            for (int j=1; j<=i; j++) {
                combi[i][j] = mod10007(combi[i-1][j-1] + combi[i-1][j]);
            }
        }

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i=1; i<=N/4; i++) {
            if (i % 2 == 1) ans = mod10007(ans + combi[13][i] * combi[52-4*i][N-4*i]);
            else ans = mod10007(ans - combi[13][i] * combi[52-4*i][N-4*i]);
        }
        System.out.println(ans);
    }
    private static int mod10007(int x) {
        return ((x % 10_007) + 10_007) % 10_007;
    }
}