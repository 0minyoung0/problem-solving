import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 필요한 설탕 킬로 수
        int n = Integer.parseInt(br.readLine());
        
        // 5킬로 봉지, 3킬로 봉지
        int b5 = 0;
        int b3 = 0;
        
        while (n % 5 != 0) {
        	n -= 3;
        	b3++;
        	if (n < 0) {
        		System.out.println(-1);
        		return;
        	}
        }
        
        b5 = n / 5;
        
        System.out.println(b5 + b3);
    }
}