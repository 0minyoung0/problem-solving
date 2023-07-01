import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int caseNum=1; caseNum<=T; caseNum++) {
			st = new StringTokenizer(br.readLine());
			// 최대값을 저장할 변수
			int max = 0;
			for (int i=0; i<10; i++) {
				max = Math.max(max, Integer.parseInt(st.nextToken()));
			}
			System.out.println("#"+caseNum+" "+max);
		}
	}
}