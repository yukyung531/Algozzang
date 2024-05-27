import java.io.*;
import java.util.StringTokenizer;

public class BOJ_19941_햄버거분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 식탁의 길이
        int K = Integer.parseInt(st.nextToken()); // 먹을 수 있는 거리

        String str = br.readLine(); // 햄버거와 사람 문자열

        br.close();

        char[] charArr = str.toCharArray();
        int res =0;

        for(int i = 0; i<N; i++){
            // 사람이라면 전후로 햄버거 확인
            if(charArr[i] == 'P'){
                for(int j = i-K; j<=i+K; j++){
                    // 문자열 범위 안에 있는지 확인 후
                    if(j >= 0 && j < N){
                        // 햄버거라면 먹은걸로 바꾸자.
                        if(charArr[j] == 'H'){
                            charArr[j] = 'D';
                            res++;
                            break;
                        }
                    }
                }
            }
        }

        bw.write(String.valueOf(res));

        bw.flush();
        bw.close();

    }
    // main
}
