package BOJ_14499;

import java.util.Scanner;

public class Main {
	
	static int[] dice= {0,0,0,0,0,0,0};
	static int[] dx = {0,0,-1,1}; //동서북남 방향
 	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //세로 크기
		int M = sc.nextInt(); //가로 크기
		int x = sc.nextInt();
		int y = sc.nextInt();
		int K = sc.nextInt(); //명령의 개수
		
		int[][] map = new int[N][M];
		//지도에 정보 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		int[] order = new int[K];
		//명령 입력받기
		dir: for (int i = 0; i < K; i++) {
			int move = (sc.nextInt()) - 1;
			x += dx[move];
			y += dy[move];
			
			if(x < 0 || x >= N || y < 0 || y >= M) {
				x -= dx[move];
				y -= dy[move];
				continue dir;
			}
			
			switch(move) {
			//동쪽으로 이동
			case 0:
				move_east();
				break;
			//서쪽으로 이동
			case 1:
				move_west();
				break;
			//북쪽으로 이동
			case 2: 
				move_north();
				break;
			//남쪽으로 이동
			case 3:
				move_south();
				break;
			}
			
			//지도 0이면, 주사위 값 복사
			if(map[x][y] == 0) {
				map[x][y] = dice[6];
			} 
			//지도 0 아니면, 주사위에 값 복사
			else {
				dice[6] = map[x][y];
				//지도 0으로 변함
				map[x][y] = 0;
			}
			
			System.out.println(dice[3]);
		}
		
		
	}//main
	
	public static void move_east() {
		int temp = dice[6];
		dice[6] = dice[4];
		dice[4] = dice[3];
		dice[3] = dice[2];
		dice[2] = temp;
	}
	
	public static void move_west() {
		int temp = dice[6];
		dice[6] = dice[2];
		dice[2] = dice[3];
		dice[3] = dice[4];
		dice[4] = temp;
	}
	
	public static void move_south() {
		int temp = dice[6];
		dice[6] = dice[5];
		dice[5] = dice[3];
		dice[3] = dice[1];
		dice[1] = temp;
	}
	
	public static void move_north() {
		int temp = dice[6];
		dice[6] = dice[1];
		dice[1] = dice[3];
		dice[3] = dice[5];
		dice[5] = temp;
	}
}
