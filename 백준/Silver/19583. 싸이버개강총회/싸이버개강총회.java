import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 개강총회 시작한 시간, 끝낸 시간, 스트리밍 끝낸 시간
		int S = timeStamp2int(st.nextToken());
		int E = timeStamp2int(st.nextToken());
		int Q = timeStamp2int(st.nextToken());
		
		// 명단을 저장할 해시맵
		HashMap<String, Boolean> map = new HashMap<>();
		
		String input = br.readLine();
		while (input != null) {
			st = new StringTokenizer(input);
			int time = timeStamp2int(st.nextToken());
			String name = st.nextToken();
			if (time <= S && !map.containsKey(name)) {
				map.put(name, false);
			}
			else if (E <= time && time <= Q && map.containsKey(name) && map.get(name).equals(false)) {
				map.put(name, true);
			}
			
			input = br.readLine();
		}
		
		int ans = 0;
		for (String name : map.keySet()) {
			if (map.get(name)) ans++;
		}
		System.out.println(ans);
	}
	private static int timeStamp2int(String timeStamp) {
		int hour = (timeStamp.charAt(0) - '0') * 10 + (timeStamp.charAt(1) - '0');
		int minute = (timeStamp.charAt(3) - '0') * 10 + (timeStamp.charAt(4) - '0');
		return hour * 60 + minute;
	}
}