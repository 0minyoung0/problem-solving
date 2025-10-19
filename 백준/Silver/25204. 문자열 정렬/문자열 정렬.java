import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(br.readLine());
            }
            Collections.sort(list, new Comparator<String>() {
                public int compare(String o1, String o2) {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    int minLength = Math.min(o1.length(), o2.length());
                    for (int i = 0; i < minLength; i++) {
                        char c1 = o1.charAt(i);
                        char c2 = o2.charAt(i);
                        if (c1 != c2) {
                            if (c1 == '-') {
                                return 1;
                            }
                            if (c2 == '-') {
                                return -1;
                            }

                            if (Math.abs(c1 - c2) != Math.abs('A' - 'a')) {
                                if ('A' <= c1 && c1 <= 'Z') {
                                    c1 += (-'A' + 'a');
                                }
                                if ('A' <= c2 && c2 <= 'Z') {
                                    c2 += (-'A' + 'a');
                                }
                            }

                            return c1 - c2;
                        }
                    }
                    return o1.length() - o2.length();
                }
            });
            for (String s : list) {
                sb.append(s).append('\n');
            }
        }
        System.out.print(sb);
    }
}
