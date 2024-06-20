import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1138_한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사람 수

        int[] height = new int[N]; // 사람 키
        for (int i = 0; i < N; i++) {
            height[i] = i + 1;
        } // 키 입력
        int[] leftPeople = new int[N]; // 왼쪽의 사람 수

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            leftPeople[i] = Integer.parseInt(st.nextToken());
        } // 왼쪽 사람 수 입력

        int[] resArr = new int[N]; // 결과 배열

        // 키가 1인 사람 먼저 입력
        resArr[leftPeople[0]] = height[0];
//        System.out.println(Arrays.toString(resArr));

        // 키가 2인 사람부터 확인
        for (int i = 1; i < N; i++) {
//            System.out.println("i = " + i);
            int leftNum = leftPeople[i];
//            System.out.println("leftNum = " + leftNum);
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (cnt == leftNum) {
                    cnt = j;
                    break; // 왼쪽 사람 수만큼 빈자리 확보했다면 멈추자
                }
                if (resArr[j] == 0) cnt++; // 빈자리 세기
//                System.out.println("cnt = " + cnt);
            }

            if (resArr[cnt] != 0) { // 이미 채워진 자리라면 그 다음 자리 차지하자
//                System.out.println(resArr[cnt]);
                for (int j = cnt + 1; j < N; j++) {
                    if (resArr[j] != 0) {
//                        System.out.println("resArr = " + resArr[j]);
                        cnt++;
                        continue;
                    }
                    else {
                        cnt++;
                        if (resArr[cnt] != 0) continue;
                        else {
//                            System.out.println("new cnt = " + cnt);
                            break;
                        }
                    }
                }
            }
            resArr[cnt] = height[i];
        }
        for(int i : resArr){
            System.out.print(i+" ");
        }
    }
// main

}

