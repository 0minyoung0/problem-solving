import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static class Player {
        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

    static class Room {
        int capacity;
        int lowerLevel;
        int upperLevel;
        List<Player> players;

        public Room(int capacity, int firstLevel) {
            this.capacity = capacity;
            this.lowerLevel = firstLevel - 10;
            this.upperLevel = firstLevel + 10;
            this.players = new ArrayList<>();
        }

        public boolean canEnter(Player player) {
            return players.size() < capacity && lowerLevel <= player.level && player.level <= upperLevel;
        }

        public void enterPlayer(Player player) {
            players.add(player);
        }

        public void stringBuild() {
            if (players.size() == capacity) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }

            players.sort((p1, p2) -> p1.nickname.compareTo(p2.nickname));

            for (Player player : players) {
                sb.append(player.level).append(" ").append(player.nickname).append("\n");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            Player player = new Player(l, n);

            boolean entered = false;
            for (Room room : rooms) {
                if (room.canEnter(player)) {
                    room.enterPlayer(player);
                    entered = true;
                    break;
                }
            }

            if (!entered) {
                Room room = new Room(m, l);
                room.enterPlayer(player);
                rooms.add(room);
            }
        }

        for (Room room : rooms) {
            room.stringBuild();
        }

        System.out.print(sb);
    }
}