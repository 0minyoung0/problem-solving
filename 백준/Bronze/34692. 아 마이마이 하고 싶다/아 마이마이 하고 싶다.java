import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            pq.offer(0);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            int time = pq.poll() + t;
            pq.offer(time);
        }

        int aTime = pq.peek();

        if (aTime <= K) {
            System.out.println("WAIT");
        } else {
            System.out.println("GO");
        }
    }
}
