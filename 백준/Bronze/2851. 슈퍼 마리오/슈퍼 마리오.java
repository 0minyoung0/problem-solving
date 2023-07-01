import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int score = 0;
        int temp = 0;
        
        // 점수 계산
        for (int i=0; i<10; i++) {
        	temp = Integer.parseInt(br.readLine());
        	if (score + temp <= 100) {
        		score += temp;
        	}else {
        		temp += score;
        		break;
        	}
        }
        
        // 합이 100을 안넘긴 경우
        if (temp <= 100) {
        	System.out.println(score);
        	return;
        }
        
        // score는 100점을 넘기기 전 최고 점수
        // temp는 100점을 넘긴 최초의 점수
        if (100-score < temp-100) {
        	System.out.println(score);
        } else {
        	System.out.println(temp);
        }
        
    }
}