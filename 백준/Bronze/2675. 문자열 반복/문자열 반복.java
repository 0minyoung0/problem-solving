import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			
			char[] S = st.nextToken().toCharArray();
			for (int i=0; i<S.length; i++) {
				for (int j=0; j<R; j++) {
					sb.append(S[i]);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
}
