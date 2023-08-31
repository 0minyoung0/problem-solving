import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        int[][] dp = new int[s1.length + 1][s2.length + 1];

        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] != s2[j - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        int row = s1.length;
        int col = s2.length;
        System.out.println(dp[row][col]);

        StringBuilder sb = new StringBuilder();
        while (dp[row][col] > 0) {
            if (dp[row - 1][col] == dp[row][col]) {
                row--;
            } else if (dp[row][col - 1] == dp[row][col]) {
                col--;
            } else {
                sb.append(s1[row-1]);
                row--;
                col--;
            }
        }
        System.out.println(sb.reverse());
    }
}
