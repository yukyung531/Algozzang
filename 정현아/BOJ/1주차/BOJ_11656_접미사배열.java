package BOJ_11656_접미사배열_S4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();		//str: 문자열
		int len = str.length();		//len: 문자열의 길이
		String[] suffixArr = new String[len];	//suffixArr: 접미사 문자열 모음 배열
		
		// 접미사 만드는 for문
		for(int i=0; i<len; i++) {
			suffixArr[i] = str.substring(i);	//substring(i): i부터 끝까지
		}
		
		Arrays.sort(suffixArr);	//사전순 정렬
		
		//출력
		for(int i=0; i<len; i++) {
			System.out.println(suffixArr[i]);
		}
		
	}

}

