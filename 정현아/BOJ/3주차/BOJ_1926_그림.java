package BOJ_1926_그림;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

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

		int n = sc.nextInt(); // n: 행
		int m = sc.nextInt(); // m: 열

		int[][] pic = new int[n][m];

		// 그림 정보 입력 받기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				pic[i][j] = sc.nextInt();
			}
		}

		boolean[][] visited = new boolean[n][m]; // visited: 방문 배열

		Queue<Xy> q = new LinkedList<>(); // q: bfs 쓸 큐
		PriorityQueue<Integer> maxWidth = new PriorityQueue<>(); // maxWidth: 그림 넓이 넣을 우선순위큐

		int max = 0; // max: 최대 넓이 - 처음은 0

		// 상 하 좌 우
		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		// bfs 시작
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				int cntSize = 0; // cntSize: 그림의 넓이 세는 수

				// 만약 그림이고, 방문하지 않았다면
				if (pic[i][j] == 1 && !visited[i][j]) {

					q.add(new Xy(i, j));

					// q가 빌 때까지
					while (!q.isEmpty()) {

						Xy t = q.poll();

						if (visited[t.x][t.y]) {
							continue;
						}

						cntSize++;
						visited[t.x][t.y] = true;

						// 4방향 돌아서 1이고 아직 방문하지 않은 애 찾으면
						for (int d = 0; d < 4; d++) {
							int nr = t.x + dr[d];
							int nc = t.y + dc[d];

							if (nr >= 0 && nc >= 0 && nr < n && nc < m && pic[nr][nc] == 1 && !visited[nr][nc]) {
								q.add(new Xy(nr, nc));
							}

						}

					} // bfs 끝

					maxWidth.add(-cntSize); // 우선순위큐에 넣을때 '-' 붙여서 넣음 => 가장 큰 수가 맨 앞에 오게 하려고

				}
			}
		} // for문 끝

		int size = maxWidth.size();
		System.out.println(size);

		if (size == 0) {
			System.out.println(0);
		} else {
			System.out.println(-maxWidth.poll()); // 출력할 대 '-'를 붙임

		}

	}

}
