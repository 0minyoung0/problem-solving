import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 수의 개수
		int N = Integer.parseInt(br.readLine());
		
		// 수열의 수를 해시맵에 저장
		HashMap<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			// 해시맵에 없는 키면 값을 1로 저장
			if (!map.containsKey(temp)) {
				map.put(temp, 1);
			}
			// 해시맵에 있는 키면 값을 +1
			else {
				map.put(temp, map.get(temp) + 1);
			}
		}
		
		// 해시맵의 키를 값으로 가지는 리스트 만들기
		List<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		
		// 좋은 수의 개수를 저장할 변수
		int ans = 0;
		
		// 좋은 수인지 확인할 숫자의 인덱스 i와 더할 숫자의 인덱스 j에 대해 이분탐색
		goodNum : for (int i=0; i<list.size(); i++) {
			for (int j=0; j<list.size(); j++) {
				int idx = Collections.binarySearch(list, list.get(i)-list.get(j));
				
				// 없는 경우
				if (idx < 0) continue;
				// 다 같은 숫자인 경우
				if (idx == i && idx == j) {
					if (map.get(list.get(idx)) < 3) continue;
				}
				// 두개의 숫자가 같은 경우
				else if (idx == i || idx == j) {
					if (map.get(list.get(idx)) < 2) continue;
				}
				else if (i == j) {
					if (map.get(list.get(i)) < 2) continue;
				}
				
				// ans에 합산하고 다음 숫자 확인
				ans += map.get(list.get(i));
				continue goodNum;
			}
		}
		
		// 답 출력
		System.out.println(ans);
	}
}
