package BOJ_1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int L;
	static int C;
	static String[] list; //주어지는 문자열 저장할 배열
	static boolean[] visited; //방문 여부 체크할 배열
	static int consonants; //자음 개수
	static int vowels; //모음 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().trim().split(" ");
		L = Integer.parseInt(a[0]);
		C = Integer.parseInt(a[1]);
		
		//주어지는 문자열 저장
		list = br.readLine().trim().split(" ");
		Arrays.sort(list); //사전순으로 정렬
		
		//변수 초기화
		visited = new boolean[C];
		consonants = 0;
		vowels = 0;
		
		//조합찾기
		comb(0, "");
		
	}//main
	
	public static void comb(int idx, String str) {
		if(idx == L) {
			//모음이 1개 이상이고, 자음이 2개 이상인지 체크
			if(vowels>=1 && consonants >=2) {
				System.out.println(str);				
			}
			return;
		}
		
		for (int i = idx; i < list.length; i++) {
			//방문여부 체크
			if(!visited[i]) {
				//글자 순서 체크
				if(idx == 0 || (str.charAt(idx-1) < list[i].charAt(0))) {
					//모음일 경우
					if(list[i].equals("a") || list[i].equals("e") || list[i].equals("i") || list[i].equals("o") || list[i].equals("u")) {
						vowels++;
						visited[i] = true;
						comb(idx+1, str + list[i]);
						
						//방문처리 및 모음 개수 초기화
						visited[i] = false;
						vowels--;
					}
					//자음일 경우
					else {
						consonants++;
						visited[i] = true;
						comb(idx+1, str + list[i]);
						
						//방문처리 및 자음 개수 초기화
						visited[i] = false;
						consonants--;
					}
				}
			}
		}
	}//comb
}
