import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 상근이가 받은 메시지
        String s = br.readLine();
        
        // 최대의 r 찾기
        int r = 1;
        for (int i=2; i*i<=s.length(); i++) {
        	if (s.length() % i == 0) {
        		r = i;
        	}
        }
        int c = s.length() / r;
        
        // 배열에 세로로 넣기
        char[][] arr = new char[r][c];
        for (int i=0; i<s.length(); i++) {
        	arr[i%r][i/r] = s.charAt(i);
        }
        
        // 가로로 읽기
        for (int i=0; i<r; i++) {
        	for (int j=0; j<c; j++) {
        		System.out.print(arr[i][j]);
        	}
        }
    }
}