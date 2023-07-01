import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] S = br.readLine().toCharArray();
		
		int[] cnt = new int[26];
		Arrays.fill(cnt, -1);
		
		for (int i=0; i<S.length; i++) {
			int cur = S[i] - 'a';
			if (cnt[cur] != -1) continue;
			cnt[cur] = i;
		}
		
		for (int i=0; i<26; i++) {
			System.out.print(cnt[i] + " ");
		}
	}
}
