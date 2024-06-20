import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_20922_겹치는건싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 문자열 길이
        int K = Integer.parseInt(st.nextToken()); // 중복 가능한 개수

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];

        int start = 0;
        int end = 0;

// N = 7, K = 2
// 2 2 2 5 3 4 1               // end : 0 , start : 0
// count : 0 0 1 0 0 0 0       // end : 1
// count : 0 0 2 0 0 0 0       // end : 2 => len = 2
// count : 0 0 1 0 0 0 0       // end : 2 , start : 1
// count : 0 0 2 0 0 0 0       // end : 3
// count : 0 0 2 0 0 1 0       // end : 4
// count : 0 0 2 1 0 1 0       // end : 5
// count : 0 0 2 1 1 1 0       // end : 6
// count : 0 1 2 1 1 1 0       // end : 7 => len = 6

        int res = Integer.MIN_VALUE;

        while (end < N) { // end 가 문자열 길이보다 작다면 반복
            while (end < N && count[arr[end]] + 1 <= K){
                count[arr[end++]]++;
            }
            // while
            // K보다 크다면
            int len = end - start;
            res = Math.max(res, len);

            // start 이동
            count[arr[start++]]--;
        }
        // while

        System.out.println(res);


    }
    // main
}
