import java.io.*;
import java.util.*;

public class Main {
	static HashMap<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 종료 조건
			if (a == -1 && b == -1 && c == -1) return;
			
			// w(a, b, c) 출력
			System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
		}
	}
	
	private static int w(int a, int b, int c) {
		
		if (a <= 0 || b <= 0 || c <= 0) return 1;
		if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);
		
		// 계산한 적 있는 값이면 그 값 리턴
		if (map.containsKey(a*101*101+b*101+c)) {
			return map.get(a*101*101+b*101+c);
		}
		
		if (a < b && b < c) {
			int result = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
			map.put(a*101*101+b*101+c, result);
			return result;
		}
		
		int result = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		map.put(a*101*101+b*101+c, result);
		return result;
	}
}