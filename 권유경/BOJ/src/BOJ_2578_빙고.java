import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {

    /* 1. 철수의 빙고판을 입력받는다.
       2. 사회자가 부르는 숫자를 입력받음과 동시에, 그 숫자를 철수의 빙고판에서 찾아서 해당 좌표값를 0으로 바꾼다.
       3. 빙고가 있는지 확인한다.
        3-1. 가로, 세로, 대각선이 빙고가 되는지 확인하는 함수를 만든다.
        3-2. 빙고일 때마다 빙고횟수 +1
       4. 빙고횟수가 3번이 되면 답을 출력하고, 종료한다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 철수 빙고판
        int[][] cheolsu = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cheolsu[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 빙고 횟수
        int bingo = 0;

        for (int i = 1; i <= 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                int num = Integer.parseInt(st.nextToken());

                // 철수 빙고판에서 num 찾아서 체크(0으로 변경)
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (cheolsu[k][l] == num) {
                            cheolsu[k][l] = 0;
                        }
                    }
                }

                // 빙고 확인
                bingo = checkBingo(cheolsu);
                if (bingo >= 3) {
                    // 사회자가 몇번째 숫자를 부를 때 빙고가 3번이 되는지 확인하는 것이므로
                    // 아래 수식의 값을 출력한다.
                    System.out.println((5 * (i - 1)) + j);
                    return;
                }

            }
        }
    }
    //main
    public static int checkBingo(int[][] board) {
        // 빙고 횟수 초기화
        int bingo = 0;
        // 가로, 세로, 대각선 확인
        for (int i = 0; i < 5; i++) {
            if (board[i][0] == 0 && board[i][1] == 0 && board[i][2] == 0 && board[i][3] == 0 && board[i][4] == 0) bingo++;
            if (board[0][i] == 0 && board[1][i] == 0 && board[2][i] == 0 && board[3][i] == 0 && board[4][i] == 0) bingo++;
        }

        // 대각선 확인
        if (board[0][0] == 0 && board[1][1] == 0 && board[2][2] == 0 && board[3][3] == 0 && board[4][4] == 0) bingo++;
        if (board[0][4] == 0 && board[1][3] == 0 && board[2][2] == 0 && board[3][1] == 0 && board[4][0] == 0) bingo++;

        return bingo;
    }
}
