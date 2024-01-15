package BOJ_9935_문자열폭발;

// 답을 봄...........

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine(); // str: 주어지는 문자열

		String boom = br.readLine(); // boom: 폭발 문자열

		Stack<Character> strStack = new Stack<>(); // strStack: 문자열스택

		StringBuilder finalStr = new StringBuilder(); // finalStr: 스택에 남은 문자 합치기 위한 스트링빌더

		// 1. str 길이만큼 돌면서 한 글자씩 자른 뒤, strStack에 넣기
		for (int i = 0; i < str.length(); i++) {
			int count = 0; // count: 폭발 문자열과 몇 개가 일치하는지 세기 위한 변수
			strStack.push(str.charAt(i)); // 일단 문자 하나를 스택에 넣음

			// 2. 스택 사이즈가 폭발 문자열 길이보다 길면 탐색 시작
			if (strStack.size() >= boom.length()) {
				// 3. 폭발 문자열 길이만큼 반복
				for (int j = 0; j < boom.length(); j++) {

					// 4. 스택의 위부터 돌릴 건데, 폭발 문자열의 첫번째부터 비교하려면 현재 스택 사이즈 - 폭발 문자열 + 1을 하면 됨
					if (strStack.get(strStack.size() - boom.length() + j) == boom.charAt(j)) {
						// 일치하면 ++
						count++;
					}

					// 5. 만약 일치 횟수가 폭발 문자열과 같아?
					if (count == boom.length()) {
						// 6. 폭발할 문자열 찾았으니 스택에서 없애버려
						for (int k = 0; k < boom.length(); k++) {
							strStack.pop();
						}
					}

				} // 3

			} // 2
		} // 1

		// 모두 폭발했을 경우
		if (strStack.isEmpty()) {
			System.out.println("FRULA");

			// 아닌 경우 스트링빌더에 추가
			// 이상하게 stack을 돌려서 print 하면 시간 초과 걸림
			// System.out.print가 시간을 오래 잡아먹는 것 같음
		} else {
			for (char ch : strStack) {
				finalStr.append(ch);
			}
		}

		System.out.println(finalStr);

	}// main

}
