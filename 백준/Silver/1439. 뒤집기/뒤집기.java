import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 문자열 S
		String S = br.readLine();
		
		// 문자열을 순회하며 달라지는 개수 세기
		int cnt = 0;
		for (int i=0; i<S.length()-1; i++) {
			if (S.charAt(i) != S.charAt(i+1)) cnt++;
		}
		
		// 답 출력
		System.out.println((cnt+1)/2);
	}
}