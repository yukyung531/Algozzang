import java.io.*;
import java.util.*;

public class BOJ_25757_임스와함께하는미니게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 게임 신청 횟수
        String G = st.nextToken(); // 게임 종류 (Y:2명, F:3명, O:4명)

        Set<String> nameSet = new HashSet<>();// 신청자 이름 저장할 set
        int players = 1; // player 수
        int cnt = 0; // 총 게임 횟수

        for(int i= 0; i<N; i++){
            String name = br.readLine(); // 신청자 이름
            // 이미 신청한 사람이라면 다음 ~
            if(nameSet.contains(name)) continue;

            // 이름 리스트에 저장
            nameSet.add(name);
            players++;

            // Y일 경우 2명 필요
            if(G.equals("Y")){
                if(players == 2){
                    cnt++;
                    players = 1;
                }
            }
            // F일 경우 3명 필요
            else if(G.equals("F")){
                if(players == 3){
                    cnt++;
                    players = 1;
                }
            }
            else{
                if(players == 4){
                    cnt++;
                    players = 1;
                }
            }
        }
        // name 입력

        br.close();
        System.out.println(cnt);
    }
    // main
}
