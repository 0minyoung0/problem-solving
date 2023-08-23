import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1000000 이하의 소수 구하기
        boolean[] notPrime = new boolean[1000000];
        for (int i = 2; i < 1000000; i++) {
            if (notPrime[i]) {
                continue;
            }
            for (int j = 2 * i; j < 1000000; j += i) {
                notPrime[j] = true;
            }
        }

        // 소수를 HashSet에 저장
        Set<Integer> primeSet = new HashSet<>();
        for (int i = 2; i < 1000000; i++) {
            if (!notPrime[i]) {
                primeSet.add(i);
            }
        }

        // 테스트 케이스 별로 실행
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int ans = 0;
            for (int p : primeSet) {
                if (primeSet.contains(N - p)) {
                    ans++;
                }
            }
            System.out.println((ans + 1) / 2);
        }
    }
}
