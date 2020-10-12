package tictactoe;

import java.util.*;
import java.lang.*;
public class EasyAndUser {
    public static void main(int ch) {
        MethodsClass m = new MethodsClass();
        Scanner s = new Scanner(System.in);
        char[][] arr = new char[3][3];
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                arr[i][j] = ' ';
            }
        }
        m.printarr(arr);
        char option = 'X';
        Random r = new Random();
        int c = 0, b = 0, a = 0, use, space = 9;
        boolean flag = false;
        String str1 = "", str2 = "";
        while (true) {
            if (ch % 2 == 0) {
                System.out.println("Enter the coordinates:");
                str1 = s.next();
                str2 = s.next();
            } else {
                str1 = String.valueOf(r.nextInt(3));
                str2 = String.valueOf(r.nextInt(3));
            }

            flag = m.checkint(str1, str2);
            if (flag) {
                if (ch % 2 == 0)
                    System.out.println("You should enter numbers!");
                continue;
            }
            flag = m.checkright(str1, str2);
            if(ch%2==0) {
                if (flag) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
            }
            a = Integer.parseInt(str1);
            b = Integer.parseInt(str2);
            if(ch%2==0) {
                use = a;
                a = 3 - b;
                b = use - 1;
            }
            flag = m.checkocc(a, b, arr);
            if (flag) {
                if (ch % 2 == 0)
                    System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            space--;

            if (ch % 2 != 0) {
                System.out.println("Making move level \"easy\"");
            }
            arr[a][b] = option;
            option = option == 'X' ? 'O' : 'X';
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

