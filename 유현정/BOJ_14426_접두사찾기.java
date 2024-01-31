package Boj14426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main5 {
	//trie 구조 사용
	//https://codingnojam.tistory.com/40
	static class Node{
		Map<Character, Node> childNode = new HashMap<Character, Node>();
		boolean endOfword;
	}
	static class Trie{
		Node rootNode = new Node();
		
		//저장
		void insert(String str) {
			Node node = this.rootNode;
			
			for(int i = 0; i<str.length(); i++) {
				node = node.childNode.computeIfAbsent(str.charAt(i), key -> new Node());
			}
			node.endOfword = true;
		}
		boolean search(String str) {
			Node node = this.rootNode;
			for(int i = 0; i<str.length(); i++) {
				node = node.childNode.getOrDefault(str.charAt(i), null);
				if(node == null) {
					return false;
				}
			}
			return true;
		}
	}
	public static void main(String[] args) throws IOException {
		Trie trie = new Trie();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = bf.readLine();
		int N = Integer.parseInt(line.split(" ")[0]);
		int M = Integer.parseInt(line.split(" ")[1]);
		//문자열에 저장
		for(int i = 0; i<N; i++) {
			trie.insert(bf.readLine());
		}
		int result = 0;
		//찾기
		for(int i = 0; i<M; i++) {
			if(trie.search(bf.readLine())) {
				result++;
			}
		}
		System.out.println(result);
	}

}
