package Baek_2583;

import java.io.*;
import java.util.*;

public class Main {
	static int m,n,k;
	static boolean[][] visited;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0 ,-1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		
		map = new int[m][n];
		visited = new boolean[m][n];
		int cnt = 0;
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			int lx = sc.nextInt(); //왼쪽 위 x
			int ly = sc.nextInt(); //왼쪽 위 y
			int rx = sc.nextInt(); //오른쪽 아래 x
			int ry = sc.nextInt(); //오른쪽 아레 y
			for (int y = ly; y < ry; y++) {
				for (int x = lx; x < rx; x++) {
					map[y][x] = 1;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					int now = bfs(i,j);
					list.add(now);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)+" ");
		}
	}
	
	public static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		visited[x][y] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int curX = now[0];
			int curY = now[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = y + dy[i];
				
				if(nx >=0 && ny >= 0 && nx < m && ny <n) {
					if(!visited[nx][ny] && map[nx][ny] == 0) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx,ny});
						cnt++;
					}
				}
			}
				
		}
		
		return cnt;
	}
}
