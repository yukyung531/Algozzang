import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1010_다리놓기 {
    static int[][] dp = new int[31][31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t = 0; t<T; t++){
            String[] temp = br.readLine().split(" ");

            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);


            // M개 중에서 N개를 뽑아야 함(조합)
            sb.append(combi(M,N)+"\n");
//            System.out.println(combi(M,N));
        }
        System.out.println(sb);
        br.close();

    }
    // main

    public static int combi(int m, int n){
        // 이미 계산되어 있다면
        if(dp[m][n] > 0) return dp[m][n];
        // 모두 선택하거나, 아무것도 선택하지 않는 경우는 하나다.
        else if(m==n || n==0) return dp[m][n]=1;
        // 일반적인 경우
        else return combi(m-1, n-1)+combi(m-1, n);
    }
    // combi
}
