import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
            System.out.print(0);
            return;
        } else if (n > 0 || Math.abs(n) % 2 == 1) {
            System.out.println(1);
        } else {
            System.out.println(-1);
        }

        int[] a = new int[Math.abs(n) + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= Math.abs(n); i++) {
            a[i] = (a[i - 1] + a[i - 2]) % 1_000_000_000;
        }
        System.out.print(a[Math.abs(n)]);
    }
}