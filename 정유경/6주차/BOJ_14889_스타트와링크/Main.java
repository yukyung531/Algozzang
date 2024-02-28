package BOJ_14889_스타트와링크;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int min;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		min = Integer.MAX_VALUE;
		visited = new boolean[N];
		
		//능력치 정보 입력받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		comb(0,0); //팀 조합찾기
		
		System.out.println(min);
		
	}//main
	
	public static void comb(int idx, int depth) {
		//팀 조합 완성된 경우
		if(depth == N/2) {
			//두 팀의 능력치 차이 계산하기
			int team_start = 0;
			int team_link = 0;
	 
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					// i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스 
					if (visited[i] == true && visited[j] == true) {
						team_start += map[i][j];
						team_start += map[j][i];
					}
					// i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스 
					else if (visited[i] == false && visited[j] == false) {
						team_link += map[i][j];
						team_link += map[j][i];
					}
				}
			}
			// 두 팀의 점수 차이 (절댓값)
			int val = Math.abs(team_start - team_link);
			
			/*
			 * 두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
			 * 더이상의 탐색 필요없이 0을 출력하고 종료
			 */
			if (val == 0) {
				System.out.println(val);
				System.exit(0);
			}
			
			min = Math.min(val, min); //최솟값 갱신
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(i+1, depth+1);
				visited[i] = false;
			}
		}
		
	}
}
