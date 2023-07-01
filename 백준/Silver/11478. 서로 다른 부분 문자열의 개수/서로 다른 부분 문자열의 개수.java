import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		HashSet<String> set = new HashSet<>();
		
		for (int i=0; i<S.length(); i++) {
			for (int j=i+1; j<=S.length(); j++) {
				String sub = S.substring(i, j);
				set.add(sub);
			}
		}
		
		System.out.println(set.size());
	}
}
