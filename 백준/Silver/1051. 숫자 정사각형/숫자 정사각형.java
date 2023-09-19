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
        int[][] nums = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                nums[i][j] = s.charAt(j) - '0';
            }
        }
        for (int length = Math.max(N, M); length >= 1; length--) {
            for (int i = 0; i <= N - length; i++) {
                for (int j = 0; j <= M - length; j++) {
                    if (nums[i][j] != nums[i + length - 1][j]
                            || nums[i][j] != nums[i][j + length - 1]
                            || nums[i][j] != nums[i + length - 1][j + length - 1]) {
                        continue;
                    }
                    System.out.print(length * length);
                    return;
                }
            }
        }
    }
}

