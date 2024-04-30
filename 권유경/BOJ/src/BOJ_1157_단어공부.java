import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1157_단어공부 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();

        int[] count = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) -'A' ;
            count[num]++;
        }

        int max = 0;
        char answer = '?';
        for (int i = 0; i < count.length; i++) {
            if(max < count[i]){
                max = count[i];
                answer = (char)(i+'A');
            } else if (max == count[i]){
                answer = '?';
            }
        }
        System.out.println(answer);
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String st = br.readLine();
//
//        // 다 대문자로 변환
//        st = st.toUpperCase();
//
//        // 한 문자씩 쪼개서 저장
//        String[] stArr = st.split("");
//
//        int[] cnt = new int[stArr.length];
//
//        int count = 0;
//
//        // strArr 를 돌면서, i 번째 문자와 같다면 개수를 세서 cnt[i]에 값을 넣자
//        for(int i = 0; i<stArr.length; i++){
//            count = 0;
//            for(int j = i; j<stArr.length; j++){
//                if(stArr[i].equals(stArr[j])){
//                    count++;
//                }
//            }
//            // j
//            cnt[i] = count;
//        }
//        // i
//
//        int maxnum = 0;
//        // cnt 배열에서 가장 큰 수를 찾자
//        for(int i = 0; i<cnt.length; i++){
//            maxnum = Math.max(maxnum, cnt[i]);
//        }
//
//        count = 0;
//        int idx = 0;
//        // cnt 배열을 돌면서 가장 큰 수가 몇 개인지 확인하자
//        for(int i = 0; i<cnt.length; i++){
//            if(cnt[i]==maxnum){
//                count++;
//                idx = i;
//            }
//        }
//
//        // 두 개 이상이면 ? 출력
//        if(count >= 2){
//            System.out.println("?");
//        }
//        else { // 한 개이면 해당 인덱스 stArr 의 값 출력
//            System.out.println(stArr[idx]);
//        }
//
//    }
}
