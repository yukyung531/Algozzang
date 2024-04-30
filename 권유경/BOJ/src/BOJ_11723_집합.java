import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> S = new ArrayList<>();
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command){
                case "add" :
                    int x =Integer.parseInt(st.nextToken());
                    if(!S.contains(x)) S.add(x);
                    break;

                case "remove" :
                    x =Integer.parseInt(st.nextToken());
                    if(S.contains(x)) S.remove(Integer.valueOf(x));
                    break;

                case"check":
                    x =Integer.parseInt(st.nextToken());
                    if(S.contains(x)) bw.write("1\n");
                    else bw.write("0\n");
                    break;

                case "toggle" :
                    x =Integer.parseInt(st.nextToken());
                    if(S.contains(x)) S.remove(Integer.valueOf(x));
                    else S.add(x);
                    break;

                case "all" :
                    S.clear();
                    for(int j = 1; j<=20; j++){
                        S.add(j);
                    }
                    break;

                case  "empty":
                    S.clear();
                    break;
            }
        }
        bw.close();
        br.close();
    }
}
