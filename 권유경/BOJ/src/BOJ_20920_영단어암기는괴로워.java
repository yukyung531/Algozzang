import java.io.*;
import java.util.*;

public class BOJ_20920_영단어암기는괴로워 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 단어 개수
        int M = Integer.parseInt(st.nextToken()); // 길이 기준

         Map<String, Integer> map = new HashMap<>();

         for(int i = 0; i<N; i++){
             String word = br.readLine();

             if(word.length() < M) continue;
             map.put(word, map.getOrDefault(word, 0)+1); // key 값 중복 시 추가된 key 값으로 저장 및 출력이 된다.
         }
         br.close();
         // 단어, 빈도수 입력 완료

        List<String> words = new ArrayList<>(map.keySet());

        // words 리스트를 정렬
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 자주 등장하는 단어 순서대로 정렬
                if (map.get(o1) - map.get(o2) > 0){
                    return -1;
                } else if (map.get(o1) - map.get(o2) < 0) {
                    return 1;
                }
                else{
                    // 등장 횟수가 같으면 길이가 긴 단어가 먼저 오도록 정렬
                    if (o1.length() != o2.length()) {
                        return o2.length() - o1.length();
                    }
                    // 등장 횟수와 길이가 같으면 사전 순으로 정렬
                    return o1.compareTo(o2);
                }
            }
        });

         for(String w : words){
            bw.write(w);
            bw.write("\n");
         }

         bw.flush();
         bw.close();

    }
    //main
}
