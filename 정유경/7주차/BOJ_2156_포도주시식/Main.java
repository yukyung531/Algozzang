package BOJ_2156_포도주시식;

import java.util.Scanner;

/*
 * dp[n]은 n번째 와인까지 따졌을 때 마실 수 있는 와인의 최대 양이될 것이고, 각 경우는 아래와 같이 나타낼 수 있다.
 * 1. 전전전(n-3)까지의 최대 양 + 전(n-1) 번째 양 + 현재 양 = (dp[n-3] + wine[n-1] + wine[n])
 * 2. 전전(n-2)까지의 최대 양 + 현재 양 = (dp[n-2] + wine[n])
 * */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] wine = new int[n+1];
		for(int i = 1; i < n+1; i++) {
			wine[i] = sc.nextInt();
		}
		
		int[] dp = new int[n+1];
		dp[1] = wine[1];
		if(n > 1) { // N=1의 경우를 대비해 예외처리 
			dp[2] = wine[1] + wine[2];
		}
	
		for(int i = 3; i < n+1; i++) { // 전 와인과 전전 와인을 먹을 수 있는 3번째 와인부터 시작 
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-3] + wine[i-1]) + wine[i]); 
		}
		
		System.out.println(dp[n]);
		
	}//main
}
