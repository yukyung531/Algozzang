package src.algo_240307.LCS_9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] firstWord=br.readLine().toCharArray();
        char[] secondWord=br.readLine().toCharArray();
        // input fin

        int[][] dp = new int[firstWord.length + 1][secondWord.length + 1];

        for (int i = 1; i <= firstWord.length; i++) {
            for (int j = 1; j <= secondWord.length; j++) {
                // if the character is not the same
                if (firstWord[i-1] != secondWord[j-1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1]+1;
                }
            }
        }

        System.out.println(dp[firstWord.length][secondWord.length]);
    }
}
