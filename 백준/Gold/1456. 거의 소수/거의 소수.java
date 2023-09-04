import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        List<Integer> prime = new ArrayList<>();
        boolean[] notPrime = new boolean[10000000];
        for (int i = 2; i < 10000000; i++) {
            if (notPrime[i]) {
                continue;
            }
            prime.add(i);
            for (int j = 2 * i; j < 10000000; j += i) {
                notPrime[j] = true;
            }
        }

        long ans = 0;
        for (int p : prime) {
            long temp = (long) p * p;
            while (temp <= B) {
                if (temp >= A) {
                    ans++;
                }
                if (temp > Long.MAX_VALUE / p) {
                    break;
                }
                temp *= p;
            }
        }
        System.out.print(ans);
    }
}