package BOJ_2583;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] board;
	static int[] movei = new int[] {0, 0, 1, -1};
	static int[] movej = new int[] {1, -1, 0, 0};
	static boolean[][] visited;
	static ArrayList<Integer> al = new ArrayList<>();
	static int tmparea;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		int K = sc.nextInt();
		
		board = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i<K; i++) {
			int fi = sc.nextInt();
			int fj = sc.nextInt();
			int li = sc.nextInt()-1;
			int lj = sc.nextInt() -1;
			for(int j = fi; j<=li; j++) {
				for(int k = fj; k<=lj; k++) {
					board[j][k]++;
				}
			}
		
		}
		
		
		int time = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(board[i][j] == 0 && !visited[i][j]) {
					time++;
					visited[i][j] = true;
					tmparea = 1;
					find(i, j);
					al.add(tmparea);
				}
			}
		}
		Collections.sort(al);
		System.out.println(time);
		for(int i = 0; i<al.size(); i++) {
			System.out.print(al.get(i)+" ");
		}
		
		
	}
	
	public static void find(int i, int j) {
		for(int k = 0; k<4; k++) {
			int newi = i+movei[k];
			int newj = j+movej[k];
			if(newi>=0 && newi<N && newj >=0 && newj<M) {
				if(!visited[newi][newj] && board[newi][newj] == 0) {
					visited[newi][newj] = true;
					tmparea++;
					find(newi, newj);
				}
			}
		}
		return;
	}

}
