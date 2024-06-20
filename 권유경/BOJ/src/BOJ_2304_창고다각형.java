import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2304_창고다각형 {

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 기둥 수

        List<Node> list = new ArrayList<>(); // 노드 좌표 저장할 리스트

        int maxH = 0;

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            maxH = Math.max(maxH, y);

            Node node = new Node(x,y);
            list.add(node);
        }

        // 리스트 오름차순 (x 기준)
        Collections.sort(list, Comparator.comparing(node -> node.x));

        // 가장 높은 높이의 기둥 찾기
        int maxIdx = 0;
        for(int i = 0; i<N; i++){
            if(list.get(i).y == maxH){
                maxIdx = i;
                break;
            }
        }

        int totalStorageSize = 0; // 창고 총 면적


        int i = 0; // 시작기둥
        int j = 1; // 비교기둥

        while(j <= maxIdx){
            // 비교기둥의 높이가 더 크거나 같다면 면적 더하기
            if(list.get(i).y <= list.get(j).y){
                totalStorageSize += (list.get(j).x - list.get(i).x) * list.get(i).y;
                i = j;
                j = i+1;
            }
            else{
                j++;
            }
        }

        totalStorageSize += list.get(maxIdx).y; // 가장 높은 기둥의 높이 더하기

        // 맨 뒤부터 똑같이하기
        i = N-2;
        j = N-1;
        while(i >= maxIdx){
            // 비교기둥의 높이가 더 크더나 같다면 면적 더하기
            if(list.get(i).y >= list.get(j).y){
                totalStorageSize +=  ((list.get(j).x) - (list.get(i).x)) * list.get(j).y;
                j = i;
                i = j-1;

            }
            else{
                i--;
            }
        }

        System.out.println(totalStorageSize);

    }
    // main
}
