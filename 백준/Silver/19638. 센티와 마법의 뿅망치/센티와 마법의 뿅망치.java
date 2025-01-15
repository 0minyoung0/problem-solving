import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (N-- > 0) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int count = 0;
        while (count < T) {
            int top = pq.peek();
            if (top < H) {
                break;
            }
            pq.poll();
            pq.offer(top != 1 ? top / 2 : 1);
            count++;
        }

        if (pq.peek() < H) {
            System.out.println("YES\n" + count);
        } else {
            System.out.println("NO\n" + pq.peek());
        }
    }
}
