package BOJ;

import java.io.*;
import java.util.*;


class TrieNode {
    HashMap<Character, TrieNode> children; 
    boolean isEndOfWord; //단어의 끝인지 여부
 
    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

public class BOJ_14426_접두사찾기 {
	static TrieNode root;
	
	//주어진 문자열 트라이에 삽입하는 메서드
    static void insert(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            currentNode.children.putIfAbsent(c, new TrieNode());
            currentNode = currentNode.children.get(c); //현재 노드 방금 집어넣은 문자열로 갱신
        }
        currentNode.isEndOfWord = true;
    }
 
    //검사할 문자열 트라이에서 검색하는 메서드
    static boolean searchWord(String find) {
        TrieNode currentNode = root;
        for (char c : find.toCharArray()) {
            if (!currentNode.children.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.children.get(c);
        }
        return true;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
        String[] str = br.readLine().split(" ");
        int givenStr = Integer.parseInt(str[0]); //주어진 문자열 개수
        int findStr = Integer.parseInt(str[1]); //검사할 문자열 개수
 
        root = new TrieNode(); //트라이 선언
        //주어진 문자열 삽입
        for (int i = 0; i < givenStr; i++) {
            String string = br.readLine();
            insert(string);
        }
 
        int count = 0;
        //문자열 검사
        for (int i = 0; i < findStr; i++) {
            String find = br.readLine();
            if (searchWord(find)) {
                count++;
            }
        }
 
        System.out.println(count);
    }//main
	
	
	//시간초과 풀이
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int N = sc.nextInt(); //문자열 개수
//		int M = sc.nextInt(); //검사해야 하는 문자열 개수
//		
//		String[] str = new String[N];
//		//문자열 입력받기
//		for (int i = 0; i < N; i++) {
//			str[i] = sc.next();
//		}
//		
//		int cnt = 0; //정답 개수 저장할 변수
//		
//		//M개만큼 탐색
//		while(M-- > 0) {
//			String s = sc.next(); //검사할 문자열
//			for (int i = 0; i < N; i++) {
//				//검사할 문자열 길이만큼 잘라서 비교하고 일치하면 cnt 증가
//				if(s.equals(str[i].substring(0,s.length()))) {
//					cnt++;
//					break;
//				}
//			}
//		}
//		
//		System.out.println(cnt);
//	}
}
