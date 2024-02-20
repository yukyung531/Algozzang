package boj_14499;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	 * 1. 맵 만들기
	 * 2. 주사위 이동
	 * 3. 출력
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		int x = sc.nextInt();
		int y = sc.nextInt();
		int order = sc.nextInt();
		//지도 만들기
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[] dice = new int[6];
		//명령 실행(주사위 이동), dice[1] 윗면
		order: for(int i = 0; i<order; i++) {
			int direction = sc.nextInt();
			switch(direction) {
			case 1:
				if(y+1<M) {
					y=y+1;
					//주사위 이동
					int dice4 = dice[4];
					dice[4] = dice[3];
					dice[3] = dice[5];
					dice[5] = dice[1];
					dice[1] = dice4;
					break;
				}else {
					continue order;
				}
			case 2:
				if(y-1>=0) {
					y = y-1;
					int dice4 = dice[4];
					dice[4] = dice[1];
					dice[1] = dice[5];
					dice[5] = dice[3];
					dice[3] = dice4;
					break;
				}else {
					continue order;
				}
			case 3:
				if(x-1>=0) {
					x = x-1;
					int dice0 = dice[0];
					for(int j=0; j<3; j++) {
						dice[j] = dice[j+1];
					}
					dice[3] = dice0;
					break;
				}else {
					continue order;
				}
			case 4:
				if(x+1<N) {
					x = x+1;
					int dice3 = dice[3];
					for(int j = 3; j>0; j--) {
						dice[j] = dice[j-1];
					}
					dice[0] = dice3;
					break;
				}else {
					continue order;
				}
			default:
				break;
			}
			if(map[x][y] == 0) {
				map[x][y] = dice[3];
			}else {
				dice[3] = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(dice[1]);
		}//order
		
		
	}

}