import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		TreeMap<Integer, List<String>> map = new TreeMap<>();
		
		int N = Integer.parseInt(br.readLine());
		
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			if (!map.containsKey(age)) {
				List<String> temp = new ArrayList<>();
				temp.add(name);
				map.put(age, temp);
			}
			else {
				map.get(age).add(name);
			}
		}
		
		while (!map.isEmpty()) {
			int age = map.firstKey();
			List<String> temp = map.get(age);
			for (String s : temp) {
				System.out.println(age + " " + s);
			}
			map.remove(age);
		}
		
	}
}
