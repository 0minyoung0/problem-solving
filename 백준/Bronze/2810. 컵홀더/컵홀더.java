import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 좌석의 수
        int n = Integer.parseInt(br.readLine());
        
        // 좌석 정보
        String seats = br.readLine();

        // 일반좌석 수
        int s = 0;
        for (int i=0; i<n; i++) {
        	if (seats.charAt(i) == 'S') {
        		s++;
        	}
        }
        
        // 일반 좌석만 있는 경우
        if (s == n) {
        	System.out.println(s);
        }
        // 커플석이 있는 경우
        else {
        	System.out.println(s + (n-s)/2 + 1);
        }
    }
}