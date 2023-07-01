import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 주사위의 개수
        int n = Integer.parseInt(br.readLine());
        
        // 주사위의 전개도 정보
        int[][] dice = new int[n][6];
        for (int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0; j<6; j++) {
        		dice[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        // 전개도의 반대편 인덱스 매칭
        int[] otherSide = {5,3,4,1,2,0};
        
        // 한 옆면의 숫자의 합의 최댓값을 저장할 변수
        int ans = 0;
        
        // 각 케이스별로 최대값 비교
        for (int i=0; i<6; i++) {
        	int temp = 0;
        	
        	int bot = dice[0][i];
        	int top = dice[0][otherSide[i]];
        	
        	// 옆면의 최댓값 ans에 더하기
        	if (bot != 6 && top != 6) temp += 6;
        	else if (bot != 5 && top != 5) temp += 5;
        	else temp += 4;
        	
        	for (int j=1; j<n; j++) {
        		bot = top;
        		int botIdx = -1;
        		for (int k=0; k<6; k++) {
        			if (dice[j][k] == bot) {
        				botIdx = k;
        				break;
        			}
        		}
        		top = dice[j][otherSide[botIdx]];
        		
            	// 옆면의 최댓값 ans에 더하기
            	if (bot != 6 && top != 6) temp += 6;
            	else if (bot != 5 && top != 5) temp += 5;
            	else temp += 4;
        	}
        	
        	// ans의 최대값
        	ans = ans > temp? ans : temp;
        }
        
        System.out.println(ans);
    }
}