import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
        int T = sc.nextInt();
        
        for (int t=1; t<=T; t++) {
        	// 버스 노선의 개수
            int n = sc.nextInt();
            
            // 버스 노선 정보
            int[][] busRoute = new int[n][2];
            for (int i=0; i<n; i++) {
            	for (int j=0; j<2; j++) {
            		busRoute[i][j] = sc.nextInt();
            	}
            }
            
            // 버스 정류장 개수
            int p = sc.nextInt();
            
            // 버스 정류장이 노선에 포함되는지 확인해서 카운트하고 출력
            System.out.print("#" + t);
            for (int i=0; i<p; i++) {
            	int ans = 0;
            	int c = sc.nextInt();
            	for (int j=0; j<n; j++) {
            		if (busRoute[j][0] <= c && c <= busRoute[j][1]) {
            			ans++;
            		}
            	}
            	System.out.print(" " + ans);
            }
            System.out.println();
        }
    }
}