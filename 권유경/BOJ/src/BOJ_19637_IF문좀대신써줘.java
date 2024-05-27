import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_19637_IF문좀대신써줘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 칭호 개수
        int M = Integer.parseInt(st.nextToken()); // 캐릭터 수

        List<String> nameList = new ArrayList<>();
        List<Integer> powerList = new ArrayList<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken(); // 칭호
            int power = Integer.parseInt(st.nextToken()); // 전투력 상한값

            nameList.add(name);
            powerList.add(power);
        }

        for(int i = 0; i<M; i++){
            int inputPower = Integer.parseInt(br.readLine()); // 캐릭터 전투력

            int left = 0;
            int right = N-1;
            int mid;

            while(left<=right){
                mid = (left+right)/2;

                if(powerList.get(mid) < inputPower){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }

            sb.append(nameList.get(left)).append("\n");

        }

        bw.write(String.valueOf(sb));

        br.close();
        bw.flush();
        bw.close();


    }
    // main
}
