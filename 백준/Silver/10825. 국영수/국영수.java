import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 학생의 수
		int n = Integer.parseInt(br.readLine());
		
		class Student implements Comparable<Student> {
			String name;
			int k;
			int e;
			int m;
			
			@Override
			public int compareTo(Student o) {
				if (this.k != o.k) return o.k - this.k;
				if (this.e != o.e) return this.e - o.e;
				if (this.m != o.m) return o.m - this.m; 
				return this.name.compareTo(o.name);
			}
		}
		
		List<Student> list = new ArrayList<>();
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			Student student = new Student();
			student.name = st.nextToken();
			student.k = Integer.parseInt(st.nextToken());
			student.e = Integer.parseInt(st.nextToken());
			student.m = Integer.parseInt(st.nextToken());
			
			list.add(student);
		}
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (Student s : list) {
			sb.append(s.name + "\n");
		}
		System.out.println(sb);
	}
}
