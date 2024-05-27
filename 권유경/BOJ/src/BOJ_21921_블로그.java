import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_21921_블로그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken()); // 블로그 운영 일수
        int X = Integer.parseInt(st.nextToken()); // 확인할 연속된 X일

        int[] arr = new int[N]; // 방문자 수 저장할 배열
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i < X) sum+=arr[i];
        }

        // 방문자 수 저장
        br.close();

        max = Math.max(max, sum);
        map.put(max, map.getOrDefault(max, 0)+1);

        for(int i = X; i<N; i++){
            sum += arr[i];
            sum -= arr[i-X];
            max = Math.max(max,sum);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        if(max == 0){
            bw.write("SAD");
            bw.flush();
            bw.close();
            return;
        }
        bw.write(String.valueOf(max)+"\n");
        bw.write(String.valueOf(map.get(max)));


        bw.flush();
        bw.close();
    }
    // main

}
