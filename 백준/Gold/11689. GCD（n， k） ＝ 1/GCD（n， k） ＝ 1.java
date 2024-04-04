import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long ans = n;

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                ans -= ans / i;
                while (n % i == 0) n /= i;
            }
            if (n == 1) break;
        }
        if (n != 1) ans -= ans / n;

        System.out.println(ans);
    }
}