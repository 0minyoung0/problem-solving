import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		// V-A까지 걸리는 날짜 + 1일
		int ans = (V - A) / (A - B);
		if ((V - A) % (A - B) != 0) ans++;
		System.out.println(ans + 1);
		
	}
}