import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] numsDigit = new int[10];
        numsDigit[0] = Integer.parseInt("1110111", 2);
        numsDigit[1] = Integer.parseInt("0010010", 2);
        numsDigit[2] = Integer.parseInt("1011101", 2);
        numsDigit[3] = Integer.parseInt("1011011", 2);
        numsDigit[4] = Integer.parseInt("0111010", 2);
        numsDigit[5] = Integer.parseInt("1101011", 2);
        numsDigit[6] = Integer.parseInt("1101111", 2);
        numsDigit[7] = Integer.parseInt("1010010", 2);
        numsDigit[8] = Integer.parseInt("1111111", 2);
        numsDigit[9] = Integer.parseInt("1111011", 2);

        int[][] cost = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                int c = numsDigit[i] ^ numsDigit[j];
                while (c > 0) {
                    if (c % 2 == 1) {
                        cost[i][j]++;
                        cost[j][i]++;
                    }
                    c /= 2;
                }
            }
        }

        int ans = 0;
        TRY: for (int i = 1; i <= N; i++) {
            if (i == X) {
                continue;
            }
            int start = X;
            int end = i;
            int temp = 0;
            for (int j = 0; j < K; j++) {
                temp += cost[start % 10][end % 10];
                start /= 10;
                end /= 10;
                if (temp > P) {
                    continue TRY;
                }
            }
            ans++;
        }
        System.out.println(ans);
    }
}
