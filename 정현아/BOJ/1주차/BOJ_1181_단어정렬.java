package BOJ_1181_단어정렬_S5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // N: 단어의 개수
		Set<String> word = new HashSet<>(); // 중복 제거를 위해 set 선언

		// N번만큼 for문을 돌리면서 set에 단어 추가
		for (int i = 0; i < N; i++) {
			word.add(sc.next());
		}

		String[] spell = word.toArray(new String[0]); // set을 배열로 변경

		Arrays.sort(spell); // 사전순 정렬

		int size = spell.length; // size: spell 배열의 크기

		// 버블 정렬
		for (int i = 0; i < size - 1; i++) {
			for (int j = 1; j < size-i; j++) {
				// 만약 spell[i]가 spell[j]보다 길이가 길면 swap
				if (spell[j-1].length() > spell[j].length()) {
					String tmp = spell[j];
					spell[j] = spell[j-1];
					spell[j-1] = tmp;
				}
			}
		}

//		// 선택 정렬
//		for (int i = 0; i < size; i++) {
//			int minLen = i;
//			for (int j = i + 1; j < size; j++) {
//
//				if (spell[j].length() < spell[minLen].length()) {
//					minLen = j;
//				}
//			}
//
//			String tmp = spell[i];
//			spell[i] = spell[minLen];
//			spell[minLen] = tmp;
//
//		}

		// 출력
		for (int i = 0; i < size; i++) {
			System.out.println(spell[i]);
		}

	}

}


