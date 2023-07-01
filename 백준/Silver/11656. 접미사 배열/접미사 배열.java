import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String S = br.readLine();
		
		List<String> list = new ArrayList<>();
	
		for (int beginIndex=0; beginIndex<S.length(); beginIndex++) {
			list.add(S.substring(beginIndex));
		}
		
		Collections.sort(list);
		
		for (String s : list) {
			System.out.println(s);
		}
	}
}
