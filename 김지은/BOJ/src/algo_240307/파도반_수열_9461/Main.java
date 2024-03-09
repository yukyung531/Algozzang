package src.algo_240307.파도반_수열_9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T;
    static long[] arr=new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {

            int N = Integer.parseInt(br.readLine());
            arr[0]=0;
            arr[1]=1;
            arr[2]=1;
            arr[3]=1;
            arr[4]=2;
            arr[5]=2;

            dp(N);

            System.out.println(arr[N]);
        }// for tc
    }

    private static long dp(int N) {
        // terminate recursion
        if (arr[N]!=0) return arr[N];

        arr[N]=dp(N-1)+dp(N-5);
        return arr[N];

    }
}
