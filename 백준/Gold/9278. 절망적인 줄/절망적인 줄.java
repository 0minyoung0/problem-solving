import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {
            char[] arr = input.toCharArray();
            int length = arr.length;

            int[][] dp = new int[length + 1][length + 1];
            dp[0][0] = 1;

            for (int i = 1; i <= length; i++) {
                char c = arr[i - 1];
                if (c == '(' || c == '.') {
                    // 기존 데이터에 +1
                    for (int j = 1; j <= i; j++) {
                        dp[i][j] += dp[i - 1][j - 1];
                        dp[i][j] %= 1_000_000;
                    }
                }
                if (c == ')' || c == '.') {
                    // 기존 데이터에 -1
                    for (int j = 0; j < i; j++) {
                        dp[i][j] += dp[i - 1][j + 1];
                        dp[i][j] %= 1_000_000;
                    }
                }
            }
            System.out.println(dp[length][0]);
        }
    }
}