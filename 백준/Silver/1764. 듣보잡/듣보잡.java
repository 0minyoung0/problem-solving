import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashSet<String> hs = new HashSet<>();
		while (n-- > 0) {
			hs.add(br.readLine());
		}
		
		List<String> list = new ArrayList<>();
		while (m-- > 0) {
			String temp = br.readLine();
			if (hs.contains(temp)) list.add(temp);
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for (String s : list) {
			System.out.println(s);
		}
	}
}