package tictactoe;

import java.lang.invoke.MethodHandle;
import java.util.*;
import java.lang.*;
import java.lang.Math;
public class HardAndHard {
    public static char user,cpu;
    public static void main(int ch) {
        MethodsClass m=new MethodsClass();
        char[][] arr = new char[3][3];
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                arr[i][j] = ' ';
            }
        }
        m.printarr(arr);
        user='X';
        cpu='O';
        int checkflag=ch;
        Random r = new Random();
        int c = 0, b = 0, a = 0, use, space = 9;
        boolean flag = false;
        String str1 = "", str2 = "",bestmove="";
        while (true) {
            if(ch%2==0)
                bestmove=bestMove1(arr,space);
            else
                bestmove=bestMove2(arr,space);
            str1 = bestmove.charAt(0)+"";
            str2 = bestmove.charAt(1)+"";
            a = Integer.parseInt(str1);
            b = Integer.parseInt(str2);
            space--;
            System.out.println("Making move level \"hard\"");
            if(ch%2==0)
                arr[a][b] = user;
            if(ch%2!=0)
                arr[a][b]=cpu;
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
    public static int minimax1(char[][] arr,int space,boolean flag)
    {
        MethodsClass m=new MethodsClass();
        String check=m.checkwinmain(arr,space);
        if(check.equals("0")) {
            if (flag) {
                int max = -100;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (arr[i][j] != 'X' && arr[i][j] != 'O') {
                            arr[i][j] = user;
                            max =Math.max(minimax1(arr, space - 1, false),max);
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
                            arr[i][j] = cpu;
                            min =Math.min(minimax1(arr, space - 1, true),min);
                            arr[i][j] = ' ';
                        }
                    }
                }
                return min;
            }
        }
        else if(check.equals(user+" wins"))
            return 10;
        else if(check.equals("Draw"))
            return 0;
        else
            return -10;
    }
    public static String bestMove1(char[][] arr,int space)
    {
        int best=-100;
        String result="";
        for(int i=0;i<3;i++)
        {
            for(int j=0; j<3;j++)
            {
                if(arr[i][j]==' ') {
                    arr[i][j] = user;
                    int x = minimax1(arr, space-1, false);
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
    public static int minimax2(char[][] arr,int space,boolean flag)
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
                            max =Math.max(minimax2(arr, space - 1, false),max);
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
                            min =Math.min(minimax2(arr, space - 1, true),min);
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
    public static String bestMove2(char[][] arr,int space)
    {
        int best=-100;
        String result="";
        for(int i=0;i<3;i++)
        {
            for(int j=0; j<3;j++)
            {
                if(arr[i][j]==' ') {
                    arr[i][j] = cpu;
                    int x = minimax2(arr, space-1, false);
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

