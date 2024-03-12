import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17413_단어뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        // 입력 완료

        // 입력받은 문자열 S를 char 배열로 만들자
        char[] charArr = S.toCharArray();

        // tag가 0인지 1인지 확인
        // '<'로 시작하면 '>'로 끝날때까지 확인 후 저장
        // >뒤에는 바로 문자확인하자 (공백과 '<'이 아닐 경우에는 공백 또는 '<'이 나올때까지 문자를 임시저장 후 거꾸로 출력)
        // 공백 또는 '<'이 나올때까지 문자를 임시저장 후 거꾸로 출력

        int tag = 0; // 0은 단어, 1은 태그
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < charArr.length; i++) {
            // 만약 태그로 시작한다면
            if (charArr[i] == '<') {
                // 이전 문자가 > 아니라면, 거꾸로 출력
                if (i - 1 >= 0 && charArr[i - 1] != '>') {
                    for (int j = charList.size() - 1; j >= 0; j--) {
                        System.out.print(charList.get(j));
                    }
                    charList.clear();
                    charList.add(charArr[i]);
                    tag = 1;
                    continue;
                }
                // tag를 1로 설정해주고 '>'가 나올 때까지 charList 에 저장하고 continue
                tag = 1;
                charList.add(charArr[i]);
                continue;
            }
            // tag == 1이고, charArr[i] != '>' 라면 charList에 추가
            if (tag == 1 && charArr[i] != '>') {
                charList.add(charArr[i]);
            }
            // tag == 1이고, charArr[i] == '>' 라면 charList에 추가 후, charList 출력하고, 초기화 후 tag = 0 으로 바꾸자
            else if (tag == 1 && charArr[i] == '>') {
                charList.add(charArr[i]);
                for (int j = 0; j < charList.size(); j++) {
                    System.out.print(charList.get(j));
                }
                tag = 0;
                charList.clear();
            } else if (tag == 1 && charArr[i] == ' ') {
                charList.add(charArr[i]);
            }
            // tag == 0 이라면
            else if (tag == 0 && charArr[i] != ' ') {
                charList.add(charArr[i]);
                // 마지막 문자라면 거꾸로 출력
                if(i == charArr.length-1){
                    for (int j = charList.size() - 1; j >= 0; j--) {
                        System.out.print(charList.get(j));
                    }
                }
            }
            // 만약 tag == 0 이고 공백이라면 charList 거꾸로 출력 후, 해당 문자 출력 후 초기화
            else if (tag == 0 && charArr[i] == ' ') {
                for (int j = charList.size() - 1; j >= 0; j--) {
                    System.out.print(charList.get(j));
                }
                System.out.print(charArr[i]);
                charList.clear();
            }
        }


    }
    // main
}
