package BOJ_2583_영역구하기;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class XY {
	int x;
	int y;

	public XY(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // M: 행
		int N = sc.nextInt(); // N: 열

		int[][] map = new int[M][N]; // map: 모눈종이
		boolean[][] visited = new boolean[M][N]; // 방문 체크 배열

		int K = sc.nextInt(); // K: 직사각형의 개수

		for (int k = 0; k < K; k++) {
			int x1 = sc.nextInt(); // x1: 왼쪽 아래 꼭짓점 좌표의 x
			int y1 = sc.nextInt(); // y1: 왼쪽 아래 꼭짓점 좌표의 y

			int x2 = sc.nextInt(); // x2: 오른쪽 위 꼭짓점 좌표의 x
			int y2 = sc.nextInt(); // y2: 오른쪽 위 꼭짓점 좌표의 y

			// x 좌표는 열, y 좌표는 행을 나타내며 열은 똑같이 0부터 출발하지만 행은 배열의 경우 맨 왼쪽 꼭대기가 0이기 때문에 전체(M)에서
			// 빼준다
			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					map[M - 1 - i][j] = -1;
				}
			}

		} // 좌표 모두 입력 & 직사각형 부분 체크 완료

		// 상 하 좌 우 델타
		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		PriorityQueue<Integer> pq = new PriorityQueue<>(); // pq: 영억의 개수 넣기
		Queue<XY> bfs = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				int sizeNumber = 0; // sizeNumber: 영역의 크기
				// 만약 직사각형에 포함되지 않고 방문하지 않은 곳이라면 새로운 영역이다!
				if (map[i][j] != -1 && !visited[i][j]) {

					bfs.add(new XY(i, j)); // bfs에 넣고

					// bfs가 빌 때까지 실행
					while (!bfs.isEmpty()) {
						XY t = bfs.poll();

						if (visited[t.x][t.y] == true) {
							continue;
						}
						sizeNumber++; // queue에서 꺼낼 때마다 영역 크기 +1

						// 꺼낸 정점의 상하좌우 탐색
						for (int d = 0; d < 4; d++) {
							int nr = t.x + dr[d];
							int nc = t.y + dc[d];

							// 만약 상하좌우에 해당하는 정점이 비어 있고 방문하지 않은 곳이라면 queue에 넣음
							if (nr >= 0 && nc >= 0 && nr < M && nc < N && map[nr][nc] != -1) {
								visited[t.x][t.y] = true;

								bfs.add(new XY(nr, nc));
							}
						}

					}

					pq.add(sizeNumber);

				}

			}
		} // bfs 끝

		int size = pq.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.print(pq.poll() + " ");
		}
	}

}
