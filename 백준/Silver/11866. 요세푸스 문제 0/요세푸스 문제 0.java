import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		System.out.print("<");
		for (int i=0; i<N-1; i++) {
			for (int j=0; j<K-1; j++) {
				q.offer(q.poll());
			}
			System.out.print(q.poll() + ", ");
		}
		System.out.print(q.poll() + ">");
	}
}
