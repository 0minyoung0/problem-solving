import java.io.*;
import java.util.*;

public class Main {
	static HashMap<Integer, Long> map = new HashMap<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		map.put(0, (long) 0);
		map.put(1, (long) 1);
		
		System.out.println(fibo(n));
	}
	private static long fibo(int k) {
		if (map.containsKey(k)) {
			return map.get(k);
		}
		
		if (!map.containsKey(k-1)) {
			map.put(k-1, fibo(k-1));
		}
		
		return map.get(k-1) + map.get(k-2);
	}
}
