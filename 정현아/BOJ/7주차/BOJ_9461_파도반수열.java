package BOJ_9461_파도반수열;

//P[N] = P[N-1] + P[N-4] (단, N은 11 이상)
//console 찍어보니 int면 안 되고 long이어야 함

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Long[] P = new Long[101];	//N은 100까지니까
		
		//P(1)부터 P(10)까지 주어진 숫자 넣기
		P[1] = (long) 1;
		P[2] = (long) 1;
		P[3] = (long) 1;
		P[4] = (long) 2;
		P[5] = (long) 2;
		P[6] = (long) 3;
		P[7] = (long) 4;
		P[8] = (long) 5;
		P[9] = (long) 7;
		P[10] = (long) 9;
		
		//P(11)부터 P(100)까지의 숫자
		for(int n=11; n<=100; n++) {
			P[n] = P[n-1] + P[n-5];
		}
		
		
		//테케 입력 받고
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			System.out.println(P[N]);
		}
	}
}
