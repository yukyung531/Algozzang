package BOJ_2529_부등호;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static boolean[] visited = new boolean[10]; //숫자 선택 여부 체크 배열
	static int K;
	static char[] sign; //부등호 저장할 배열
	static List<String> answer = new ArrayList<>(); //정답 저장할 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		K = sc.nextInt();
		sign = new char[K];
		//부등호 정보 입력받기
		for (int i = 0; i < sign.length; i++) {
			sign[i] = sc.next().toCharArray()[0];
		}
		
		//0부터 탐색 시작
		dfs(0, "");
		
		//0부터 탐색 시작했으므로 따로 정렬 안해줘도 맨 앞에 있는 수가 최소, 맨 뒤에 있는 수가 최대
		System.out.println(answer.get(answer.size()-1));
		System.out.println(answer.get(0));
		
	}//main
	
	public static void dfs(int idx, String a) {
		if(idx == K+1) {
			answer.add(a);
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if(!visited[i]) {
				if(idx == 0 || check(Character.getNumericValue(a.charAt(idx-1)), i , sign[idx-1])) {
					visited[i] = true;
					dfs(idx+1, a + Integer.toString(i));
					visited[i] = false;
				}
				
			}
		}
	}
	
	//부등호 만족하는지 체크하는 메서드
	public static boolean check(int a, int b, char c) {
		if(c == '<') {
			if(a<b) {
				return true;
			}
		} else if(c == '>') {
			if(a>b) {
				return true;
			}
		}
		return false;
	}
}
