import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		int[] dx = {0,0,1,0,-1};
		int[] dy = {0,-1,0,1,0};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] dirA = new int[m];
			for (int i=0; i<m; i++) {
				dirA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			int[] dirB = new int[m];
			for (int i=0; i<m; i++) {
				dirB[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] BCinfo = new int[a][4];
			for (int i=0; i<a; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<4; j++) {
					BCinfo[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			// 0초일때
			int[] curA = {1,1};
			int[] curB = {10,10};
			List<int[]> aBC = new ArrayList<>();
			List<int[]> bBC = new ArrayList<>();
			for (int i=0; i<a; i++) {
				if (Math.abs(BCinfo[i][0] - curA[0]) + Math.abs(BCinfo[i][1] - curA[1]) <= BCinfo[i][2]) {
					aBC.add(new int[] {i, BCinfo[i][3]});
				}
				if (Math.abs(BCinfo[i][0] - curB[0]) + Math.abs(BCinfo[i][1] - curB[1]) <= BCinfo[i][2]) {
					bBC.add(new int[] {i, BCinfo[i][3]});
				}
			}
			ans += MaxCharge(aBC, bBC);
			aBC.clear();
			bBC.clear();
			
			for (int j=0; j<m; j++) {
				// 이동시키기
				curA[0] += dx[dirA[j]];
				curA[1] += dy[dirA[j]];
				curB[0] += dx[dirB[j]];
				curB[1] += dy[dirB[j]];
				
				// 계산시키기
				for (int i=0; i<a; i++) {
					if (Math.abs(BCinfo[i][0] - curA[0]) + Math.abs(BCinfo[i][1] - curA[1]) <= BCinfo[i][2]) {
						aBC.add(new int[] {i, BCinfo[i][3]});
					}
					if (Math.abs(BCinfo[i][0] - curB[0]) + Math.abs(BCinfo[i][1] - curB[1]) <= BCinfo[i][2]) {
						bBC.add(new int[] {i, BCinfo[i][3]});
					}
				}
				ans += MaxCharge(aBC, bBC);
				
				// list 초기화
				aBC.clear();
				bBC.clear();
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	private static int MaxCharge(List<int[]> a, List<int[]> b) {
		if (a.size() == 0 && b.size() == 0) {
			return 0;
		}
		else if (a.size() == 0) {
			int temp = 0;
			for (int i=0; i<b.size(); i++) {
				temp = Math.max(temp, b.get(i)[1]);
			}
			return temp;
		}
		else if (b.size() == 0) {
			int temp = 0;
			for (int i=0; i<a.size(); i++) {
				temp = Math.max(temp, a.get(i)[1]);
			}
			return temp;
		}
		else if (a.size() == 1 && b.size() == 1) {
			if (a.get(0)[0] == b.get(0)[0]) {
				return a.get(0)[1];
			}
			else {
				return a.get(0)[1] + b.get(0)[1];
			}
		}
		else {
			int temp = 0;
			for (int i=0; i<a.size(); i++) {
				for (int j=0; j<b.size(); j++) {
					if (a.get(i)[0] == b.get(j)[0]) {
						continue;
					}
					temp = Math.max(temp, a.get(i)[1] + b.get(j)[1]);
				}
			}
			return temp;
		}
	}
}
