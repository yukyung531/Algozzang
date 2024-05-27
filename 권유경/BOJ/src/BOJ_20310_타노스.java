import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_20310_타노스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        List<Character> list = new ArrayList<>();
        for(int i = 0; i<S.length(); i++){
            list.add(S.charAt(i));
        }

        int cnt0 = 0;
        int cnt1 = 0;

        for(int i = 0; i<list.size(); i++){
            if(list.get(i) == '0'){
                cnt0++;
            }else{
                cnt1++;
            }
        }

        cnt0 /= 2;
        cnt1 /= 2;

        // 앞에서부터 1 지우기
        for(int i = 0; i<cnt1; i++){
          for(int j = 0; j<list.size(); j++){
              if(list.get(j) == '1') {
                  list.remove(j);
                  break;
              }
          }
        }

        // 뒤에서부터 0 지우기
        for(int i = 0; i<cnt0; i++){
            for(int j = list.size()-1; j>=0; j--){
                if(list.get(j) == '0') {
                    list.remove(j);
                    break;
                }
            }
        }

        for(Character c : list){
            System.out.print(c);
        }

    }
    // main
}
