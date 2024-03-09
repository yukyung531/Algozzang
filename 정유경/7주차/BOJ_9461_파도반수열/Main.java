package BOJ_9461_파도반수열;

import java.util.Scanner;

public class Main {
	static int N;
	static long num[] = new long[101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		num[0] = 0;
		num[1] = 1;
		num[2] = 1;
		num[3] = 1;
		
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			
			System.out.println(dp(N));
		}
	}//main
	
	public static long dp(int N) {
		if(num[N] == 0) {
			num[N] = dp(N-2) + dp(N-3);
		}
		
		return num[N];
	}
}
