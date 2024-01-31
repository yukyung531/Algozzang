//우열님코드
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

static boolean np (int[] arr){
    int i = arr.length-1;
    while (i>0&&arr[i]<=arr[i-1]) i--;
    if (i==0) return false;
    int j = arr.length-1;
    while (arr[j]<=arr[i-1]) j--;
    swap(arr, i-1, j);
    int k = arr.length-1;
    while (i<k){
        swap(arr, i++, k--);
    }
    return true;
}

static void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    List<int[]> house = new ArrayList<>();
    List<int[]> chickenHouse = new ArrayList<>();
    for (int i=0; i<N; i++){
        st = new StringTokenizer(br.readLine());
        for (int j=0; j<N; j++){
            int val = Integer.parseInt(st.nextToken());
            if (val==1){
                house.add(new int[]{i, j});
            }
            if (val==2){
                chickenHouse.add(new int[]{i, j});
            }
        }
    }

    int[][] distance = new int[house.size()][chickenHouse.size()];

    for (int i=0; i<distance.length; i++){
        for (int j=0; j<distance[i].length; j++){
            distance[i][j] = Math.abs(house.get(i)[0]-chickenHouse.get(j)[0])
                    + Math.abs(house.get(i)[1]-chickenHouse.get(j)[1]);
        }
    }
    int[] arr = new int[chickenHouse.size()];
    for (int i=0; i<M; i++){
        arr[arr.length-1-i] = 1;
    }
//        for (int[] a: house){
//            System.out.println(Arrays.toString(a));
//        }
//        for (int[] a:chickenHouse){
//            System.out.println(Arrays.toString(a));
//        }
//
//        System.out.println(Arrays.deepToString(distance));
        int min = Integer.MAX_VALUE;
        do {
            int[] chickenDis = new int[house.size()];
            Arrays.fill(chickenDis, Integer.MAX_VALUE);
            for (int i=0; i<arr.length; i++){
                if (arr[i]!=1) continue;;
                for (int j=0; j<chickenDis.length; j++){
                    chickenDis[j] = Math.min(chickenDis[j], distance[j][i]);
                }
            }

        int sum = 0;
        for (int val : chickenDis){
            sum+=val;
//                System.out.print(val+" ");
            }
//            System.out.println();
            min = Math.min(sum, min);
        } while (np(arr));
        System.out.println(min);
    }
}