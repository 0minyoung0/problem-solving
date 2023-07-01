import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스 개수
        int n = Integer.parseInt(br.readLine());
        
        for (int i=0; i<n; i++) {
        	String s = br.readLine();
        	int ans = 0;
        	int cnt = 0;
        	for (int j=0; j<s.length(); j++) {
        		if (s.charAt(j) == 'O') {
        			ans += ++cnt;
        		}else { // 'X'
        			cnt = 0;
        		}
        	}
        	System.out.println(ans);
        }
    }
}