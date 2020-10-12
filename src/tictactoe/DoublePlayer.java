package tictactoe;

import java.util.*;
import java.lang.*;
public class DoublePlayer {
    public static void main()
    {
        MethodsClass m=new MethodsClass();
        Scanner s=new Scanner(System.in);
        char[][] arr=new char[3][3];
        int i,j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                arr[i][j]= ' ';
            }
        }
        m.printarr(arr);
        int c=0,b=0,a=0,use,ch=0,space=9;
        boolean flag=false;
        while(true)
        {
            System.out.println("Enter the coordinates:");
            String str1=s.next();
            String str2=s.next();
            flag=m.checkint(str1,str2);
            if(flag) {
                System.out.println("You should enter numbers!");
                continue;
            }
            flag=m.checkright(str1,str2);
            if(flag) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            a=Integer.parseInt(str1);
            b=Integer.parseInt(str2);
            use=a;
            a=3-b;
            b=use-1;
            flag=m.checkocc(a,b,arr);
            if(flag) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            space--;
            if(ch%2==0)
                arr[a][b]='X';
            else
                arr[a][b]='O';
            ch++;
            m.printarr(arr);
            String temp = m.checkwinmain(arr, space);
            if (!temp.equals("0")) {
                System.out.println(temp);
                return;
            }
        }
    }
}

