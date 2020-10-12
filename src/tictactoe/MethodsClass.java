package tictactoe;

public class MethodsClass {
    public static void printarr(char[][] arr)
    {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" "+arr[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }
    public static String checkUserWin(char[][] arr,int checkflag,int space)
    {
        char user,cpu;
        String cpuwin="",userwin="";
        user=checkflag%2==0?'X':'O';
        cpu=user=='X'?'O':'X';
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(arr[i][j]!='X'&& arr[i][j]!='O')
                {
                    char temp=arr[i][j];
                    arr[i][j]=user;
                    String check=checkwinmain(arr,space);
                    if(check.equals(user+" wins")) {
                        userwin=String.valueOf(i)+String.valueOf(j);
                    }
                    arr[i][j]=cpu;
                    check=checkwinmain(arr,space);
                    if(check.equals(cpu+" wins")) {
                        cpuwin = String.valueOf(i) + String.valueOf(j);
                    }
                    arr[i][j]=temp;
                }
            }
        }
        if(cpuwin!="")
            return cpuwin;
        if(userwin!="")
            return userwin;
        return "0";
    }
    public static boolean checkwin(int i,int j,char[][] arr,char h)
    {
        int sum;
        sum=arr[i][0]+arr[i][1]+arr[i][2];
        if(h=='X') {
            if (sum == 264)
                return true;
        }
        if(h=='O') {
            if (sum == 237)
                return true;
        }
        sum=arr[0][j]+arr[1][j]+arr[2][j];
        if(h=='X') {
            if (sum == 264)
                return true;
        }
        if(h=='O') {
            if (sum == 237)
                return true;
        }
        if(i==j) {
            sum = arr[0][0]+ arr[1][1]+ arr[2][2];
            if (h == 'X') {
                if (sum == 264)
                    return true;
            }
            if (h == 'O') {
                if (sum == 237)
                    return true;
            }
            sum = arr[0][2]+ arr[1][1]+ arr[2][0];
            if (h == 'X') {
                if (sum == 264)
                    return true;
            }
            if (h == 'O') {
                if (sum == 237)
                    return true;
            }
        }
        return false;
    }
    public static String checkwinmain(char[][] arr,int space)
    {
        int x=0,o=0;
        char h;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                h = arr[i][j];
                if (h == 'X') {
                    if(checkwin(i,j,arr,h))
                        x++;
                }
                else if (h == 'O') {
                    if(checkwin(i,j,arr,h))
                        o++;
                }

            }
        }
        if(x>0) {
            return "X wins";
        }
        if(o>0) {
            return "O wins";
        }
        if(space==0)
        {
            return "Draw";
        }
        return "0";
    }
    public static boolean checkint(String a,String b)
    {
        char x[]=a.toCharArray();
        char y[]=b.toCharArray();
        int i=0,c=0;
        while(i!=x.length)
        {
            if(!(x[i]>='0'&&x[i]<='9'))
            {
                c++;
                break;
            }
            i++;
        }
        i=0;
        while(i!=y.length)
        {
            if(!(y[i]>='0'&&y[i]<='9'))
            {
                c++;
                break;
            }
            i++;
        }
        if(c>0)
        {
            return true;
        }
        else
            return false;
    }
    public static boolean checkright(String a,String b)
    {
        int x=Integer.parseInt(a);
        int y=Integer.parseInt(b);
        if(x>3 || x<1) {
            return true;
        }
        else if(y>3 || y<1) {
            return true;
        }
        else
            return false;
    }
    public static boolean checkocc(int a,int b, char[][] arr)
    {
            if(arr[a][b]=='X'||arr[a][b]=='O')
                return true;
            else
                return false;

    }
}
