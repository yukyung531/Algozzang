import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. S에 포함된 문자열을 입력받을 때, 그 문자열이 가질 수 있는 모든 접두사를 S에 저장한다.
2. 검사해야 할 문자열을 입력받고, S에 그 문자열이 포함되어 있다면 cnt +1

이 문제는 trie 알고리즘으로 푸는 것이 일반적인 듯하다.. 근데 어려워서 잘 이해를 못하겠다;;
 */
public class BOJ_14426_접두사찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        // S에 포함된 문자열 개수
        int N = Integer.parseInt(st.nextToken());
        // 검사해야 하는 문자열 개수
        int M = Integer.parseInt(st.nextToken());

        // 집합 S
        Set<String> S = new HashSet<>();

        for(int i = 0; i<N; i++){
            // S에 포함된 문자열 str을 입력받음과 동시에
            String str = br.readLine();
            // str이 가질 수 있는 모든 접두어를 S에 저장
            for(int j = 1; j<=str.length(); j++){
                S.add(str.substring(0,j));
            }
        }

        // 답
        int cnt = 0;

        for(int i = 0; i<M; i++){
            // 검사해야 할 문자열을 입력받고
            String str = br.readLine();
            // S에 존재한다면 cnt+1
           if(S.contains(str)) cnt++;
        }

        System.out.println(cnt);

        // 아래 방법은 시간초과 남
//        int N = Integer.parseInt(st.nextToken());
//        // 검사해야 하는 문자열 개수
//        int M = Integer.parseInt(st.nextToken());
//
//        // 집합 S
//        List<String> S = new ArrayList<>();
//
//        for(int i = 0; i<N; i++){
//            S.add(br.readLine());
//        }
//
//        // 답
//        int cnt = 0;
//
//        for(int i = 0; i<M; i++){
//            // 검사해야 할 문자열을 입력받고
//            String s = br.readLine();
//            int len = s.length();
//            // 첫 글자가 일치하고, 집합 S의 문자열을 s의 크기로 잘랐을 때, 일치하는 게 있다면 cnt+1 하고 break
//            for(int j = 0; j<S.size(); j++){
//                if(s.substring(0,1).equals( S.get(j).substring(0,1)) && S.get(j).substring(0,len).equals(s)){
//                    cnt++;
//                    break;
//                }
//                else continue;
//            }
//        }
//        System.out.println(cnt);

    }
}
