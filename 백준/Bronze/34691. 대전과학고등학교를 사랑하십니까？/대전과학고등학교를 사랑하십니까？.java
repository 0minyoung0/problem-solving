import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!(input = br.readLine()).equals("end")) {
            switch (input) {
                case "animal":
                    System.out.println("Panthera tigris");
                    break;
                case "tree":
                    System.out.println("Pinus densiflora");
                    break;
                case "flower":
                    System.out.println("Forsythia koreana");
                    break;
                default:
                    break;
            }
        }
    }
}
