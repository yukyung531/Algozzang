import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
    static int N;
    static int M;
    static int[][] paper;
    static int maxNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 세로
        N = Integer.parseInt(st.nextToken());
        // 가로
        M = Integer.parseInt(st.nextToken());

        // 종이
        paper = new int[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력 완료

        maxNum = 0;

//        one();
//        two();
//        three();
//        four();
//        five();
//        six();
//        seven();
//        eight();
        nine();
        System.out.println(maxNum);
        // 테트로미노 확인하며 최댓값 갱신

    }

    // main
    public static void one(){ // ㅁㅁㅁㅁ
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M-3; j++){
                int sum = 0;
                for(int k = j; k<j+4; k++){
                    sum+= paper[i][k];
                }
                maxNum = Math.max(maxNum, sum);
            }
        }
    }
    public static void two() {
        for(int i = 0; i<M; i++){
            for(int j = 0; j<N-3; j++){
                int sum = 0;
                for(int k = j; k<j+4; k++){
                    sum+= paper[k][i];
                }
                maxNum = Math.max(maxNum, sum);
            }
        }
    }
    public static void three() {
        for(int i = 0; i<N-1; i++){
            for(int j = 0; j<M-1; j++){
                int sum = 0;
                for(int k = j; k<j+2; k++){
                    sum+= paper[i][k];
                    sum+= paper[i+1][k];
                }
                maxNum = Math.max(maxNum, sum);
            }
        }
    }

    public static void four(){
        for(int i = 1; i<N; i++){
            for(int j = 0; j<M-2; j++){
                int sum = 0;
                int total = 0;
                int e = 0;
                List<Integer> save = new ArrayList<>();
                for(int k = j; k<j+3; k++){
                    e= k;
                    save.add(e);
                    sum+= paper[i][k];
                }
                // 여기서 위의 세칸을 더한 값
                for(int k = 0; k<3; k++){
                    total = sum;
                    total+=paper[i-1][save.get(k)];
                    maxNum = Math.max(maxNum, total);
                }

            }
        }
    }

    public static void five(){
        for(int i = 0; i<N-1; i++){
            for(int j = 0; j<M-2; j++){
                int sum = 0;
                int total = 0;
                int e = 0;
                List<Integer> save = new ArrayList<>();
                for(int k = j; k<j+3; k++){
                    e= k;
                    save.add(e);
                    sum+= paper[i][k];
                }
                // 여기서 아래의 세칸을 더한 값
                for(int k = 0; k<3; k++){
                    total = sum;
                    total+=paper[i+1][save.get(k)];
                    maxNum = Math.max(maxNum, total);
                }

            }
        }
    }
    public static void six(){
        for(int i = 0; i<M-1; i++){
            for(int j = 0; j<N-2; j++){
                int sum = 0;
                int total = 0;
                int e = 0;
                List<Integer> save = new ArrayList<>();
                for(int k = j; k<j+3; k++){
                    e= k;
                    save.add(e);
                    sum+= paper[k][i];
                }
                // 여기서 아래의 세칸을 더한 값
                for(int k = 0; k<3; k++){
                    total = sum;
                    total+=paper[save.get(k)][i+1];
                    maxNum = Math.max(maxNum, total);
                }
            }
        }
    }
    public static void seven(){
        for(int i = 1; i<M; i++){
            for(int j = 0; j<N-2; j++){
                int sum = 0;
                int total = 0;
                int e = 0;
                List<Integer> save = new ArrayList<>();
                for(int k = j; k<j+3; k++){
                    e= k;
                    save.add(e);
                    sum+= paper[k][i];
                }
                // 여기서 아래의 세칸을 더한 값
                for(int k = 0; k<3; k++){
                    total = sum;
                    total+=paper[save.get(k)][i-1];
                    maxNum = Math.max(maxNum, total);
                }
            }
        }
    }

    public static void eight(){
        for(int i = 1; i<N-1; i++){
            for(int j = 0; j<M-3; j++){
                int sum = 0;
                int total = 0;
                int e = 0;
                List<Integer> save = new ArrayList<>();
                for(int k = j; k<j+2; k++){
                    e= k;
                    save.add(e);
                    sum+= paper[i][k];
                }
                // 여기서 위 한칸, 아래 한칸을 더한 값
                total = sum; // 왼쪽 위, 오른쪽 아래
                int total2 = sum; // 오른쪽 위, 왼쪽 아래
                total+=paper[i-1][save.get(0)]+ paper[i+1][save.get(1)];
                maxNum = Math.max(maxNum, total);
                total2+=paper[i-1][save.get(1)]+ paper[i+1][save.get(0)];
                maxNum = Math.max(maxNum, total2);
            }
        }
    }
    public static void nine(){ // 여기부터 수정해야함
        for(int i = 1; i<M-1; i++){
            for(int j = 0; j<N-3; j++){
                int sum = 0;
                int total = 0;
                int e = 0;
                List<Integer> save = new ArrayList<>();
                for(int k = j; k<j+2; k++){
                    e= k;
                    save.add(e);
                    sum+= paper[k][i];
                }
                // 여기서 위 한칸, 아래 한칸을 더한 값
                total = sum; // 왼쪽 위, 오른쪽 아래
                int total2 = sum; // 오른쪽 위, 왼쪽 아래
                total+=paper[save.get(0)][i]+ paper[save.get(1)][i+1];
                maxNum = Math.max(maxNum, total);
                total2+=paper[save.get(1)][i]+ paper[save.get(0)][i+1];
                maxNum = Math.max(maxNum, total2);
            }
        }
    }

}

