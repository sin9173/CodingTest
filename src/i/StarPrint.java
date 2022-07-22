package i;


import java.io.*;

public class StarPrint {

    public static int num = 0;
    public static String[][] map = null;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(bf.readLine());
        map = new String[num+1][num+1];

        draw(1, 1, num/3);
        //draw(4, 1, 1);
//        draw(1, 4, 3, 1);
//        draw(4, 4, 6, 1);

        for(int i=1 ; i<=num ; i++) {
            for(int j=1 ; j<=num ; j++) {
                bw.write(map[i][j]==null?" ":map[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void draw(int start, int line, int a) {
        int flag = 0;
        int hor = start;
        int ver = line;

        System.out.println("vertical : " + ver);
        System.out.println("horizon : " + hor);
        System.out.println("a : " + a);

        if(a<0) a *= -1;

        while(true) {
            if(a==1 || a==-1) {
//                System.out.println("vertical : " + ver);
//                System.out.println("horizon : " + hor);
                map[ver][hor] = "*";
            } else {
                draw(hor, ver, a/3);
            }

            if(flag==0) {
                if((a>0 && hor==start + (a * 2)) || (a<0 && hor==start)){
                    flag=1;
                } else {
                    hor+=a;
                }
            }
            else{
                if((a>0 && ver==line + (a * 2)) || (a<0 && ver==line)) {
                    flag=0;
                    a *= -1;
                } else {
                    ver+=a;
                }
            }
//            System.out.println("vertical : " + ver);
//            System.out.println("horizon : " + hor);
            if(hor==start && ver==line) break;
        }
        System.out.println("끄~읕!!");
    }
}
