/**
 * 솔직 고백합니다... 답을 봤습니다..........
 */

package BOJ_2533_사회망서비스_G3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static List<Integer>[] list;
	static boolean[] visited;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // N: 친구 관계 트리의 정점 개수

		list = new ArrayList[N + 1]; // list: 친구 관계 나타내는 리스트

		// 초기화
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		// 친구 관계 입력받고
		for (int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			list[a].add(b);
			list[b].add(a);

		}

		visited = new boolean[N + 1]; // visited: 방문 체크 배열
		dp = new int[N + 1][2]; // dp: 0은 얼리어답터 아닐때, 1은 얼리어답터일 때

		dpTree(1);

		System.out.println(Math.min(dp[1][0], dp[1][1]));

	}

	public static void dpTree(int n) {
		visited[n] = true; // 여기 온 순간 방문한 거임
		dp[n][1] = 1; // n이 얼리어답터일 때 => 본인을 세야 하니 일단 1

		for (int i = 0; i < list[n].size(); i++) {
			int child = list[n].get(i); // child: n노드의 i번째 자식
			// 만약 방문한 자식이면 넘겨
			if (visited[child])
				continue;
			// 방문하지 않은 자식이면 dp dfs 돌려
			dpTree(child);
			dp[n][0] += dp[child][1]; // n이 얼리어답터가 아니라면 자식은 반드시 얼리어답터
			dp[n][1] += Math.min(dp[child][0], dp[child][1]); // n이 얼리어답터일때 아래는 얼리어답터일수도 아닐 수도 있고, 더 작은 애 데리고 와

		}

	}

}
