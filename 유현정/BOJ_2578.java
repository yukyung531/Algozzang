package BOJ_2578;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	 * 1. 정보받기 2. 지우기 3. 출력하기
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] board = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= 25; i++) {
			int number = sc.nextInt();
			// 탐색(지우기)
			primary: for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (board[j][k] == number) {
						board[j][k] = 0;
						break primary;
					}
				}
			}
			// 탐색(빙고체크)
			int bingo = 0;
			// 세로
			for (int j = 0; j < 5; j++) {
				if (board[0][j] == 0) {
					for(int k = 1; k<5; k++) {
						if(board[k][j] != 0) {
							break;
						}
						if(k == 4) {
							bingo++;
						}
					}
				}
			}
			// 가로
			for (int j = 0; j < 5; j++) {
				if (board[j][0] == 0) {
					for(int k = 1; k<5; k++) {
						if(board[j][k] != 0) {
							break;
						}
						if(k == 4) {
							bingo++;
						}
					}
				}
			}
			// 대각선
			if(board[0][0] == 0) {
				for(int k = 1; k<5; k++) {
					if(board[k][k] != 0) {
						break;
					}
					if(k == 4) {
						bingo++;
					}
				}
			}
			if(board[4][0] == 0) {
				for(int k = 1; k<5; k++) {
					if(board[4-k][k] != 0) {
						break;
					}
					if(k == 4) {
						bingo++;
					}
				}
			}
			//빙고 개수 체크
			if(bingo>=3) {
				System.out.println(i);
				break;
			}
		}
	}

}
