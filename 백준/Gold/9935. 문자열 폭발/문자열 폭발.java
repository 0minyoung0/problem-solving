import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] S = br.readLine().toCharArray();
		char[] e = br.readLine().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		i: for (int i=0; i<S.length; i++) {
			sb.append(S[i]);
			
			if (sb.length() < e.length) continue;
			
			for (int j=1; j<=e.length; j++) {
				if (sb.charAt(sb.length()-j) != e[e.length-j]) continue i;
			}
			
			sb.delete(sb.length()-e.length, sb.length());
		}
		
		if (sb.length() != 0) System.out.println(sb);
		else System.out.println("FRULA");
	}
}
