package boj_2533;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
 * 1. 입력(내 자식 모두 표시)
 * 2.	-1. 연결한 경우 -> dp[son]들의 최솟값 더하고 +1
 * 		-2. 연결 안 한 경우 -> dp[son][1]들 더하기
 * 
 * dp -> 최적부분해가 최적해?
 * 	-> 서브트리 부터 구해야 하면 밑에서부터?, 후위 순회 이용
 * 
 * https://www.youtube.com/watch?v=a-cjNNPaJCo 추천
 */
public class Main4 {
	static int n;
	static ArrayList<Integer>[] friend;
	static boolean[] visited;
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		friend = new ArrayList[n+1];
		visited = new boolean[n+1];
		dp = new int[n+1][2];
		
		for(int i = 0; i<n+1; i++) {
			friend[i] = new ArrayList<Integer>();
		}
		
		//나[인덱스]에 전체 연결 노드 번호 넣기
		for(int i = 1; i<n; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			friend[second].add(first);
			friend[first].add(second);
		}
		
		dynamicProgramming(1);
		
		int result = Math.min(dp[1][0], dp[1][1]);
		System.out.println(result);

	}
	
	static void dynamicProgramming(int start) {	
		if(visited[start]) {
			return;
		}
		visited[start] = true;
		//후위 순회
		for(int i = 0; i<friend[start].size(); i++) {
			int son = friend[start].get(i);
			if(!visited[son]) {
				dynamicProgramming(son);
				
				dp[start][0] += dp[son][1];
				dp[start][1] += Math.min(dp[son][0], dp[son][1]);
			}
		}
		dp[start][1] += 1; 
	}//dp

}
