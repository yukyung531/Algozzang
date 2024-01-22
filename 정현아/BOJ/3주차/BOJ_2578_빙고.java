package BOJ_2578_빙고;

import java.util.Scanner;

//Xy: x좌표 y좌표 담아두는 클래스
class Xy {
	int x;
	int y;

	public Xy(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] firstBG = new int[5][5]; // firstBG: 작성한 빙고판

		Xy[] position = new Xy[26]; // position: 각각의 숫자가 어느 위치에 있는지 저장한 배열

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int n = sc.nextInt();
				firstBG[i][j] = n; // 작성된 빙고판 좌표에 숫자 넣고
				position[n] = new Xy(i, j); // 숫자에 해당하는 좌표를 position 배열에 저장
			}
		} // 처음에 빙고판 입력하기

		int cnt = 0; // cnt: 몇 번째 수를 부른 뒤 빙고를 외치게 되는지 세는 수

		// 사회자가 빙고 숫자를 부르기 시작함
		// 25번 돌게 만들어 놓고
		all: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int numberBG = sc.nextInt(); // numberBG: 사회자가 부르는 수
				Xy tmp = position[numberBG];
				firstBG[tmp.x][tmp.y] = 0; // 해당 위치에 빙고 표시

				cnt++; // 숫자 세기

				// cnt가 12보다 크면
				// 왜 12보다 크게 설정해놨냐면 3빙고에 필요한 최소 숫자가 12개라
				if (cnt >= 12) {
					int bingGo = 0; // bingGo: 빙고 횟수 - 처음엔 0으로 초기화
					for (int k = 0; k < 5; k++) {
						// (0, k) => 가로 부분, 세로로 빙고 확인
						if (firstBG[0][k] == 0) {
							boolean bg = true; // bg: 빙고 한 줄 성공했는지 - 처음엔 일단 true로 설정
							// 한 줄씩 돌거임 (4번)
							check: for (int l = 1; l < 5; l++) {
								// 만약 해당하는 세로 줄이 전부 0이면 bg는 true로 나올 것이고, 중간에 0이 아닌 게 있다면 false로 나올 것
								if (firstBG[l][k] != 0) {
									bg = false;
									break check;
								}
							}
							// bg가 true면 빙고 한 줄 완성이니까 빙고횟수+1
							if (bg) {
								bingGo++;
							}
						}

						// (k, 0) => 세로 부분, 가로로 빙고 확인
						if (firstBG[k][0] == 0) {
							boolean bg = true;
							check: for (int l = 1; l < 5; l++) {
								if (firstBG[k][l] != 0) {
									bg = false;
									break check;
								}
							}
							if (bg) {
								bingGo++;
							}
						}

						// (0, 0) => 대각선도 확인
						if (k == 0) {
							boolean bg = true;
							check: for (int l = 1; l < 5; l++) {
								if (firstBG[l][l] != 0) {
									bg = false;
									break check;
								}
							}
							if (bg) {
								bingGo++;
							}
						}

						// (0,4) => 대각선 확인
						if (k == 4) {
							boolean bg = true;
							check: for (int l = 1; l < 5; l++) {
								if (firstBG[l][k - l] != 0) {
									bg = false;
									break check;
								}
							}
							if (bg) {
								bingGo++;
							}
						}

					} // 5번 도는 for문

					// 3빙고 이상이면? 나가!
					if (bingGo >= 3) {
						break all;
					}
				} // 12번 넘으면..

			}
		} // 빙고 찾는 for문

		System.out.println(cnt); // 출력
	}

}
