import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3758_KCPC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T; tc++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀 수
            int k = Integer.parseInt(st.nextToken()); // 문제 수
            int t = Integer.parseInt(st.nextToken()); // 내 팀 아이디
            int m = Integer.parseInt(st.nextToken()); // 로그 수

            int[] submit = new int[n]; // 각 팀당 제출횟수 배열
            int[] time = new int[n]; // 각 팀당 최종체출 시간 배열
            int[][] log = new int[n][k]; // 각 팀당 문제별 점수 배열

            for(int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine());

                int id = Integer.parseInt(st.nextToken()); // 팀 아이디
                int question = Integer.parseInt(st.nextToken()); // 문제 번호
                int score = Integer.parseInt(st.nextToken()); // 점수

                log[id-1][question-1] = Math.max(score,log[id-1][question-1]);
                submit[id-1]++; // 제출횟수 카운트
                time[id-1] = i; // 제출 시간 카운트

            }
            // 로그 입력

            int res = 0; // 내 순위

            int[] totalScore = new int[n];

            // 1. 각 팀당 점수 비교
            for(int i = 0; i<n; i++){
                for(int j =0; j<k; j++){
                    totalScore[i]+=log[i][j];
                }
            }

            for(int i = 0; i<n; i++){
                if(i == t-1) continue;
                if(totalScore[i] > totalScore[t-1]){ // 나보다 점수가 크다면 순위++
                    res++;
                }else if(totalScore[i] == totalScore[t-1]){ // 점수가 같다면 제출횟수 비교
                    if(submit[i] < submit[t-1]){ // 나보다 제출횟수가 적다면
                        res++;
                    }else if(submit[i] == submit[t-1]){// 제출횟수가 같다면 제출 시간 비교
                        if(time[i] < time[t-1]){
                            res++;
                        }
                    }
                }
            }
            res++;

            System.out.println(res);

        }
        // tc
    }
    // main
}
