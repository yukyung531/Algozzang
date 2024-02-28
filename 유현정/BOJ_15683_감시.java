package Boj_15683;

import java.util.Scanner;

/*
 * 그냥 구현
 * DFS로 방향 정하면서 갱신시키기
 * 
 */
public class Main2 {
	
	static int result = 0;
	static int[][] office;
	static int[] camera;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		office = new int[N][M];
		camera = new int[24]; //최대 8개
		int idx = 0;
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				office[i][j] = sc.nextInt();
				if(office[i][j] != 0 && office[i][j] != 6) {
					camera[idx++] = i;
					camera[idx++] = j;
					camera[idx++] = office[i][j];
				}
			}
		}
		
		DFS(0, 0);
		System.out.println(result);
	}
	
	public static void DFS(int idx, int fin) {
		if(idx*3>=camera.length) {
			return;
		}
		int positioni = camera[idx*3];
		int positionj = camera[idx*3+1];
		int cameraNo = camera[idx*3+2];
		if(cameraNo == 0) {
			if(result<fin) {
				result = fin;
			}
			return;
		}
		
		switch(cameraNo) {
		case 1: 
			for(int i = 0; i<4; i++) {
				No1(positioni, positionj, i, fin);
				DFS(idx++, fin);
			}
			break;
		case 2:
			for(int i = 0; i<2; i++) {
				No2(positioni, positionj, i, fin);
				DFS(idx++, fin);
			}
			break;
		case 3:
			for(int i = 0; i<4; i++) {
				No3(positioni, positionj, i, fin);
				DFS(idx++, fin);
			}
			break;
		case 4:
			for(int i = 0; i<4; i++) {
				No4(positioni, positionj, i, fin);
				DFS(idx++, fin);
			}
			break;
		case 5:
				No5(positioni, positionj, fin);
				DFS(idx++, fin);
			break;
		}
		
		
	}
	
	
	
	static int[] diri = new int[]{0, 1, 0, -1};
	static int[] dirj = new int[] {1, 0, -1, 0};
	
	public static void No1(int i, int j, int direction, int fin) {
			for(int k = 0; k<Math.max(N, M); k++) {
				int newi = i + k*diri[direction];
				int newj = j + k*dirj[direction];			
				if(newi>=0 && newi<N && newj >= 0 && newj<M) {
					if(office[newi][newj] == 6) {
						return;
					}else if(office[newi][newj] == 0) {
						fin++;
						office[newi][newj] = 7; //지나감 표시
					}
				}
			}
	}//1
	
	public static void No2(int i, int j, int direction, int fin) {
			for(int k = 0; k<Math.max(N, M); k++) {
				int newi = i + k*diri[direction];
				int newi2 = i + k*diri[direction*2];
				int newj = j + k*dirj[direction];		
				int newj2 = j + k*dirj[2*direction];
				if(newi>=0 && newi<N && newi2>=0 && newi2<N && newj >= 0 && newj<M&& newj2 >= 0 && newj2<M) {
					if(office[newi][newj] == 6) {
						return;
					}else if(office[newi][newj] == 0) {
						fin++;
						office[newi][newj] = 7; //지나감 표시
					}
				}
			}
		}
	
	public static void No3(int i, int j, int direction, int fin) {
			for(int k = 0; k<Math.max(N, M); k++) {
				int newi = i + k*diri[direction];
				int newj = j + k*dirj[direction];
				int newi2;
				int newj2;
				if(direction>3) {
					newj2 = j + k*dirj[0];
					newi2 = i + k*diri[0];
				}else {
					newj2 = j + k*dirj[direction+1];
					newi2 = i + k*diri[direction+1];					
				}
				if(newi>=0 && newi<N && newi2>=0 && newi2<N && newj >= 0 && newj<M&& newj2 >= 0 && newj2<M) {
					if(office[newi][newj] == 6) {
						return;
					}else if(office[newi][newj] == 0) {
						fin++;
						office[newi][newj] = 7; //지나감 표시
					}
				}
			}
	}
	
	public static void No4(int i, int j, int direction, int fin) {
			for(int k = 0; k<Math.max(N, M); k++) {
				int newi = i + k*diri[direction];
				int newj = j + k*dirj[direction];
				int newi2;
				int newj2;
				int newi3;
				int newj3;
				if(direction>3) {
					newj2 = j + k*dirj[0];
					newi2 = i + k*diri[0];
				}else {
					newj2 = j + k*dirj[direction+1];
					newi2 = i + k*diri[direction+1];					
				}
				if(direction>2) {
					int tmp = direction-4;
					newj3 = j + k*dirj[tmp+2];
					newi3 = i + k*diri[tmp+2];
				}else {
					newj3 = j + k*dirj[direction+2];
					newi3 = i + k*diri[direction+2];
				}
				if(newi>=0 && newi<N && newi2>=0 && newi2<N && newj >= 0 && newj<M&& newj2 >= 0 && newj2<M) {
					if(office[newi][newj] == 6) {
						return;
					}else if(office[newi][newj] == 0) {
						fin++;
						office[newi][newj] = 7; //지나감 표시
					}
				}
			}
		}
	
	public static void No5(int i, int j, int fin) {
			for (int direction = 0; direction < 4; direction++) {
			for (int k = 0; k < Math.max(N, M); k++) {
				int newi = i + k*diri[direction];
				int newj = j + k*dirj[direction];			
				if(newi>=0 && newi<N && newj >= 0 && newj<M) {
					if(office[newi][newj] == 6) {
						break;
					}else if(office[newi][newj] == 0) {
						fin++;
						office[newi][newj] = 7; //지나감 표시
					}
				}
			}
		}
	}//1
	
	

}
