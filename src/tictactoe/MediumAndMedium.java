package tictactoe;

import java.util.*;
import java.lang.*;
public class MediumAndMedium {
    public static void main() {
        MethodsClass m=new MethodsClass();
        char[][] arr = new char[3][3];
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                arr[i][j] = ' ';
            }
        }
        m.printarr(arr);
        int ch=0;
        char option='X';
        int checkflag=ch;
        Random r = new Random();
        int c = 0, b = 0, a = 0, use, space = 9;
        boolean flag = false;
        String str1 = "", str2 = "";
        while (true) {
            boolean flagCheckUser=false;
            String checkUser = m.checkUserWin(arr, checkflag, space);
            if (!checkUser.equals("0")) {
                flagCheckUser=true;
                str1 = checkUser.charAt(0) + "";
                str2 = checkUser.charAt(1) + "";
            } else {
                str1 = String.valueOf(r.nextInt(3));
                str2 = String.valueOf(r.nextInt(3));
            }

            a = Integer.parseInt(str1);
            b = Integer.parseInt(str2);
            if(flagCheckUser!=true) {
                flag = m.checkocc(a, b, arr);
                if (flag) {
                    continue;
                }
            }
            space--;
            System.out.println("Making move level \"medium\"");
            arr[a][b]=option;
            option=option=='X'?'O':'X';
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
}

