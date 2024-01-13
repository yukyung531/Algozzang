import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class BOJ_1181_단어정렬 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 중복제거를 위해
		LinkedHashSet s = new LinkedHashSet();

		for (int i = 0; i < N; i++) {
			s.add(sc.next());
		}

		// 문자배열로 만들기
		Object[] strArr = s.toArray();

		// 사전 순으로 정렬
		Arrays.sort(strArr);

		// 버블 정렬로 길이순 정렬
		for (int i = 0; i < strArr.length - 1; i++) {
			for (int j = 1; j <= strArr.length - i - 1; j++) {
				if (((String) strArr[j - 1]).length() > ((String) strArr[j]).length()) {
					String tmp = (String) strArr[j];
					strArr[j] = strArr[j - 1];
					strArr[j - 1] = tmp;
				}
			}
		}

		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}

	}
	// main

}
