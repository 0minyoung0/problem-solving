import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Operation {
    char command;
    int start;
    int end;

    Operation(char command, int start, int end) {
        this.command = command;
        this.start = start;
        this.end = end;
    }
}

public class Main {

    public static long reverseTracking(List<Operation> operations, int position) {
        long value = 0;
        for (int i = operations.size() - 1; i >= 0; i--) {
            Operation op = operations.get(i);
            if (op.command == 'a') {
                value += position;
            } else if (op.command == 'r') {
                if (op.start <= position && position <= op.end) {
                    position = op.start + op.end - position;
                }
            }
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Operation> operations = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            if (command == 'r') {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                operations.add(new Operation(command, start, end));
            } else {
                operations.add(new Operation(command, 0, 0));
            }
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int position = Integer.parseInt(st.nextToken());
            sb.append(reverseTracking(operations, position)).append("\n");
        }

        System.out.print(sb);
    }
}
