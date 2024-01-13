import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 1. 스택에 문자열을 하나씩 넣는다.
 * 2. 폭탄 길이와 같거나 커지면, 폭탄 길이만큼 반복문 시작 => 스택의 길이 - 폭탄 길이를 뺀 스택의 위치부터 비교를 시작한다.
 * 3. 문자가 같지 않으면 flag를 false로 바꾼 후 반복문을 나온다.
 * 4. 반복문을 다 돌았는데 flag가 true라면 폭탄 길이만큼 스택에서 뺀다.
 * 4. 스택에 다음 문자열을 넣어가며 위 과정을 반복한다.
 */


public class BOJ_9935_문자열폭발 {

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        char[] st = br.readLine().toCharArray();
	        char[] bomb = br.readLine().toCharArray();
	        
	        
	        Stack<Character> stack = new Stack<>();

	        for (char c : st) {
	            stack.push(c);
	            if (stack.size() >= bomb.length) {
	                boolean flag = true;
	                for (int i = 0; i < bomb.length; i++) {
	                    if (stack.get(stack.size() - bomb.length + i) != bomb[i]) {
	                        flag = false;
	                        break;
	                    }
	                }
	                if (flag) {
	                    for (int i = 0; i < bomb.length; i++) {
	                        stack.pop();
	                    }
	                }
	            }
	        }

	        StringBuilder sb = new StringBuilder();
	        
	        for (char c : stack) {
	            sb.append(c);
	        }

	        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
	    }
	    // main
	}

// ㅠㅠ 스택문제가 오랜만이라 그런지 너무 어려웠다. 2시간이나 헤맸다.. 더 문제를 많이 풀어봐야겠다.
// 결국 답을 보고 그대로 풀이했다. 생각하지 못한 방법으로 풀이한 답을 보니 난 아직 한참 멀었다고 생각했다...