import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int case_num = 1; case_num <= T; case_num++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n+1];
			int[] length = new int[n+1]; // 해당 인덱스번째 숫자를 마지막 숫자로 포함하는 가장 긴 부분 증가 수열의 길이
			st = new StringTokenizer(br.readLine());
			length[1] = 0;
			for (int i=1; i<=n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				for (int j=0; j<i; j++) {
					if (arr[j] <= arr[i] && length[j] + 1 > length[i]) { // 증가 수열이면서 length를 갱신할만큼 긴 경우
						length[i] = length[j] + 1;
					}
				}
			}
			int ans = 0;
			for (int i=1; i<=n; i++) {
				if (length[i] > ans) {
					ans = length[i];
				}
			}
			
			System.out.println("#"+case_num+" "+ans);
		}
	}
}
