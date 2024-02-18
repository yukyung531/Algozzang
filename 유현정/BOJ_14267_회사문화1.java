package boj_14277;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //직원 수
		int m = sc.nextInt(); //칭찬 수
		ArrayList<Integer>[] subordinate = new ArrayList[n+1];
		int[] employer = new int[n+1]; //[]칭찬
		int junk = sc.nextInt(); //사장 상사: -1 빼기
		subordinate[1] = new ArrayList<Integer>();
		/*
		 *상사인덱스에 부하직원 입력 
		 */
		for(int i = 2; i<=n; i++) {
			int boss = sc.nextInt();
			subordinate[i] = new ArrayList<Integer>();
			subordinate[boss].add(i);
		}
		/*
		 * 칭찬 받은 직원번호 인덱스에 칭찬 수치w
		 */
		for(int i = 0; i<m; i++) {
			int employeeNumber = sc.nextInt();
			int w = sc.nextInt();
			employer[employeeNumber] = w;
		}
		/*
		 * 직속 부하 직원에게 더하기
		 */
		for(int i = 2; i<n; i++) {
			int completion = employer[i];
			for(int j = 0; j<subordinate[i].size(); j++) {
				int employeeNumber = subordinate[i].get(j);
				employer[employeeNumber] += completion;
			}
		}
		for(int i = 1;i<=n;i++) {
			System.out.print(employer[i]+" ");
		}
		
	}

}
