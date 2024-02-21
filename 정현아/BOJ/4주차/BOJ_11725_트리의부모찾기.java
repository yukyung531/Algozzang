//틀림 힝...

package BOJ_11725_트리의부모찾기;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
	static boolean[] visited;			//visited: 각 노드 방문했는지 확인하는 배열
	static int[] parent;				//parent: 부모 저장 배열
	static ArrayList<Integer>[] tree;	//tree: 인접리스트 배열
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();	//N: 노드의 개수
		
		visited = new boolean[N+1];	
		parent = new int[N+1];
		tree = new ArrayList[N+1];
		
		//tree 초기화
		for (int i = 1; i <= N; i++) {
		    tree[i] = new ArrayList<Integer>();
		}

		for(int i=0; i<N-1; i++) {
			int node1 = sc.nextInt();	//node1: 입력 받는 첫 node
			int node2 = sc.nextInt();	//node2: 입력 받는 나중 node

			tree[node1].add(node2);		//서로 넣기
			tree[node2].add(node1);
			

		}//입력 for문
		
		dfs(1);		//dfs: 부모 찾기
		
		for(int i=2; i<=N; i++) {
			System.out.println(parent[i]);
		}
		
	}//main
	
	public static void dfs(int node) {
		visited[node] = true;		//현재 방문 한곳 방문 체크하고
		
		//현재 방문 노드의 리스트 사이즈만큼 돌릴 것
		for(int i=0; i< tree[node].size(); i++) {
			//for문 돌리면서 나오는 애가 다음 노드임
			int nextNode = tree[node].get(i);
			//만약 다음 노드에 방문하지 않았다면
			if(!visited[nextNode]) {
				//다음 노드의 부모는 현재 노드
				parent[nextNode] = node;
				//그리고 다음 노드 dfs 돌려서 더 깊숙히 가장 아래의 트리 노드까지 찾기
				dfs(nextNode);
			}
		}
	}

}
