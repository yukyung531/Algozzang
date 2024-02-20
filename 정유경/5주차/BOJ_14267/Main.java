package BOJ_14267;

import java.util.*;

public class Main {

	static List<Integer>[] workers;
	static int[] praise;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //직원수
		int M = sc.nextInt(); //칭찬 횟수
		
		workers = new ArrayList[N+1]; //직원들 정보 저장할 배열
		//ArrayList 초기화
		for (int i = 0; i < N+1; i++) {
			workers[i] = new ArrayList<>();
		}
		
		//직속 부하 정보 입력
		for (int i = 1; i <= N; i++) {
			int j = sc.nextInt();
			if(j != -1) {
				workers[j].add(i);
			}
		}
		
		praise = new int[N+1];
		//칭찬 받은 직원들의 칭찬 수치 한 번에 저장
		for (int i = 0; i < M; i++) {
			int cur = sc.nextInt(); //칭찬 받은 직원 번호
			int w = sc.nextInt(); //칭찬 수치
			
			praise[cur] += w;
		}
		
		dfs(1);
		
		//모든 직원들의 칭찬 수치 출력
		for (int i = 1; i < praise.length; i++) {
			System.out.print(praise[i] + " ");
		}
		
	}//main
	
	//단 한 번의 트리 순회를 통해 모든 칭찬값 갱신
	static void dfs(int idx) {
		for(int i : workers[idx]) {
			praise[i] += praise[idx]; //칭찬 수치 누적하기
			dfs(i); //연결된 직속 부하 DFS
		}
	}
}
