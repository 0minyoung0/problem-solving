import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 카드의 개수
        int n = Integer.parseInt(st.nextToken());
        // 카드 합체를 하는 횟수
        int m = Integer.parseInt(st.nextToken());

        // 카드에 적힌 숫자를 PriorityQueue에 저장
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        // 카드 합체 진행
        while (m-- > 0) {
            long num = pq.poll() + pq.poll();
            pq.offer(num);
            pq.offer(num);
        }

        // 답 출력
        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        System.out.print(ans);
    }
}
