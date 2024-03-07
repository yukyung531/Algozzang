package BOJ_15683_감시;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class CCTV {
	int num;
	int x;
	int y;

	CCTV(int num, int x, int y) {
		this.num = num;
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int min = Integer.MAX_VALUE; //최솟값 저장할 변수
	static int count;
	static int N,M;
	static int[][] map;
	static int[][] copyMap;
	static boolean[][] visited;
	public static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌 시계방향 순서 
	public static int[] dy = {0, 1, 0, -1};
	static ArrayList<CCTV> cctvList = new ArrayList<>();
	static int[] perm;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //세로 크기
		M = sc.nextInt(); //가로 크기
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				
				//CCTV 정보 입력
				if(map[i][j] != 0 && map[i][j] != 6) {
					cctvList.add(new CCTV(map[i][j], i, j));
				}
			}
		}
		
		perm = new int[cctvList.size()]; //순열 담을 배열
		permutation(0, cctvList.size());
		
		System.out.println(min);
		
	}//main
	

	//DFS로 상하좌우 4방향 중에서 cctv의 총 개수, r만큼을 순서대로 뽑는 순열
	public static void permutation(int depth, int r) {
		if(depth == r) {
			copyMap = new int[N][M];
			for (int i = 0; i < map.length; i++) {
				System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
			}
			
			//cctv 번호와 순열로 뽑혀진 방향에 맞는 상하좌우 방향 설정
			for (int i = 0; i < cctvList.size(); i++) {
				direction(cctvList.get(i), perm[i]);
			}
			
			//사각지대 구하기
			getBlindSpot();
			
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			perm[depth] = i;
			permutation(depth+1, r);
		}
	}//permutation
	
	//각 CCTV 번호와 순열로 뽑혀진 방향에 맞게 감시
	public static void direction(CCTV cctv, int d) {
		int cctvNum = cctv.num;
		
		if(cctvNum == 1) {
			if(d == 0) watch(cctv, 0); // 상 
			else if(d == 1) watch(cctv, 1); // 우 
			else if(d == 2) watch(cctv, 2); // 하  
			else if(d == 3) watch(cctv, 3); // 좌 
		} else if(cctvNum == 2) {
			if(d == 0 || d == 2) {
				watch(cctv, 0); watch(cctv, 2); // 상하 
			} else {
				watch(cctv, 1); watch(cctv, 3); // 좌우 
			}
		} else if(cctvNum == 3) {
			if(d == 0) {
				watch(cctv, 0); // 상우 
				watch(cctv, 1);
			} else if(d == 1) { 
				watch(cctv, 1); // 우하 
				watch(cctv, 2);
			} else if(d == 2) { 
				watch(cctv, 2); // 하좌 
				watch(cctv, 3);
			} else if(d == 3) { 
				watch(cctv, 0); // 좌상 
				watch(cctv, 3);
			}
		} else if(cctvNum == 4) {
			if(d == 0) {
				watch(cctv, 0); // 좌상우 
				watch(cctv, 1);
				watch(cctv, 3);
			} else if(d == 1) {
				watch(cctv, 0); // 상우하 
				watch(cctv, 1);
				watch(cctv, 2);
			} else if(d == 2) {
				watch(cctv, 1); // 좌하우 
				watch(cctv, 2);
				watch(cctv, 3);
			} else if(d == 3) {
				watch(cctv, 0); // 상좌하 
				watch(cctv, 2);
				watch(cctv, 3);
			}
		} else if(cctvNum == 5) { // 상우하좌
			watch(cctv, 0);
			watch(cctv, 1);
			watch(cctv, 2);
			watch(cctv, 3);
		}
	}//direction
	
	
	public static void watch(CCTV cctv, int dir) {
        Queue<CCTV> queue = new LinkedList<>();
        queue.add(cctv);
        boolean[][] visited = new boolean[N][M];
        visited[cctv.x][cctv.y] = true;
        
        while (!queue.isEmpty()) {
            CCTV now = queue.poll();
        	int nx = now.x + dx[dir];
        	int ny = now.y + dy[dir];
        	
        	// 경계조건 체크
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || copyMap[nx][ny] == 6) break;
            
            if(copyMap[nx][ny] == 0) { //빈칸이라면 감시할 수 있으므로
            	copyMap[nx][ny] = -1;
            	queue.add(new CCTV(cctv.num, nx, ny));
            }else { //다른 CCTV가 있거나 이미 감시된 칸이라면
            	queue.add(new CCTV(cctv.num, nx, ny)); //그냥 통과
            }
            
        }
    }//watch
	
	//사각지대 개수 구하기
	public static void getBlindSpot() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		min = Math.min(min, cnt);
	}//getBlindSpot
}
