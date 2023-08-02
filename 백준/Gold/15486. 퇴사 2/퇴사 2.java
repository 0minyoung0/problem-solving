import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 전체 날짜 수
        int N = Integer.parseInt(br.readLine());
        // 상담을 완료하는데 걸리는 기간
        int[] T = new int[N + 1];
        // 상담을 했을 때 받을 수 있는 금액
        int[] P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 특정 일자부터 N일자 까지 상담 일정에서의 최대 수익
        int[] profit = new int[N + 2];
        for (int i = N; i >= 1; i--) {

            // 해당 날짜에 상담을 시작하면 N+1일자에 퇴사를 못하는 경우
            if (i + T[i] > N + 1) {
                profit[i] = profit[i + 1];
            }

            // 해당 날짜에 상담을 안한 경우와 상담을 한 경우 중 큰 수익 값 저장
            else {
                profit[i] = Math.max(profit[i + 1], P[i] + profit[i + T[i]]);
            }
        }
        
        // 최대 수익 출력
        System.out.println(profit[1]);
    }
}