import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20006_랭킹전대기열 {
    static class Player{
        int l; // 플레이어 레벨
        String n; // 플레이어 닉네임

        public Player(int l, String n){
            this.l = l;
            this.n = n;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken()); // 플레이어 수
        int m = Integer.parseInt(st.nextToken()); // 방의 정원

        List<List<Player>> roomList = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            Player player = new Player(l, n);

            boolean isPlaced = false;

            for (List<Player> playerRoom : roomList) {
                if (playerRoom.size() < m && player.l >= playerRoom.get(0).l - 10 && player.l <= playerRoom.get(0).l + 10) {
                    playerRoom.add(player);
                    isPlaced = true;
                    break;
                }
            }

            if (!isPlaced) {
                List<Player> newRoom = new ArrayList<>();
                newRoom.add(player);
                roomList.add(newRoom);
            }
        }

        // 사전순으로 정렬
        for(List<Player> playerRoom : roomList){
            Collections.sort(playerRoom, Comparator.comparing(player -> player.n));
        }

        for(List<Player> playerRoom : roomList){
            if(playerRoom.size() == m){ // 정원이 찼다면 시작
                System.out.println("Started!");
                for(Player player : playerRoom){
                    System.out.println(player.l +" " + player.n);
                }
            }else{
                System.out.println("Waiting!");
                for(Player player : playerRoom){
                    System.out.println(player.l +" " + player.n);
                }
            }
        }



    }
    // main
}
