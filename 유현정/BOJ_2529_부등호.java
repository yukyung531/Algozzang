package Boj_2529;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	//부등호 정수
	// 최대 - 큰 수 부터 넣기
	// 최소 - 작은 수 부터 넣기
	//visited[] 로 중복체크
	//시간 1초 && 메모리 제한 256MB
	//10! = 약 4백만, 8바이트
	//그냥 구현해도 될 듯?
	static int k;
	static String[] inequalitySign;
	static boolean[] maxCheck = new boolean[10]; //인덱스-1 숫자 사용여부 체크
	static boolean[] minCheck;
	static int[] max;
	static int[] min;
	//재귀절 통과 여부 확인
	static boolean last;
	
	public static void main(String[] args) {
		//큰 수 구하기
		Scanner sc = new Scanner(System.in);
		k = Integer.parseInt(sc.next());
		
		inequalitySign = new String[k];
		minCheck = new boolean[k+1]; //인덱스 -1의 숫자 사용여부 체크
		max = new int[k+1];
		min = new int[k+1];
		
		for(int i = 0; i<k; i++) {
			inequalitySign[i] = sc.next();
		}
		
		//큰 수 구하기
			findMax();
			idx = 0;
			findMin();
			for(int i = 0; i<k+1; i++) {
				System.out.print(max[i]);
			}
			System.out.println();
			for(int i = 0; i<k+1; i++) {
				System.out.print(min[i]);
			}
	}
	
	static int idx = 0;
	
	public static void findMax() {
		//부등호 검사
		if(idx > 1) {
			String sign = inequalitySign[idx-2];
			if(sign.equals("<")) {
				if(max[idx-2] > max[idx-1]) {
					last = true;
					return;
				}			
			}else {
				if(max[idx-2] < max[idx-1]) {
					last = true;
					return;
				}
			}			
		}
		//인덱스 검사
		if(idx > k) {
			return;
		}
		//DFS
		for(int i = 9; i>8-k; i--) {
			if(!maxCheck[i]) {
				//초기화
				last = false;
				max[idx] = i;
				maxCheck[i] = true;
				idx++;
				findMax();
				if(idx >k && !last) {
					break;
				}
				idx--;
				maxCheck[i] = false;
			}
		}
	}
	
	//findMax에서 for문 방향만 반대로
	public static void findMin() {
		//부등호 검사
		if(idx > 1) {
			String sign = inequalitySign[idx-2];
			if(sign.equals("<")) {
				if(min[idx-2] > min[idx-1]) {
					last = true;
					return;
				}			
			}else {
				if(min[idx-2] < min[idx-1]) {
					last = true;
					return;
				}
			}			
		}
		//인덱스 검사
		if(idx > k) {
			return;
		}
		//DFS
		for(int i = 0; i<k+1; i++) {
			if(!minCheck[i]) {
				//초기화
				last = false;
				min[idx] = i;
				minCheck[i] = true;
				idx++;
				findMin();
				if(idx >k && !last) {
					break;
				}
				idx--;
				minCheck[i] = false;
			}
		}
		
	}

}
