import java.util.Arrays;
import java.util.Scanner;

public class BOJ_9251_LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자 배열로 만든다.
        char[] A = sc.next().toCharArray();
        char[] B = sc.next().toCharArray();

        // dp 배열을 만든다.
        int[][] dp = new int[A.length+1][B.length+1];

        for(int i = 1; i<A.length+1; i++){
            for(int j = 1; j<B.length+1; j++){
                // 다른 문자이면 위와 아래 중 큰 수로
                if(A[i-1]!=B[j-1]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                // 같은 문자이면 대각선 수 + 1
                else{
                    dp[i][j] = dp[i-1][j-1]+1;
                }
            }
        }

        System.out.println(dp[A.length][B.length]);

//        for(int[] a : dp){
//            System.out.println(Arrays.toString(a));
//        }

    }
    // main
}
