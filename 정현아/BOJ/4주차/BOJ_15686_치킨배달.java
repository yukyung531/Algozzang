package BOJ_15686_치킨배달;

import java.util.Scanner;

//1. N(집의 크기), M(치킨집 중 골라야 할 최대 갯수) 입력받기
//2. 도시 정보 받을 map 배열과 집의 좌표를 가진 house 배열, 치킨 집의 배열을 가진 chicken 배열 선언후 입력 받기
//	이때, 집의 갯수를 세는 houseNum과 치킨집의 갯수를 세는 chickenNum도 ++ 하면서 세기
//3. dfs을 이용한 조합을 만들면서
//4. house 배열을 houseNum만큼 돌리면서 각각의 집마다 치킨 거리를 구한 뒤 더한다
//5. 4번의 최소 값을 찾으면 끝

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Main {
	public static int N;		// N: 도시의 크기 (NxN)
	public static int M;		// M: 치킨집 중 최대 골라야 할 갯수
	public static int[][] map;		// map: 도시 지도
	public static Node[] house;		// house: 집의 좌표를 가진 배열
	public static Node[] chicken;	// chicken: 치킨집 좌표를 가진 배열
	public static int houseNum;		// houseNum: 집의 개수
	public static int chickenNum;	// chickenNum 치킨집의 개수
	public static Node[] tmp;		//tmp: 조합을 위한 임시 배열
	public static int distanceResult;		// distanceResult: 제일 작은 치킨 거리

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		M = sc.nextInt(); 

		map = new int[N][N];

		house = new Node[2 * N]; 	//집의 최대 개수는 2N을 넘지 않기 때문에
		chicken = new Node[13]; 	//최대 개수는 13보다 작거나 같기 때문에

		houseNum = 0; 
		chickenNum = 0; 

		// 도시 정보 입력 받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt(); // 정보 입력 받고
				// 만약 집을 입력 받았다면
				if (map[i][j] == 1) {
					house[houseNum++] = new Node(i, j); // 집의 좌표 house에 저장
				} else if (map[i][j] == 2) {
					chicken[chickenNum++] = new Node(i, j); // 만약 치킨집을 입력 받았다면 chicken에 저장

				}
			} // j
		} // i
		
		distanceResult = Integer.MAX_VALUE;		//최소를 구하는 거니까 최대로 세팅
		tmp = new Node[M];
		
		dfs(0, 0);
		
		System.out.println(distanceResult);

	}// main
	
	public static void dfs(int idx, int sidx) {
		//해당 조합을 찾으면
		if(sidx == M) {
			int sum = 0;	//치킨 거리 합
			//4. house 배열을 houseNum만큼 돌리면서 각각의 집마다 치킨 거리를 구한 뒤 더한다
			for(int i=0; i<houseNum; i++) {
				int distance1 = Integer.MAX_VALUE;			//일단 최대값으로 세팅
				// tmp 배열을 M만큼 돌리기도 해야 함
				for(int j=0; j<M; j++) {
					//현재 집하고 치킨집 사이의 방문 거리를 잰다
					int distance2 = Math.abs(house[i].x-tmp[j].x) + Math.abs(house[i].y-tmp[j].y);
					//방금 잰 게 더 짧은 거리면 change
					if(distance2 < distance1) {
						distance1=distance2;
					}
				}
				//치킨 거리합에 추가
				sum += distance1;
			}
			
			//만약 최소값보다 작으면 갱신
			if(sum <distanceResult) {
				distanceResult = sum;
			}

			
			return;
		}
		
		if(idx == chickenNum)
			return;
		
		
		tmp[sidx] = chicken[idx];
		dfs(idx+1, sidx+1);
		dfs(idx+1, sidx);
		
	}

}