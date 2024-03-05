package Boj_1759;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 최소 1개의 모음 + 최소 2개의 자음
 * 서로 다른 알파벳 소문자로 구성
 * 오름차순
 * 
 *처음부터 배열 해서 만들어?
 *만들고 배열해?
 *
 *최대 15개 문자 주어짐 -> 뽑기 10000개 -> 정렬 O(nlogn~n^2) 최대 1초
 *시간 백트래킹 안 해도 괜찮을 듯?
 *
 * 2초 128MB
 * 1. 모음 따로 넣기(순서대로)
 * 2. 자음 따로 넣기(순서대로)
 * 3. 조합 구성(최소 1개의 모음+최소 2개의 자음)-> 모음 1~L-2/ 자음 L-1~2개 뽑기
 * 4. 정렬
 * 
 * or 
 * 
 * 순서대로 뽑고, 조건에 맞는지 체크
 */
public class Main {
	static int L;
	static int C;
	static List<String> vowels;
	static List<String> consonants;
	static String[] word;
	static List<String> wordList;
	static int vowelsNumber;
	static int consonantsNumber;
	static int maxTry;
	static int i;
	static StringBuilder stringBuilder;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = Integer.parseInt(sc.next());
		C = Integer.parseInt(sc.next());
		
		vowels = new ArrayList<>();
		consonants = new ArrayList<>();
		
		for(int i = 0; i<C; i++) {
			String alphabet = sc.next();
			if(alphabet.equals("a") || alphabet.equals("e") || alphabet.equals("i") || alphabet.equals("o") || alphabet.equals("u")) {
				vowels.add(alphabet);
			}else {
				consonants.add(alphabet);
			}
		}
		word = new String[L];
		wordList = new ArrayList<>();
		vowelsNumber = vowels.size();
		consonantsNumber = consonants.size();
		maxTry = Math.min(vowelsNumber, Math.min(consonantsNumber-1, L-2));
//		System.out.println(maxTry);
		//자음이 L-1개 이상 있지 않으면 1개부터 불가
		int init = Math.max(1, L-consonantsNumber);
		//뽑기
		for(i = init; i<init+maxTry; i++) {
			pick(i, 0, 0, 0, vowelsNumber, vowels);
		}
		//순서 맞추기
		Collections.sort(wordList);
		
		for(int i = 0; i<wordList.size(); i++) {
			String words = wordList.get(i);
			System.out.println(words);
			
		}
		
	}
	
	//모음뽑기-> 자음 뽑기
	public static void pick(int n, int count, int wordIdx, int idx, int number, List<String> alphabet) {//n: 뽑을 개수, count: 뽑은 개수
		//가능 없음
		if(n-count>number - idx) {
			return;
		}
		//자음 or 모음에서 다 셈
		if(n == count) {
//			System.out.println(Arrays.toString(word));
			//자음 모음 다 돌음
			if(wordIdx >= L) {
				stringBuilder = new StringBuilder();
				String[] tmp = word.clone();
				Arrays.sort(tmp);
				for(int i = 0; i<L; i++) {
					stringBuilder.append(tmp[i]);
				}
				String tmpWord = stringBuilder.toString();
				wordList.add(tmpWord);
				return;
			}
			//아직 안 센 곳으로 가기(모->자)
			pick(L-i, count-i, wordIdx, 0, consonantsNumber, consonants);
			return;
		}
		if(wordIdx>=L) {
			return;
		}
		//뽑음
		word[wordIdx] = alphabet.get(idx);
		pick(n, count+1, wordIdx+1, idx+1, number, alphabet);
		//안 뽑음
		pick(n, count, wordIdx, idx+1, number, alphabet);
	}
}
