package tictactoe;

import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Input command:");
            String[] options = s.nextLine().trim().split(" ");
            if (options[0].equals("exit"))
                return;
            if (options.length != 3) {
                System.out.println("Bad parameters!");
                continue;
            }
            if(options[0].equals("start")) {
                if (options[1].equals("easy") && options[2].equals("easy")) {
                    EasyAndEasy eVSe = new EasyAndEasy();
                    eVSe.main();
                    continue;
                }
                else if (options[1].equals("easy") && options[2].equals("user")) {
                    EasyAndUser eVSu = new EasyAndUser();
                    eVSu.main(1);
                    continue;
                }
                else if (options[1].equals("user") && options[2].equals("easy")) {
                    EasyAndUser uVSe = new EasyAndUser();
                    uVSe.main(0);
                    continue;
                }
                else if (options[1].equals("user") && options[2].equals("user")) {
                    DoublePlayer uVSu=new DoublePlayer();
                    uVSu.main();
                    continue;
                }
                else if (options[1].equals("user") && options[2].equals("medium")) {
                    MediumAndUser uVSm=new MediumAndUser();
                    uVSm.main(0);
                }
                else if (options[1].equals("medium") && options[2].equals("user")) {
                    MediumAndUser uVSm=new MediumAndUser();
                    uVSm.main(1);
                }
                else if(options[1].equals("medium")&&options[2].equals("medium"))
                {
                    MediumAndMedium mVSm=new MediumAndMedium();
                    mVSm.main();
                }
                else if(options[1].equals("easy")&&options[2].equals("medium"))
                {
                    MediumAndEasy mVSm=new MediumAndEasy();
                    mVSm.main(0);
                }
                else if(options[1].equals("medium")&&options[2].equals("easy"))
                {
                    MediumAndEasy mVSm=new MediumAndEasy();
                    mVSm.main(1);
                }
                else if(options[1].equals("user")&&options[2].equals("hard"))
                {
                    HardAndUser uVSh=new HardAndUser();
                    uVSh.main(0);
                }
                else if(options[1].equals("hard")&&options[2].equals("user"))
                {
                    HardAndUser hVSu=new HardAndUser();
                    hVSu.main(1);
                }
                else if(options[1].equals("hard")&&options[2].equals("hard"))
                {
                    HardAndHard hVSh=new HardAndHard();
                    hVSh.main(0);
                }
                else if(options[1].equals("easy")&&options[2].equals("hard"))
                {
                    HardAndEasy eVSh=new HardAndEasy();
                    eVSh.main(0);
                }
                else if(options[1].equals("hard")&&options[2].equals("easy"))
                {
                    HardAndEasy hVSe=new HardAndEasy();
                    hVSe.main(1);
                }
                else if(options[1].equals("medium")&&options[2].equals("hard"))
                {
                    HardAndMedium mVSh=new HardAndMedium();
                    mVSh.main(0);
                }
                else if(options[1].equals("hard")&&options[2].equals("medium"))
                {
                    HardAndMedium hVSm=new HardAndMedium();
                    hVSm.main(1);
                }
                else
                {
                    System.out.println("Bad parameters!");
                    continue;
                }
            }
            else
                System.out.println("Bad parameters!");
        }
    }
}

