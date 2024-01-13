

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11656_접미사배열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();

//		String[] arr = S.split("");

//		for (int i = 0; i < S.length(); i++) {
//			newArr[i] = arr[i];
//			for (int j = i+1; j < S.length(); j++) {
//					newArr[i] += arr[j];
//			}
//			// i
//		}
//		// n
		
		String[] arr = new String[S.length()];
		for(int i =0; i<S.length(); i++) {
			arr[i] = S.substring(i, S.length());
		}
		Arrays.sort(arr);
		for(String str : arr) {
			System.out.println(str);
		}

	}
	// main
}
