package week2;

import java.util.Scanner;

public class BOJ_9935_문자열폭발 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next(); //전체 문자열
		String find = sc.next(); //폭발 문자열
		boolean flag = true; //false로 바뀌면 출력
		
		while(flag) {
			int slen = str.length();
			int flen = find.length();
			
			ex: for (int i = 0; i < str.length(); i++) {
				
				if(str.length() <= 0) {
					flag = false;
				}
				
				if(i+flen-1 < slen) {
					if(str.substring(i,i+flen).equals(find)) {
					//문자열 제외하고 이어붙이기
					str = str.substring(0, i) + str.substring(i+flen, slen);
					slen = str.length();
					continue;
//					System.out.println(str);
					}
				}
				else {
//					System.out.println(str);
					flag = false;
				}
			}
		}
		
		if(flag == false) {
			if(str.length() == 0) {
				System.out.println("FRULA");
			}else {
				System.out.println(str);
			}
		}
		
	}
	
}
