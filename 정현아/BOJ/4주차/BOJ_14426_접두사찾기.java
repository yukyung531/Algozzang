//startsWith 메소드 - 처음 알았음
package BOJ_14426_접두사찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//N: 집합에 포함되는 문자열 개수
		int M = Integer.parseInt(st.nextToken());	//M: 접두사인지 확인하는 문자열의 개수
		
		String[] stringArr = new String[N];
		
		//N개 문자열 입력 받고
		for(int i=0; i<N; i++) {
			stringArr[i] = br.readLine();
		}
		
		int total = 0;			//total: 접두가 가능한 개수
		
		//M개를 입력받으면서 하나씩 검사할 것
		for(int i=0; i<M; i++) {
			String checkTmp = br.readLine();	//checkTmp: 접두사인지 확인할 문자열
			int tmpLen = checkTmp.length();		//tmpLen: checkTmp의 길이
			
			//stringArr에 저장한 문자열과 비교할 것임
			for(int j=0; j<N; j++) {
				// 여기서 && 뒷 부분 안 했더니 시간 초과 났음
				//만약 checkTmp의 길이보다 stringArr[j]의 길이가 같거나 길고 && checkTmp 마지막 글자와 stringArr[j]의 checkTmp 마지막 인덱스와 같은 인덱스 글자가 같으면
				if(stringArr[j].length()>=tmpLen && stringArr[j].charAt(tmpLen-1) == checkTmp.charAt(tmpLen-1) ) {
					//그때 startsWith인지 확인해서 접두사 맞으면 total ++
					if(stringArr[j].startsWith(checkTmp)) {
					total++;
					break;
					}
				}
			}
		}
		
		bw.write(total+"\n");
		bw.flush();
		
		br.close();
		bw.close();
		
	}

}
