import java.util.Arrays;
import java.util.Scanner;

public class BOJ_20125_쿠키의신체측정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 판 한변의 길이
        char[][] pan = new char[N][N];

        for(int i = 0; i<N; i++){
            String str = sc.next();
            pan [i] = str.toCharArray();
        }

        int x = 0; // 심장 x좌표
        int y = 0; // 심장 y좌표

        int heartX = 0; // 출력할 심장 x
        int heartY = 0; // 출력할 심장 y

        loof:for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(pan[i][j] == '*'){
                    x = i+1;
                    y = j;
                    heartX = i+2;
                    heartY = j+1;
                    System.out.println(heartX+" "+heartY);
                    break loof;
                }
            }
        }
        // loof

        int leftArm = 0;
        int rightArm = 0;
        for(int i = 0; i<N; i++){
            if(pan[x][i] == '*' && i<y) leftArm++;
            if(pan[x][i] == '*' && i>y) rightArm++;
        }

        int waist = 0;
        int waistEndX = 0;
        for(int i = x+1; i<N; i++){
            if(pan[i][y] == '*'){
                waistEndX = i;
                waist++;
            }
            else break;
        }

        int leftLeg = 0;
        int rightLeg = 0;
        for(int i = waistEndX+1; i<N; i++){
            if(pan[i][y-1]=='*'){
                leftLeg++;
            }else break;
        }

        for(int i = waistEndX+1; i<N; i++){
            if(pan[i][y+1]=='*'){
                rightLeg++;
            }else break;
        }

        System.out.print(leftArm+" ");
        System.out.print(rightArm+" ");
        System.out.print(waist+" ");
        System.out.print(leftLeg+" ");
        System.out.print(rightLeg+" ");
    }
    // main
}
