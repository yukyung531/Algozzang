import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		
		int apple = sc.nextInt();
		
		for(int i = 0; i<apple; i++) {
			map[sc.nextInt()][sc.nextInt()] = 1;
		}
		
		int L = sc.nextInt(); //방향변환횟수
		
		//방향 우, 하, 좌, 상 (0, 1, 2, 3) - D
		int[] direction = new int[N*N];
		int headi = 0;
		int headj = 0;
		int taili = 0;
		int tailj = 0;
		for(int i = 0; i<L; i++) {
			int tmp = sc.nextInt();
			String dir = sc.next();

			if(dir.equals("D")) {
				direction[tmp] += 1; 
			}else {
				direction[tmp] -= 1;
			}
		}
		
		for(int i = 1; i<N*N; i++) {
			if(direction[i] != 0) {
				direction[i] += direction[i-1];
				if(direction[i]<0) {
					direction[i] += 4;
				}
			}else {
				direction[i] = direction[i-1];
			}
		}
		
		int[] diri = new int[] {0, 1, 0, -1};
		int[] dirj = new int[] {1, 0, -1, 0};
		int result = N*N;;
		//이동
		for(int k = 1; k<=Integer.MAX_VALUE; k++) {
			System.out.println("headi: " + headi+" headj: "+headj+ " k: "+k);
			headi += diri[direction[k-1]];
			headj += dirj[direction[k-1]];
			if(headi<0 || headi>=N || headj<0 || headj>=N || map[headi][headj] ==2) {
				result = k;
				break;
			}else if(map[headi][headj] == 1) {
				map[headi][headj] = 2;
			}else {
				map[taili][tailj] = 0;//이동함
				taili += diri[direction[k-1]];
				tailj += dirj[direction[k-1]];
			}
		}
		
		System.out.println(result);
		
		
	}
}
