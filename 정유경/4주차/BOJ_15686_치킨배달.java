package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_15686_치킨배달 {
	static int N,M,minCnt;
	static List<int[]> home;
	static List<int[]> chicken;
	static int[][] chickenTmp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //도시 크기
		M = sc.nextInt(); //최대로 고를 수 있는 치킨집 개수
		minCnt = Integer.MAX_VALUE; //최솟값 저장할 변수 최대로 초기화
		home = new ArrayList<>(); //집 좌표 저장
		chicken = new ArrayList<>(); //치킨집 좌표 저장
		
		//치킨집, 집 좌표 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int tmp = sc.nextInt();
				if(tmp == 1) {
					home.add(new int[] {i,j});
				}
				else if(tmp == 2) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		
		chickenTmp = new int[chicken.size()][2]; //치킨집 고른 후 좌표 저장
		DFS(0,0);
		
		System.out.println(minCnt);
	}//main
	
	public static void DFS(int cnt, int start) {
		if(cnt == M) {
			diffDistance();
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			chickenTmp[cnt][0] = chicken.get(i)[0];
			chickenTmp[cnt][1] = chicken.get(i)[1];
			DFS(cnt+1, i+1);
		}
	}//DFS
	
	public static void diffDistance() {
		//도시의 치킨거리
		int minDistance = 0;
		
		for (int i = 0; i < home.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				min = Math.min(min, dist(chickenTmp[j][0], home.get(i)[0], chickenTmp[j][1], home.get(i)[1]));
			}
			minDistance += min;
		}
		
		minCnt = Math.min(minCnt, minDistance);
		return;
	}
	
	//거리 구하는 메서드
	public static int dist(int x1, int x2, int y1, int y2) {
		return (Math.abs(x1-x2) + Math.abs(y1-y2));
	}
}
