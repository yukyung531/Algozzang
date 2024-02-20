package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11725_트리의부모찾기 {
	static int N; //노드 개수
	static int[] parent; //부모노드 저장
	static boolean[] isVisit;
	static ArrayList<Integer> list[]; //노드 저장
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		isVisit = new boolean[N+1];
		list = new ArrayList[N+1];
		parent = new int[N+1];
		
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int i = 0; i < N-1; i++) {
			//연결된 노드의 값 입력받기
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		DFS(1); //트리 루트 1
		
		for (int i = 2; i < parent.length; i++) {
			System.out.println(parent[i]);
		}
		
	}//main
	
	public static void DFS(int index) {
		isVisit[index] = true;
		for (int i : list[index]) {
			if(!isVisit[i]) {
				parent[i] = index;
				DFS(i);
			}
		}
	}
}
