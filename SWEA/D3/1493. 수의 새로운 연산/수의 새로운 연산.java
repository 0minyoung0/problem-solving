import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트케이스 개수
        int T = sc.nextInt();
        
        // 테스트케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	int p = sc.nextInt();
        	int q = sc.nextInt();
        	
        	int temp = 1;
        	while (temp*(temp+1)/2 < p) {
        		temp++;
        	}
        	temp--;
        	int x = p - temp*(temp+1)/2;
        	int y = temp - x + 2;
        	
        	temp = 1;
        	while (temp*(temp+1)/2 < q) {
        		temp++;
        	}
        	temp--;
        	int z = q - temp*(temp+1)/2;
        	int w = temp - z + 2;
        	
        	int newX = x + z;
        	int newY = y + w;
        	
        	int ans = (newX+newY-2)*(newX+newY-1)/2 + newX;
        	
        	System.out.println("#" + t + " " + ans);
        }
    }
}