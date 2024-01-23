package BOJ_1926;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 1. 입력
 * 2. 세기
 * 3. 출력
 */
public class Main {
	static int length = 0;
	static int width = 0;
	static int[][] canvas;
	static int[] movei = new int[] {0, 0, 1, -1};
	static int[] movej = new int[] {1, -1, 0, 0};
	static boolean[][] visited;
	static int result = 0;
	
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		length = sc.nextInt();
		width = sc.nextInt();
		canvas = new int[length][width];
		
		for(int i = 0; i<length; i++) {
			for(int j = 0; j<width; j++) {
				canvas[i][j] = sc.nextInt();
			}
		}
		
		//연결된 1&개수 세기
		visited = new boolean[length][width];
		int area = 0;
		int time = 0;
		for(int i = 0; i<length; i++) {
			for(int j = 0; j<width; j++) {
				if(canvas[i][j] == 1 && !visited[i][j]) {
					time++;
					visited[i][j] = true;
					tmparea = 1;
					find(i, j);
					if(tmparea>result) {
						result = tmparea;
					}
				}
			}
		}
		System.out.println(time);
		System.out.println(result);
		
	}


	static int tmparea;
	public static void find(int i, int j) {
		for(int k = 0; k<4; k++) {
			int newi = i+movei[k];
			int newj = j+movej[k];
			if(newi>=0 && newi<length && newj >=0 && newj<width) {
				if(!visited[newi][newj] && canvas[newi][newj] == 1) {
					visited[newi][newj] = true;
					tmparea++;
					find(newi, newj);
				}
			}
		}
		return;
	}
	
}
