import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        HashMap<Character, Integer> orangeMap = new HashMap<>();
        orangeMap.put('o', 0);
        orangeMap.put('r', 1);
        orangeMap.put('a', 2);
        orangeMap.put('n', 3);
        orangeMap.put('g', 4);
        orangeMap.put('e', 5);
        char[] orangeArr = { 'o', 'r', 'a', 'n', 'g', 'e' };

        int[][] dp = new int[7][str.length + 1];
        for (int i = 0; i < 6; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = str.length - 1; i >= 0; i--) {
            char c = str[i];
            Integer idx = orangeMap.get(c);

            // i번째 글자를 안쓰는 경우
            for (int j = 0; j < 6; j++) {
                dp[j][i] = dp[j][i + 1];
            }

            if (idx != null) {
                // i번째 글자를 쓰는 경우
                if (dp[idx][i + 1] != -1) {
                    dp[idx][i] = dp[idx][i + 1] + 1;
                }
                if (dp[idx + 1][i + 1] != -1) {
                    dp[idx][i] = Math.max(dp[idx][i], dp[idx + 1][i + 1] + 1);
                }
            }
        }

        if (dp[0][0] == -1) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[0][0]).append('\n').append('o');
        int curI = 0;
        int curJ = 0;

        while (curI < 6 && curJ < str.length - 1) {
            if (dp[curI][curJ + 1] == dp[curI][curJ]) {
                curJ++;
            } else if (dp[curI][curJ + 1] == dp[curI][curJ] - 1) {
                sb.append(orangeArr[curI]);
                curJ++;
            } else if (dp[curI + 1][curJ + 1] == dp[curI][curJ] - 1) {
                curI++;
                if (curI == 6) {
                    break;
                }
                sb.append(orangeArr[curI]);
                curJ++;
            } else {
                break;
            }
        }

        System.out.println(sb);
    }
}