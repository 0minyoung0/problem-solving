import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (!possible(N, K)) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[N][N];
        int rest = K;
        if (N % 2 == 1 && K % 2 == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if ((i + j) % 2 == 1) {
                        arr[i][j] += 1;
                        rest--;
                    }
                }
            }
            int temp = (rest / (N * N)) / 2 * 2;
            rest -= temp * N * N;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] += temp;
                    if (rest > 0 && (i + j) % 2 == 0) {
                        arr[i][j] += 2;
                        rest -= 2;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (rest > 0 && (i + j) % 2 == 1) {
                        arr[i][j] += 2;
                        rest -= 2;
                    }
                }
            }
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if ((i + j) % 2 == 0) {
                        arr[i][j] += 1;
                        rest--;
                    }
                }
            }
            int temp = (rest / (N * N)) / 2 * 2;
            rest -= temp * N * N;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] += temp;
                    if (rest > 0 && (i + j) % 2 == 1) {
                        arr[i][j] += 2;
                        rest -= 2;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (rest > 0 && (i + j) % 2 == 0) {
                        arr[i][j] += 2;
                        rest -= 2;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
                if (j != N - 1) {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static boolean possible(int N, int K) {
        if (N % 2 == 0 && K % 2 == 1) {
            return false;
        }
        if (N * N / 2 > K) {
            return false;
        }
        return true;
    }
}
