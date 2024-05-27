import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1205_등수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 현재 리스트에 들어있는 개수
        int score = Integer.parseInt(st.nextToken()); // 태수의 점수
        int P = Integer.parseInt(st.nextToken()); // 리스트에 들어갈 수 있는 개수

        if(N==0){
            System.out.println(1);
            return;
        }

        int len = Math.max(P,N);

        int[] arr = new int[len];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close(); // 입력 완료

        int rank = 0;
        int idx = 0;

        // 태수의 점수보다 높은 것의 개수와 인덱스 구하기
        for(int i = 0; i<N; i++){
            if(arr[i] > score){
                rank++;
                idx = i;
            }
        }

        int cnt = 0;

        // 모든 점수가 태수와 동일한 점수를 세자
        for(int i = 0; i<N; i++){
            if(arr[i] == score)
                cnt++;
        }

        if(arr[0] < score){
            System.out.println(1);
            return;
        }

        // 그 수가 P와 같다면
        if(cnt==P){
            System.out.println(-1);
            return;
        }

        // 태수의 등수가 P 보다 크면 리스트에 들어갈 수 없음.
        if(rank+1 > P){
            System.out.println(-1);
            return;
        }

        cnt = 1;

        // 태수의 점수보다 크지 않은 것부터 탐색
        for(int i = idx+1; i<N; i++){
            // 태수의 점수와 같다면 개수 추가
            if(arr[i] == score){
                cnt++;
                if(rank+cnt > P){
                    System.out.println(-1);
                    return;
                }
            }else{
                System.out.println(rank+1);
                return;
            }
        }
        System.out.println(rank+1);

    }
}
