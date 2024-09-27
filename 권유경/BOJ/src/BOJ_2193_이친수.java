import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2193_이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N <= 2) {
            System.out.println(1);
            return;
        }

        // dp로 풀어보자...
        long[] dp = new long[N];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[N - 1]);
    }
}
//
//        sel = new int[N];
//        cnt = 0;
//
//        sel[0] = 1;
//        combination(1);
//        System.out.println(cnt);
//
//    }
//    // main
//
//    static void combination(int idx) {
//        // 기저 조건
//        if (idx == N) {
//            cnt++;
//            return;
//        }
//        // 재귀 조건
//        // 앞에가 1이면 0이 와야 함
//        if (sel[idx - 1] == 1) {
//            sel[idx] = 0;
//            combination(idx + 1);
//        }
//        // 앞에가 0이면 0 또는 1이 와야함.
//        else {
//            sel[idx] = 0;
//            combination(idx + 1);
//            sel[idx] = 1;
//            combination(idx + 1);
//        }
//    }
//}
