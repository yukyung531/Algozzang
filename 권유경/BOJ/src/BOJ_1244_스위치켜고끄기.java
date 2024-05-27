import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1244_스위치켜고끄기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 총 스위치 개수
        int[] sArr = new int[N+1]; // 스위치 상태 저장할 배열(on:1, off:0)
        for(int i = 1;i<N+1; i++){
            sArr[i]= sc.nextInt();
        }
        int studentNum = sc.nextInt(); // 학생 수

        for(int i= 0; i<studentNum; i++){
            int gender = sc.nextInt(); // 성별 (남:1, 여:2)
            int num = sc.nextInt(); // 받은 수

            // 남자일 경우
            if(gender == 1){
                for(int j = 1; j<N+1; j++){
                    // 배수인 것 토글
                    if(j%num ==0){
                        toggle(sArr, j);
                    }
                }
            }
            // 여자일 경우
            else {
                toggle(sArr, num);
                for(int j = 1; j<N+1; j++){
                    if(num-j >= 1 && num+j < N+1 && sArr[num-j] == sArr[num+j]){
                        toggle(sArr, num-j);
                        toggle(sArr, num+j);
                    }
                    else break;
                }
            }
        }


        for(int i = 1; i<N+1; i++){
            System.out.print(sArr[i]+" ");
            if(i%20 == 0 && i!=N) System.out.println();
        }
    }
    // main

    public static void toggle(int[] sArr, int num){
        if(sArr[num] == 1) sArr[num] = 0;
        else sArr[num] = 1;
    }
}
