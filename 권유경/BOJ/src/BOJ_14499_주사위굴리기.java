import java.util.*;

public class BOJ_14499_주사위굴리기{
    public static int[][] map;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        map = new int[N][M];

        // 현재 주사위 좌표
        int r = sc.nextInt();
        int c = sc.nextInt();

        // 이동할 횟수
        int m = sc.nextInt();

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }
        // 지도 입력

        int[] move = new int[m];

        for(int i = 0; i<m; i++){
            move[i] = sc.nextInt();
        }
        // 이동방향 입력

        // 주사위의 현재 상태를 저장할 배열
        int[] dice = new int[6]; // [0]: 위, [1]: 북, [2]: 동, [3]: 서, [4]: 남, [5]: 바닥

        // 우, 좌, 상, 하
        int[] dr = new int[]{0,0,-1,1};
        int[] dc = new int[]{1,-1,0,0};

        // 주사위 상단과 하단의 인덱스를 초기화
        int top = 0;
        int bottom = 5;

        // 이동 시작
        for(int i = 0; i< m; i++){
            // 현재 이동 방향
            int moveDir = move[i];

            // 다음 좌표 계산
            int nextR = r + dr[moveDir-1];
            int nextC = c + dc[moveDir-1];

            // 만약 map 안에 있다면 현위치 이동
            if(nextR >= 0 && nextR < N && nextC >=0 && nextC < M){
                r = nextR;
                c = nextC;

                // 주사위 상태 변경
                changeDiceState(moveDir, dice);

                // 주사위 윗 면 값 출력
                System.out.println(dice[top]);

                // 지도의 값을 바닥면으로 옮김
                if(map[r][c] == 0) {
                    map[r][c] = dice[bottom];
                } else {
                    dice[bottom] = map[r][c];
                    map[r][c] = 0;
                }
            }
        }
    }

    // 주사위 상태 변경 메소드
    public static void changeDiceState(int moveDir, int[] dice) {
        // 이동 방향에 따라 주사위 상태 변경
        int temp;
        switch (moveDir) {
            case 1: // 동
                temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
                break;
            case 2: // 서
                temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;
                break;
            case 3: // 북
                temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
                break;
            case 4: // 남
                temp = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
                break;
        }
    }
}


//import java.util.*;
//
//public class BOJ_14499_주사위굴리기 {
//    public static int[][] map;
//
//    public static void main(String[] args) {
//
//
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//
//        map = new int[N][M];
//
//        // 현재 주사위 좌표
//        int r = sc.nextInt();
//        int c = sc.nextInt();
//
//        // 이동할 횟수
//        int m = sc.nextInt();
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                map[i][j] = sc.nextInt();
//            }
//        }
//
//        int[] move = new int[m];
//
//        for (int i = 0; i < m; i++) {
//            move[i] = sc.nextInt();
//        }
//
//        // 위아래 이동 deque
//        ArrayDeque<String> upDownQ = new ArrayDeque<>();
//        upDownQ.add("남");
//        upDownQ.add("위");
//        upDownQ.add("북");
//        upDownQ.add("바닥");
//
//        // 위아래 값 저장할 배열
//        int[] upDownArr = new int[4];
//
//        // 좌우 이동 deque
//        ArrayDeque<String> leftRightQ = new ArrayDeque<>();
//        leftRightQ.add("위");
//        leftRightQ.add("서");
//        leftRightQ.add("바닥");
//        leftRightQ.add("동");
//
//        // 좌우 값 저장할 배열
//        int[] leftRightArr = new int[4];
//
//        // 우, 좌, 상, 하
//        int[] dr = new int[]{0, 0, -1, 1};
//        int[] dc = new int[]{1, -1, 0, 0};
//
//        // 이동 시작
//        for (int i = 0; i < move.length; i++) {
//            // 일단 map 이동
//            int nextR = r + dr[move[i] - 1];
//            int nextC = c + dc[move[i] - 1];
//
//            // 만약 map 안에 있다면 현위치 이동
//            if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
//                r = nextR;
//                c = nextC;
//            } // map을 벗어난다면 넘겨~~
//            else continue;
//
//            int bottom = 0;
//            int up = 0;
//            int direction = 0;
//
//            // 1일 때(동쪽_오른쪽)
//            if (move[i] == 1) {
//                direction = 1;
//                play(direction, leftRightQ, leftRightArr, r, c, 0, 0);
//            }
//            // 2일 때(서쪽_왼쪽)
//            else if (move[i] == 2) {
//                direction = 2;
//                play(direction, leftRightQ, leftRightArr, r, c, 0, 0);
//            }
//            // 3일 때(북쪽_위쪽)
//            else if (move[i] == 3) {
//                direction = 2;
//                play(direction, upDownQ, upDownArr, r, c, 0, 0);
//            }
//            // 4일 때(남쪽_아래쪽)
//            else if (move[i] == 4) {
//                direction = 1;
//                play(direction, upDownQ, upDownArr, r, c, 0, 0);
//            }
//        }
//        // 이동
//
//
//    }
//    // main
//
//    public static void play(int direction, ArrayDeque<String> deque, int[] arr, int r, int c, int bottom, int up) {
//        // direction이 1이면, 맨 뒤 값 뽑아서 맨 앞으로 넣기
//        if (direction == 1) {
//            String right = deque.pollLast();
//            deque.addFirst(right);
//        } else { // 1이 아니라면, 맨 앞 값을 뽑아서 맨 뒤에 넣기
//            String left = deque.pollFirst();
//            deque.add(left);
//        }
//
//        // deque를 돌면서 (바닥)을 만나면,
//
//        Iterator<String> iterator = deque.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next().equals("바닥")) {
//                break;
//            }
//            bottom++;
//        }
//        while (iterator.hasNext()) {
//            if (iterator.next().equals("위")) {
//                break;
//            }
//            up++;
//        }
//
//        // arr[bottom]이 0인지 아닌지 여부와 인덱스를 확인한 후,
//        // 0이라면, arr의 해당 인덱스 값에 현위치 좌표의 값을 넣는다.
//        if (arr[bottom] == 0) {
//            arr[bottom] = map[r][c];
//        } else {
//            // 0이 아니라면, arr의 해당 인덱스 값에 현위치 좌표의 값을 넣고, map의 현위치 값을 0으로 만든다.
//            arr[bottom] = map[r][c];
//            map[r][c] = 0;
//        }
//        // 주사위 위 값을 출력
//        System.out.println(arr[up]);
//    }
//    //rightDown
//}
