package BOJ_14267_회사문화1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static List<Integer>[] employee;
	static int[] good;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // N: 회사 직원 수
		M = Integer.parseInt(st.nextToken()); // M: 칭찬 횟수

		employee = new ArrayList[N + 1]; // 회사 직원의 직속상사가 누군지

		good = new int[N + 1]; // 각 직원이 칭찬 받은 횟수

		// 초기화
		for (int i = 0; i < N + 1; i++) {
			employee[i] = new ArrayList<>();
		}

		StringTokenizer st2 = new StringTokenizer(br.readLine());

		int tmp = Integer.parseInt(st2.nextToken());
		employee[1].add(-1);

		// 직속상사 입력 받기
		for (int i = 2; i < N + 1; i++) {
			int a = Integer.parseInt(st2.nextToken());

			employee[i].add(a);
			employee[a].add(i);
		}

		//일단 칭찬 배열에 칭찬 받은 직원의 숫자에 칭찬 수치를 저장함
		for (int i = 0; i < M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st3.nextToken()); // num: 직속 사사로부터 칭찬을 받은 직원 번호
			int w = Integer.parseInt(st3.nextToken()); // w: 칭찬의 수치

			good[num] += w;
		}
		
		dfs(1);	//dfs 돌리기

		for (int i = 1; i < N + 1; i++) {
			bw.write(good[i] + " ");
		}

		bw.write("\n");
		bw.flush();
		bw.close();

	}

	//시간 초과나서 답 참고함
	public static void dfs(int index) {
		int size = employee[index].size();	//size: index번째 노드에 연결된 부하들 (이 중 1번째는 무조건 직속상사임)
		
		//직속상사 빼고 나머지 돌리면서
		for(int i=1; i<size; i++) {
			//해당 부하 노드의 칭찬 수치에 현재 노드의 칭찬 수치를 더함
			good[employee[index].get(i)] += good[index];
			//그 밑 부하까지 전부
			dfs(employee[index].get(i));
		}
		
	}
	
//	public static void bfs(int index, int w) {
//		boolean[] visited = new boolean[N + 1]; // 방문 노드 체크 배열
//		Queue<Integer> queue = new LinkedList<>(); // 노드 방문을 위한 큐
//
//		queue.add(index);
//
//		while (!queue.isEmpty()) {
//			int node = queue.poll();
//
//			visited[node] = true;
//
//			good[node] += w;
//
//			int size = employee[node].size();
//
//			for (int i = 1; i < size; i++) {
//
//				if (!visited[employee[node].get(i)]) {
//					queue.add(employee[node].get(i));
//				}
//			}
//
//		}
//
//	}

}
