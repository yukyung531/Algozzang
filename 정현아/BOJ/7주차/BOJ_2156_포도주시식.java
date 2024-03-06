package BOJ_2156_포도주시식;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// n: 포도주 잔의 개수
		
		int[] wine = new int[n+1];		//wine: 각 포도주 잔의 포도주 양
		
		int[] dp = new int[n+1];	//dp[i]: i번재 포도주 잔까지 선택했을 때 최대 양
		
		//포도주 양 입력 받고
		for(int i=1; i<=n; i++) {
			wine[i]=sc.nextInt();
		}
		
		dp[1] = wine[1];
		if(n>1) dp[2] = wine[1] + wine[2];	// 두번째 잔까지 선택한 경우
		
		//n번까지 dp 돌려돌려
		for(int i=3; i<=n; i++) {
			//i번째 포도주 잔까지 선택했을 때 최대양: i번째를 선택 안 했을 때, i-2번째 선택 후 본인 선택했을 때, i-3번째 선택 후 i-1선택 후 i 선택했을 때의 최대값
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));

		}
		
		System.out.println(dp[n]);
		
	}
}
