package BOJ_1010_다리놓기;

// dp
//dp[n][m] = dp[n-1][m-1] + dp[n][m-1];
//dp[1][1] = 1, dp[1][2] = 2, ... dp[1][30] = 30
//dp[2][2] = 1, dp[3][3] = 1, ... dp[30][30] = 1 ... => dp[i][j]에서 j는 i보다 작으면 안 됨

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] bridge = new int[31][31];	//bridge: dp 배열		
		
		//dp... bridge[1][1]부터 bridge[30][30]까지 미리 만들어두기
		//1. bridge[1][n] = n 입력해두기
		for(int i=1; i<=30; i++) {
			bridge[1][i] = i;
		}
		
		//2. bridge[2][2]부터 bridge[30][30]까지 만들기
		for(int i=2; i<=30; i++) {
			for(int j=i; j<=30; j++) {
				bridge[i][j] = bridge[i-1][j-1] + bridge[i][j-1];
			}
		}
		
		//테스트 개수 받고
		int T = sc.nextInt();

		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println(bridge[N][M]);
		}
		
	}

}
