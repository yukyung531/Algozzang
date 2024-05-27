import java.io.*;
import java.util.*;

import static java.lang.String.valueOf;

public class BOJ_22233_가희와키워드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 메모장의 키워드 수
        int M = Integer.parseInt(st.nextToken()); // 블로그 글 수

//        List<String> memoList = new ArrayList<>(); // 메모장 키워드 저장 리스트
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i<N; i++){
            String keywords = br.readLine();
            set.add(keywords);
//            memoList.add(keywords);
        } // 키워드 저장

        for(int i= 0; i<M; i++){
            String s = br.readLine();
            String[] keywordsArr = s.split(",");

            for(int j = 0; j<keywordsArr.length; j++){
                if(set.contains(keywordsArr[j])){
                    set.remove(valueOf(keywordsArr[j]));
                }

//                if(memoList.contains(keywordsArr[j])){
//                    memoList.remove(valueOf(keywordsArr[j]));
//                }
            }
//            bw.write(memoList.size());
            bw.write(valueOf(set.size())+"\n");

        } // 글의 키워드 확인

        br.close();
        bw.flush();
        bw.close();

    }
    // main
}
