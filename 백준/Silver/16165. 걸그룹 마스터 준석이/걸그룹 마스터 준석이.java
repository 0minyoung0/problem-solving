import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력받을 걸그룹의 수
		int N = Integer.parseInt(st.nextToken());
		// 맞혀야 할 문제의 수
		int M = Integer.parseInt(st.nextToken());
		
		// 팀 이름으로 멤버 이름을 맞추기 위한 해시맵
		HashMap<String, List<String>> map0 = new HashMap<>();
		// 멤버 이름으로 팀 이름을 맞추기 위한 해시맵
		HashMap<String, String> map1 = new HashMap<>();
		
		// 걸그룹 정보 입력받기
		while (N-- > 0) {
			
			// 팀 이름
			String team = br.readLine();
			
			// 걸그룹의 인원수
			int p = Integer.parseInt(br.readLine());
			
			// 멤버의 이름을 저장할 리스트
			List<String> members = new ArrayList<>();
			
			// 데이터 저장
			while (p-- > 0) {
				
				// 멤버의 이름
				String member = br.readLine();
				
				// 리스트에 저장
				members.add(member);
				
				// map1에 저장
				map1.put(member, team);
			}
			
			// 리스트 정렬
			Collections.sort(members);
			
			// map0에 저장
			map0.put(team, members);
		}
		
		// 퀴즈 풀기
		while (M-- > 0) {
			
			// 퀴즈
			String quiz = br.readLine();
			
			// 퀴즈의 종류
			int type = Integer.parseInt(br.readLine());
			
			// 0번 퀴즈인 경우
			if (type == 0) {
				for (String member : map0.get(quiz)) {
					System.out.println(member);
				}
			}
			// 1번 퀴즈인 경우
			else {
				System.out.println(map1.get(quiz));
			}
		}
	}
}
