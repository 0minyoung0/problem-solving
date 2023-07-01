import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int case_num = 1; case_num <= T; case_num++) {
			String s = br.readLine();
			int ans = 0;
			if (s.charAt(0) == '1') {
				ans++;
			}
			for (int i=1; i<s.length(); i++) {
				if (s.charAt(i) != s.charAt(i-1)) {
					ans++;
				}
			}
			System.out.println("#"+case_num+" "+ans);
		}
	}
}