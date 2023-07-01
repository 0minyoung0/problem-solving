import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스의 수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 별 실행
		for (int tc=1; tc<=T; tc++) {
			
			// 이승 명부의 이름 개수
			int N = Integer.parseInt(br.readLine());
			
			// 중복 제거를 위해 이름을 저장할 HashSet
			HashSet<String> set = new HashSet<>();
			
			// set에 이름 저장
			while (N-- > 0) {
				set.add(br.readLine());
			}
			
			// 중복이 제거된 set의 원소로 리스트 생성
			List<String> list = new ArrayList<>(set);
			
			// list를 문제 조건에 따라 정렬 (길이 오름차순, 사전순)
			Collections.sort(list, new Comparator<String>() {
				public int compare(String o1, String o2) {
					if (o1.length() != o2.length()) return o1.length() - o2.length();
					return o1.compareTo(o2);
				}
			});
			
			// 답 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append("\n");
			for (String name : list) sb.append(name).append("\n");
			System.out.print(sb);
		}
	}
}