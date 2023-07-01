import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 롤케이크의 길이
        int l = Integer.parseInt(br.readLine());
        
        // 방청객의 수
        int n = Integer.parseInt(br.readLine());
        
        // 해당 조각에 이미 번호가 적혔는지 확인할 boolean 배열
        boolean[] isChecked = new boolean[l+1];
        
        // 가장 많은 조각을 받을것으로 기대한 방청객의 번호와 그 수
        int preIdx = 0;
        int preMax = 0;
        // 가장 많은 조각을 받은 방청객의 번호와 그 수
        int reaIdx = 0;
        int reaMax = 0;
        
        for (int i=1; i<=n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int idx1 = Integer.parseInt(st.nextToken());
        	int idx2 = Integer.parseInt(st.nextToken());
        	
        	if (idx2 - idx1 + 1 > preMax) {
        		preIdx = i;
        		preMax = idx2 - idx1 + 1;
        	}
        	
        	int temp = 0;
        	for (int j=idx1; j<=idx2; j++) {
        		if (!isChecked[j]) {
        			isChecked[j] = true;
        			temp++;
        		}
        	}
        	if (temp > reaMax) {
        		reaIdx = i;
        		reaMax = temp;
        	}
        }
        System.out.println(preIdx);
        System.out.println(reaIdx);
    }
}