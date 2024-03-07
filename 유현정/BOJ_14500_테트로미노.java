package Boj_14500;

import java.util.Scanner;

/*
 * 조건: 2초
 * -> 2억회 연산
 * 
 * 한 번 순회 = 25만 -> 2중 for문 불가
 * 완탐 -> 25만 * 4*6*8
 *  
 * 1. 가장 큰 값 찾기
 * 2. 방문 배열 만들기
 * 3. 완탐 갱신(DFS)
 * 	- 나랑 내 전 값에서 4방향 순회
 *  -> 최고값 더해도 안되면 return
 *  
 *  
 */
public class Main {
	static int N;
	static int M;
	static int[][] paper;
	static boolean[][] visited;
	static int max = 0;
	static int maxi = 0;
	static int maxj = 0;
	static int nowValue = 0;
	static int result;
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		paper = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				paper[i][j] = sc.nextInt();
				if(max<paper[i][j]) {
					max = paper[i][j];
					maxi = i;
					maxj = j;
				}
			}
		}
		result = 0;
		DFS(maxi, maxj, maxi, maxj);
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
//				count = 0;
//				nowValue = 0;		
//				System.out.println("st "+i+" "+j);
				DFS(i, j, i, j);
			}
		}
		
		System.out.println(result);
		
	}
	
	static int[] di = new int[] {-1, 0, 1, 0};
	static int[] dj = new int[] {0, -1, 0, 1};
	
	static void DFS(int starti, int startj, int formali, int formalj) {
		//방문 안 했거나, 4번 다 돌았거나, 가망 없을 때 return
		if(visited[starti][startj] || count>=4) {
			return;
		}
//		System.out.println("c: "+count+" "+starti+" "+startj);
		if(result>(4-count)*max+nowValue) {
			return;
		}
		count++;
		nowValue += paper[starti][startj];
		visited[starti][startj] = true;
		if(result<nowValue) {
			result = nowValue;
//			System.out.println("result: "+result+ " i j :"+starti+" "+startj);
		}
		for(int direction = 0; direction<4; direction++) {
			int newi = starti+di[direction];
			int newj = startj+dj[direction];
			if(newi>=0 && newi<N && newj>=0 && newj<M) {
				DFS(newi, newj, starti, startj);
			}
			newi = formali+di[direction];
			newj = formalj+dj[direction];
			if(newi>=0 && newi<N && newj>=0 && newj<M) {
				DFS(newi, newj, starti, startj);
			}
		}
		count--;
		nowValue -= paper[starti][startj];
		visited[starti][startj] = false;
		
		
		
		
		if(nowValue>result) {
			result = nowValue;
		}
		
		
	}

}
