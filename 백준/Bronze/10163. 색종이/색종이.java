import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 평면 배열
        int[][] p = new int[1001][1001];
        
        // 색종이 수
        int n = Integer.parseInt(br.readLine());
        
        for (int i=1; i<=n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	int h = Integer.parseInt(st.nextToken());
        	
        	for (int j=x; j<x+w; j++) {
        		for (int k=y; k<y+h; k++) {
        			p[j][k] = i;
        		}
        	}
        }
        
        int[] ans = new int[n+1];
        for (int i=0; i<1001; i++) {
        	for (int j=0; j<1001; j++) {
        		ans[p[i][j]]++;
        	}
        }
        
        for (int i=1; i<=n; i++) {
        	System.out.println(ans[i]);
        }
    }
}