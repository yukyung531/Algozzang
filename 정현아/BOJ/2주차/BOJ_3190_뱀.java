package BOJ_3190_뱀;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class ChangeTime {
	int time;
	String direction;

	public ChangeTime(int time, String direction) {
		this.time = time;
		this.direction = direction;
	}

}

class Snake {
	int x;
	int y;

	public Snake(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // N: 보드 크기

		int[][] map = new int[N][N]; // map: 보드

		int appleNum = sc.nextInt(); // appleNum: 사과 갯수

		for (int i = 0; i < appleNum; i++) {
			int row = sc.nextInt() -1;
			int col = sc.nextInt() -1;

			map[row][col] = -1; // 사과 자리에 -1 입력
		}

		int change = sc.nextInt(); // change: 방향 변환 횟수

		Queue<ChangeTime> queue = new LinkedList<>(); // queue: 방향 변환 시간, 방향을 저장한 애들을 담은 큐

		// 큐에 입력받아서 담아두기
		for (int i = 0; i < change; i++) {
			int time = sc.nextInt();
			String direction = sc.next();

			queue.add(new ChangeTime(time, direction));

		}

		// snakeD: 방향, 처음엔 오른쪽으로 향하니 1
		int snakeD = 1;

		ArrayList<Snake> snake = new ArrayList<>(); // snake: 뱀...

		snake.add(new Snake(0, 0));
		int x = 0;
		int y = 0;

		int totalTime = 0; // totalTime: 총 걸린 시간

		end: while (true) {
			
			totalTime++; // 1초마다 아래의 것들을 실행함

			int nx = x + dr[snakeD];
			int ny = y + dc[snakeD];

			// 벽에 닿으면 끝!!
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				break end;
			}

			// 뱀 본인 몸에 닿아도 끝!!
			for (int i = 0; i < snake.size(); i++) {
				int sx = snake.get(i).x;
				int sy = snake.get(i).y;
				if (sx == nx && sy == ny) {
					break end;
				}

			}

			// 머리 내민 곳에 사과가 있다면
			if (map[nx][ny] == -1) {
				map[nx][ny] = 0;
				snake.add(new Snake(nx, ny));
				
			} else {
				snake.add(new Snake(nx, ny));
				snake.remove(0);
			}

			ChangeTime ct = queue.peek(); // 방향 바꿔야 하는지 확인 하기 위해
			if (ct != null && ct.time == totalTime) {
			    //오른쪽
			    if(ct.direction.equals("D")) {
			        snakeD = (snakeD+1) % 4;
			    //왼쪽
			    } else {
			        snakeD = (4+ snakeD-1) % 4;
			    }
			    queue.poll();
			}

			
			x = nx;
			y = ny;
			

		}
		
		System.out.println(totalTime);

	}

}

