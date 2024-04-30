import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7568_덩치 {
    static class Person{
        int x, y, rank;
        public Person(int x, int y, int rank){
            this.x = x;
            this.y = y;
            this.rank = rank;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Person> list = new ArrayList<>();

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Person p = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            list.add(p);
        }

        br.close();

        int now  = 0;

        // 나보다 덩치가 큰 사람의 수를 구하자
        for(int i = 0; i<N; i++){
            now = 0;
            for(int j = 0; j<N; j++){
                // 나보다 덩치가 큰 사람이 있다면
                if(list.get(i).x < list.get(j).x && list.get(i).y < list.get(j).y){
                    now++;
                }
            }
            // 내 등수는 나보다 덩치 큰 사람 수 + 1
            list.get(i).rank = now+1;
        }

        for(int i = 0; i<N; i++){
            System.out.print(list.get(i).rank+" ");
        }
    }
    // main
}
