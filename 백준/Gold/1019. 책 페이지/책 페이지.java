import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] ans = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[10];
        int digit = 1;
        int pre = 0;
        while (N != 0) {
            int cur = N % 10;
            N /= 10;
            for (int i=0; i<cur; i++) cnt[i] += (N + 1) * digit;
            cnt[cur] += N * digit + 1 + pre;
            for (int i=cur+1; i<10; i++) cnt[i] += N * digit;
            cnt[0] -= digit;

            pre += cur * digit;
            digit *= 10;
        }
        for (int i=0; i<10; i++) {
            System.out.print(cnt[i] + " ");
        }
    }
}