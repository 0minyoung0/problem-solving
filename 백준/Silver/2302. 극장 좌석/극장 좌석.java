import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // dp 계산
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 좌석의 개수
        int N = Integer.parseInt(br.readLine());
        // 고정석의 개수
        int M = Integer.parseInt(br.readLine());

        // 답을 저장할 변수
        int ans = 1;

        // 이전 고정석 번호를 저장하기 위한 변수
        int preSeat = 0;
        while (M-- > 0) {
            int seat = Integer.parseInt(br.readLine());
            ans *= dp[seat - preSeat - 1];
            preSeat = seat;
        }
        ans *= dp[N - preSeat];

        // 답 출력
        System.out.print(ans);
    }
}