import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열의 크기
        int N = Integer.parseInt(br.readLine());

        // 찾고자 하는 인덱스
        int k = Integer.parseInt(br.readLine());

        // 이분 탐색을 위한 시작, 종료 값
        long s = 1;
        long e = (long)N * N + 1;

        // 이분 탐색
        while (s < e) {
            long mid = (s + e) / 2;

            // mid보다 작은 값의 수를 저장
            long cnt1 = 0;
            // mid보다 작거나 같은 값의 수를 저장
            long cnt2 = 0;

            for (int i = 1; i <= N; i++) {
                cnt1 += Math.min((mid - 1) / i, N);
                cnt2 += Math.min(mid / i, N);
            }

            if (cnt1 < k && k <= cnt2) {
                System.out.println(mid);
                return;
            }

            if (k <= cnt1) {
                e = mid;
            } else { // cnt2 < k
                s = mid + 1;
            }
        }

    }
}