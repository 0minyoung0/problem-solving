public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("100\n");
        for (int i = 0; i < 99; i++) {
            for (int j = 0; j < 99; j++) {
                if (i != j) {
                    sb.append("10000 ");
                } else {
                    sb.append("0 ");
                }
            }
            sb.append("0\n");
        }
        for (int i = 0; i < 100; i++) {
            sb.append("0 ");
        }
        System.out.println(sb);
    }
}