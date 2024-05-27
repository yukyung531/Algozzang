import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2607_비슷한단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 단어의 개수
        char[] first = br.readLine().toCharArray(); // 첫 단어 배열
        int fistLength = first.length; // 첫 단어의 길이
        int res = 0; // 첫 단어와 비슷한 단어의 수
        for(int n = 0; n< N-1; n++) {
            char[] compare = br.readLine().toCharArray(); // 비교할 단어 배열
            int compareLength = compare.length; // 비교할 단어의 길이

            if (Math.abs(fistLength - compareLength) > 1) continue; // 글자 수 차이가 1보다 크다면 continue

            int same = 0; // fisrt와 같은 글자 수

            // first와 compare비교
            for (int i = 0; i < fistLength; i++) {
                for (int j = 0; j < compareLength; j++) {
                    if (first[i] == compare[j]) {
                        same++;
                        compare[j] = 'a'; // 소문자로 바꾸기
                        break;
                    }
                }
            }

            // 두 단어의 글자 수가 같고, 일치하는 글자 수의 개수가 첫 단어 글자 수와 같다면
            if (fistLength <= compareLength && same == fistLength) {
                res++;
            }
            // 만약 첫 단어 글자 수가 더 크다면
            else if (fistLength > compareLength && same == compareLength) {
                res++;
            }
            else if(fistLength == compareLength &&  same == fistLength-1){
               res++;
            }
        }
        System.out.println(res);
    }
    // main
}
