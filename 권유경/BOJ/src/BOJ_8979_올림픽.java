import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_8979_올림픽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 국가 수
        int K = Integer.parseInt(st.nextToken()); // 등수가 궁금한 국가

        int[][] input = new int[N][4]; // 국가, 금은동 입력
        int[] rank = new int[N+1];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken()); // 국가
            input[i][1] = Integer.parseInt(st.nextToken()); // 금
            input[i][2] = Integer.parseInt(st.nextToken()); // 은
            input[i][3] = Integer.parseInt(st.nextToken()); // 동
        }
        br.close();

        Arrays.sort(input, (a, b) -> {
            // 먼저 [i][1]을 비교
            if (a[1] != b[1]) {
                return -Integer.compare(a[1], b[1]);
            }
            // [i][1]이 같다면, [i][2]를 비교
            if (a[2] != b[2]) {
                return -Integer.compare(a[2], b[2]);
            }
            // [i][2]도 같다면, [i][3]을 비교
            return -Integer.compare(a[3], b[3]);
        });

        int cnt = 1; // 중복제외 등수
        rank[input[0][0]] = 1;
        for(int i = 1; i<N; i++){
            cnt++;
            // 금은동 모두 같다면 같은 등수
            if(input[i][1] == input[i-1][1] && input[i][2] == input[i-1][2] && input[i][3] == input[i-1][3]){
                rank[input[i][0]] = rank[input[i-1][0]];
            }
            else{
                rank[input[i][0]] = cnt;
            }
        }

        System.out.println(rank[K]);

    }
    // main
}
