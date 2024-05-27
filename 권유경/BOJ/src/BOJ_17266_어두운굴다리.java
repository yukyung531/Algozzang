import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17266_어두운굴다리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 굴다리 길이
        int M = Integer.parseInt(br.readLine()); // 가로등 개수

        int[] arr = new int[M]; // 가로등 좌표 저장할 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 입력 완료

        int first = arr[0];
        int last = N-arr[M-1];

        double dist = Math.max(first,last);

        for(int i = 1; i<M; i++){
            dist = Math.max(Math.ceil((double) (arr[i] - arr[i - 1]) /2), dist);
        }

        System.out.printf("%.0f", dist);
    }
}
