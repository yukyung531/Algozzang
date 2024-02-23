import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
    static int N;
    static int[] totalNum;
    static int teamNum;
    static int[] sel;
    static int[][] team;
    static List<Integer> start;
    static List<Integer> link;
    static int minNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 총 팀원 수
        N = Integer.parseInt(br.readLine());
        // 한 팀의 수
        teamNum = N/2;

        // 팀원의 수만큼 배열을 만들자
        totalNum = new int[N];
        for(int i = 0; i<N; i++){
            totalNum[i] = i+1;
        }

        // 능력치
        team = new int[N+1][N+1];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                team[i+1][j+1] = Integer.parseInt(st.nextToken());
            }
        }

        // 능력치 차의 최솟값
        minNum = 987654321;

        // 조합된 수 배열
        sel = new int[teamNum];

        // 조합을 구하며 능력치 구하자
        comb(0, 0);

        System.out.println(minNum);
    }
    // main

    public static void comb(int idx, int sidx){
        // 조합된 팀의 능력치 합을 확인할 변수
        int totalStart = 0;
        int totalLink = 0;
        // 기저 조건
        if (sidx == teamNum) {
            for(int i = 0; i<sel.length; i++){
                int row = sel[i];
                for(int j = 0; j<sel.length; j++){
                    int col = sel[j];
                    totalStart += team[row][col];
                }
            }
            // 조합에 포함되지 않은 수들만 따로 리스트를 만들어야 함
            List<Integer> teamLink = new ArrayList<>();
            // 일단 모든 팀원들을 다 넣고
            for(int i = 0; i<totalNum.length; i++){
                teamLink.add(totalNum[i]);
            }
            // 스타트팀에 포함된다면 제거하자
            for(int i = 0; i<sel.length; i++){
                if(teamLink.contains(sel[i])){
                    teamLink.remove(Integer.valueOf(sel[i]));
                }
            }
            // 능력치 배열에서 능력치를 더하자
            for(int i = 0; i<teamLink.size(); i++){
                int row = teamLink.get(i);
                for(int j = 0; j<teamLink.size(); j++){
                    int col = teamLink.get(j);
                    totalLink += team[row][col];
                }
            }
            // 최솟값 갱신
            minNum = Math.min(minNum, Math.abs(totalStart-totalLink));

            return;
        }

        if(idx == N){
            return;
        }
        // 재귀 조건
        sel[sidx] = totalNum[idx];
        comb(idx+1, sidx+1);
        comb(idx+1, sidx);
    }
}
