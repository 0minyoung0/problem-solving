import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 단어 S
		String S = br.readLine();
		
		// 정수 i
		int i = Integer.parseInt(br.readLine());
		
		// 단어 S의 i번째 문자 출력
		System.out.println(S.charAt(i-1));
	}
}
