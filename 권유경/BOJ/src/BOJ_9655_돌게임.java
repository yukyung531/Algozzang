import java.util.Scanner;

public class BOJ_9655_돌게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 짝수이면 CY
        if((N%4) % 2 ==0) {
            System.out.println("CY");
        }
        // 홀수이면 SK
        else{
            System.out.println("SK");
        }
    }
}
