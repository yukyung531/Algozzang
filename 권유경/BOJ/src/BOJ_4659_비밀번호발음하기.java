import java.util.Scanner;

public class BOJ_4659_비밀번호발음하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String pw = sc.next();
            // end 는 마지막 입력
            if (pw.equals("end")) {
                break;
            }

            char[] charArr = pw.toCharArray();
            int len = charArr.length;

            boolean check = false;
            // 1. a,e,i,o,u 포함 여부
            for (int i = 0; i < len; i++) {
                // 모음을 하나라도 포함한다면
                if (charArr[i] == 'a' || charArr[i] == 'e' || charArr[i] == 'i' || charArr[i] == 'o' || charArr[i] == 'u') {
                    check = true;
                    break;
                }
            }

            if (!check) {
                System.out.println("<" + pw + "> is not acceptable.");
                continue;
            }

            boolean flag = false;

            // 3. 두 자리가 연속되는지 확인
            for (int j = 0; j < len - 1; j++) {
                // 연속되고
                if (charArr[j] == charArr[j + 1]) {
                    // e 나 o 라면
                    if (charArr[j] != 'e' && charArr[j] != 'o') {
                        System.out.println("<" + pw + "> is not acceptable.");
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) continue;

            // 2. 모음 또는 자음이 세 글자 연속되는지 확인
            int cnt = 0;
            for (int i = 0; i < len - 2; i++) {
                // 자음일 경우 cnt++
                if (charArr[i] != 'a' && charArr[i] != 'e' && charArr[i] != 'i' && charArr[i] != 'o' && charArr[i] != 'u') {
                    cnt++;
                    // 다음 문자도 자음이라면 cnt++
                    if (charArr[i + 1] != 'a' && charArr[i + 1] != 'e' && charArr[i + 1] != 'i' && charArr[i + 1] != 'o' && charArr[i + 1] != 'u') {
                        cnt++;
                    } else { // 다음 문자는 모음이라면 다음꺼 확인
                        cnt = 0;
                        continue;
                    }
                    // 현재까지 연속된 자음이 2개일 경우, 다음 문자도 확인
                    if (cnt == 2 && charArr[i + 2] != 'a' && charArr[i + 2] != 'e' && charArr[i + 2] != 'i' && charArr[i + 2] != 'o' && charArr[i + 2] != 'u') {
                        System.out.println("<" + pw + "> is not acceptable.");
                        flag = true;
                        break;
                    }
                }
                // 모음일 경우 cnt++
                if (charArr[i] == 'a' || charArr[i] == 'e' || charArr[i] == 'i' || charArr[i] == 'o' || charArr[i] == 'u') {
                    cnt++;
                    // 다음 문자도 모음이라면 cnt++
                    if (charArr[i + 1] == 'a' || charArr[i + 1] == 'e' || charArr[i + 1] == 'i' || charArr[i + 1] == 'o' || charArr[i + 1] == 'u') {
                        cnt++;
                    } else { // 다음 문자는 자음이라면 다음꺼 확인
                        cnt = 0;
                        continue;
                    }
                    // 현재까지 연속된 자음이 2개일 경우, 다음 문자도 확인
                    if (cnt == 2 && charArr[i + 2] == 'a' || charArr[i + 2] == 'e' || charArr[i + 2] == 'i' || charArr[i + 2] == 'o' || charArr[i + 2] == 'u') {
                        System.out.println("<" + pw + "> is not acceptable.");
                        flag = true;
                        break;
                    }
                }
            }

            if (flag) continue;

            System.out.println("<" + pw + "> is acceptable.");

        }
    }
    // while
}
