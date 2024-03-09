package BOJ_1010_다리놓기;

import java.util.Scanner;

/*
 * M개 중에서 N개를 중복되지 않게 뽑는 경우의 수 구하기
 * 
 * */
public class Main {
	static int T,N,M, count;
	static boolean[] visited;
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			M = sc.nextInt();
			count = 0;
			visited = new boolean[M];
			dp = new int[30][30];
			
			System.out.println(comb(M,N));
		}
		
	}//main
	
	public static int comb(int n, int r) {
		
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
		
		if(n==r || r==0) {
			return dp[n][r] = 1;
		}
		
		return dp[n][r] = comb(n-1, r-1) + comb(n-1, r);
	}
}
