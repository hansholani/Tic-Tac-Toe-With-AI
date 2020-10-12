package tictactoe;

import java.util.*;
import java.lang.*;
public class EasyAndEasy {
    public static void main()
    {
        MethodsClass m=new MethodsClass();
        char[][] arr=new char[3][3];
        int i,j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                arr[i][j]= ' ';
            }
        }
        m.printarr(arr);
        Random r=new Random();
        int c=0,b=0,a=0,use,ch=0,space=9;
        boolean flag=false;
        while(true)
        {
            String str1= String.valueOf(r.nextInt(3));
            String str2= String.valueOf(r.nextInt(3));
            a=Integer.parseInt(str1);
            b=Integer.parseInt(str2);
            flag=m.checkocc(a,b,arr);
            if(flag)
                continue;
            space--;
            if(ch%2==0)
                arr[a][b]='X';
            else
                arr[a][b]='O';
            ch++;
            System.out.println("Making move level easy");
            m.printarr(arr);
            String temp = m.checkwinmain(arr, space);
            if (!temp.equals("0")) {
                System.out.println(temp);
                return;
            }
        }
    }
}

