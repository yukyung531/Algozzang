package BOJ_2533;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static boolean[] visited;
	static int[][] dp;
	static List<Integer>[] list;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 간선 연결
		for (int i = 1; i < N; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			list[u].add(v);
			list[v].add(u);
		}
		
		dp = new int[N+1][2];
		visited = new boolean[N+1];
		
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
		
	}//main
	
	public static void dfs(int cur) {
		visited[cur] = true;
		dp[cur][0] = 0; //해당 number가 얼리어답터가 아닌 경우
		dp[cur][1] = 1; //해당 number가 얼리어답터인 경우
		
		for(int child : list[cur]) {
			if(!visited[child]) {
				dfs(child);
				dp[cur][0] += dp[child][1]; //자식 노드가 무조건 얼리어답터여야 함
				dp[cur][1] += Math.min(dp[child][0], dp[child][1]); //자식이 얼리어답터든, 아니든 상관없음
			}
		}
	}
}
