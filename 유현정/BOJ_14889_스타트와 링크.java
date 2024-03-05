package Boj_14889;

import java.util.Scanner;

/*
 * 조건: 2초, 512MB
 * 
 * 차이 최소
 * 
 * 완탐: 조합 -> 계산
 * 20C10 -> 6700억
 * 
 *대각선 0을 기준으로 더하면 안 되나?
 *더해도 됨 
 *
 *최댓값, 최솟값 구하고 그걸 기준으로 백트래킹 하기
 *
 *총 n/2개 선택
 *조합-> 최솟값 결정
 *
 *1. 조합생성(n/2개 선택)
 *	- 0번 무조건 선택, 그 후에 (n/2)-1개 선택
 *	- 다 선택 -> 점수계산
 * 
 */
public class Main {

	static int n;
	static int[][] ability;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ability = new int[n][n];
		visited = new boolean[n];
//		OneCombination = new int[n / 2];
//		OneCombination[0] = 0;
		visited[0] = true;

		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				ability[i][j] = sc.nextInt();
			}
		}
		
		Combination(1 ,1);
		System.out.println(result);

	}

	// 조합 만들기(1~n), 중복제거가 안 됨 -> 그냥 짝수 인덱스 사용하기
	static int idx = 1;
	
	static int result = 200;
	static int visitedBit = 1;

	public static void Combination(int index, int start) {
		if (index == n / 2) {
				int first = 0;
				int second = 0;
				//팀 점수
				for (int j = 0; j < n; j++) {
					int firstCheck = 1<<j;
					for (int k = 0; k < n; k++) {
						int secondCheck = 1<<k;
//						if(visited[j] && visited[k]) {
//						System.out.println("visitedBit  "+ visitedBit);
						if( (visitedBit & firstCheck) >0 && (visitedBit & secondCheck) >0) {
//							System.out.println("j: "+j+" k: "+k);
							first += ability[j][k];
//						}else if(!visited[j] && !visited[k]) {
						}else if( (visitedBit & firstCheck) == 0 && (visitedBit & secondCheck) ==0 ){
							second += ability[j][k];
						}
					}
				}
//				System.out.println("Second: "+second);
				
				int difference = Math.abs(first-second);
				if(result>difference) {
					result = difference;
				}
				
				
//				System.out.println("f "+first);
			return;
		}
		if(result == 0) {
			return;
		}

		for (int i = start; i < n; i++) {
//			if (!visited[i]) {
				if( (visitedBit & (1<<i)) == 0) {
//					System.out.println(visitedBit);
					visitedBit = visitedBit | (1<<i);
//					System.out.println("c: "+visitedBit);
//				visited[i] = true;
				Combination(index+1, start+1);
//				visited[i] = false;
				visitedBit = visitedBit & ~(1<<i);
			}
		}

	}
}
