package BOJ_14500_테트로미노;

import java.util.Scanner;

public class Main {
	static int N,M;
	static int[][] map;
	static int maxSum = 0; //최대값 합 저장할 변수
	static int sum = 0; //중간합 저장할 변수
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		
		//map 정보 입력받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					maxSum = Math.max(maxSum, dfs(i, j, 1));
					maxSum = Math.max(maxSum, checkSpecialShape(i,j));
					visited[i][j] = false; //백트래킹
				}
			}
		}
		
		System.out.println(maxSum); //최대 합 출력
		
	}//main
	
	public static int dfs(int x, int y, int count) {
		int sum = 0;
		
		if(count == 4) {
			//sum 구하기
			return map[x][y];
		}
		
		//상하좌우로 이동하는 경우 생각해보기
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
				
			//경계조건 확인하기
			if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
			
			visited[nx][ny] = true;
			sum = Math.max(sum, map[x][y] + dfs(nx, ny, count+1));
			visited[nx][ny] = false;
		}
			
		
		return sum;
	}//dfs
	
	// "ㅗ" 모양에 대한 탐색
    public static int checkSpecialShape(int x, int y) {
        int sum = 0;
        int maxSum = 0;

        // ㅗ 모양의 모든 경우에 대해 탐색
        for (int i = 0; i < 4; i++) {
            sum = map[x][y];
            boolean isValid = true;

            for (int j = 0; j < 3; j++) {
            	//현재 방향에서 상대적인 이동방향 계산
            	int nx = x + dx[(i+j) % 4];
            	int ny = y + dy[(i+j) % 4];

                // 해당 칸이 범위 내에 있고 이미 방문하지 않았는지 확인
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                    isValid = false;
                    break;
                }
                sum += map[nx][ny];
            }

            if (isValid) {
            	maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
