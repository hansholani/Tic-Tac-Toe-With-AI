package tictactoe;

import java.util.*;
import java.lang.*;
import java.lang.Math;
public class HardAndUser {
    public static char user,cpu;
    public static void main(int ch) {
        MethodsClass m=new MethodsClass();
        Scanner s = new Scanner(System.in);
        char[][] arr = new char[3][3];
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                arr[i][j] = ' ';
            }
        }
        m.printarr(arr);
        if(ch%2==0)
        {
            user='X';
            cpu='O';
        }
        else
        {
            user='O';
            cpu='X';
        }
        int checkflag=ch;
        Random r = new Random();
        int c = 0, b = 0, a = 0, use, space = 9;
        boolean flag = false;
        String str1 = "", str2 = "";
        while (true) {
            boolean flagCheckUser=true;
            if (ch % 2 == 0) {
                System.out.println("Enter the coordinates:");
                str1 = s.next();
                str2 = s.next();
            } else {
                flagCheckUser=false;
                String bestmove=bestMove(arr,space);
                str1 = bestmove.charAt(0)+"";
                str2 = bestmove.charAt(1)+"";
            }
            a = Integer.parseInt(str1);
            b = Integer.parseInt(str2);
            if(flagCheckUser) {
                flag = m.checkint(str1, str2);
                if (flag) {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                flag = m.checkright(str1, str2);
                if (flag) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;

                }
                    use = a;
                    a = 3 - b;
                    b = use - 1;
                flag = m.checkocc(a, b, arr);
                if (flag) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
            }
            if(ch%2==0)
                arr[a][b]=user;
            space--;
            if(ch%2!=0)
            {
                System.out.println("Making move level \"hard\"");
                arr[a][b]=cpu;
            }
            ch++;
            m.printarr(arr);
            String temp = m.checkwinmain(arr,space);
            if(!temp.equals("0"))
            {
                System.out.println(temp);
                return;
            }
        }
    }

    public static int minimax(char[][] arr,int space,boolean flag)
    {
        MethodsClass m=new MethodsClass();
        String check=m.checkwinmain(arr,space);
        if(check.equals("0")) {
            if (flag) {
                int max = -100;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (arr[i][j] != 'X' && arr[i][j] != 'O') {
                            arr[i][j] = cpu;
                            max =Math.max(minimax(arr, space - 1, false),max);
                            arr[i][j] = ' ';
                        }
                    }
                }
                return max;
            }
            else
            {
                int min=100;
                for(int i=0;i<3;i++)
                {
                    for(int j=0;j<3;j++)
                    {
                        if (arr[i][j] != 'X' && arr[i][j] != 'O') {
                            arr[i][j] = user;
                            min =Math.min(minimax(arr, space - 1, true),min);
                            arr[i][j] = ' ';
                        }
                    }
                }
                return min;
            }
        }
        else if(check.equals(user+" wins"))
            return -10;
        else if(check.equals("Draw"))
            return 0;
        else
            return 10;
    }
    public static String bestMove(char[][] arr,int space)
    {
        int best=-100;
        String result="";
        for(int i=0;i<3;i++)
        {
            for(int j=0; j<3;j++)
            {
                if(arr[i][j]==' ') {
                    arr[i][j] = cpu;
                    int x = minimax(arr, space-1, false);
                    if (x > best) {
                        best = x;
                        result = String.valueOf(i) + String.valueOf(j);
                    }
                    arr[i][j]=' ';
                }

            }
        }
        return result;
    }
}

