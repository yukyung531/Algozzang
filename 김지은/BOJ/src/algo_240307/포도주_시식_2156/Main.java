package src.algo_240307.포도주_시식_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] wine = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }// input fin

        dp[1] = wine[1];

        if(N>1) dp[2] = wine[1] + wine[2];

        for (int i = 3; i <= N; i++) {
            // 아예 안마시기, oxo로 마시기, oxoo로 마시기
            dp[i]=Math.max(dp[i-1], Math.max(dp[i-2]+wine[i], dp[i-3]+wine[i-1]+wine[i]));
        }

        System.out.println(dp[N]);
    }

}
