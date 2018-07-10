package com.company;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import static com.company.InitializeClass.*;
import static com.company.Main.*;

public class Parser {
    //static  str = "\6dog \г\4\собака";
    static String str;
    static char[] ch;
    static char tt='\\';
    static void ParseString(){
        try {
            //rf = new FileReader("src/com/company/Data/file.txt");

            FileInputStream fis = new FileInputStream("src/com/company/Data/error_list2.txt");
            try {
                rf = new InputStreamReader(fis,"UTF-8");
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            scan = new Scanner(rf);
            str = scan.nextLine();
            System.out.println(str);
            ch = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                System.out.println(ch[i]);

            }
            //System.out.println(tt);
            //GetParametres();
            if(_isSoundEnable)
                AudioClass.AudioClassCreateClick("click.wav");
        } catch (FileNotFoundException e1) {
            System.out.println("File not found!");
        }
    }

    static String GetParametres(String u){
        String write="";
        int p=0;
        StringBuffer buff;
        char[] o = u.toCharArray();
        for (int i = 0; i < o.length; i++) {
            if(o[i]=='\\'){
                switch (o[i+1]){
                    case '1':
                        p++;
                        //if(!write.equals("")) return write;
                    height/=6;
                        break;
                        //break;
                    case '2':
                        p++;
                        //if(!write.equals("")) return write;
                        height=height/3;

                        break;
                    case '3':
                        p++;
                        height/=2;
                        //if(!write.equals("")) return write;
                        break;
                    case '4':
                        p++;
                        //if(!write.equals("")) return write;
                        height=height*2/3;
                        break;
                    case '5':
                        p++;
                        //if(!write.equals("")) return write;
                        height=height*5/6;
                        break;
                    case '6':
                        p++;
                        //if(!write.equals("
                        break;
                    case 'р':
                        p++;
                        colorToColor = Color.PINK;

                        break;
                    case 'о':
                        p++;
                        colorToColor = Color.ORANGE;
                        break;

                    case 'з':
                        p++;
                        colorToColor = Color.GREEN;
                        break;
                    case 'г':
                        p++;
                        colorToColor = Color.CYAN;
                        break;
                    case 'с':
                        p++;
                        colorToColor = Color.BLUE;
                        break;
                    case 'ф':
                        p++;
                        colorToColor = Color.MAGENTA;
                        break;
                    case 'ч':
                        p++;
                        break;
                    case 'е':
                        p++;
                        colorToColor = Color.GRAY;
                        break;

                    default:
                        write+=o[i];
                        break;
                }
            }else {
                //height=_sizeSquare_y;
            }
        }
        //write.substring(5);
        buff = new StringBuffer(u);
        buff.delete(0, p*2);
        u = buff.toString();
        return u;
    }

    static String DelParametres(String u){
        String write="";
        int p=0;
        StringBuffer buff;
        char[] o = u.toCharArray();
        for (int i = 0; i < o.length; i++) {
            if(o[i]=='\\'){
                switch (o[i+1]){
                    case '1':
                        p++;
                        //if(!write.equals("")) return write;
                        //height/=6;
                        break;
                    //break;
                    case '2':
                        p++;
                        //if(!write.equals("")) return write;
                        //height=height/3;

                        break;
                    case '3':
                        p++;
                        //height/=2;
                        //if(!write.equals("")) return write;
                        break;
                    case '4':
                        p++;
                        //if(!write.equals("")) return write;
                        //height=height*2/3;
                        break;
                    case '5':
                        p++;
                        //if(!write.equals("")) return write;
                        //height=height*5/6;
                        break;
                    case '6':
                        p++;
                        //if(!write.equals("
                        break;
                    case 'р':
                        p++;
                        //colorToColor = Color.PINK;

                        break;
                    case 'о':
                        p++;
                        //colorToColor = Color.ORANGE;
                        break;

                    case 'з':
                        p++;
                        //colorToColor = Color.GREEN;
                        break;
                    case 'г':
                        p++;
                        //colorToColor = Color.CYAN;
                        break;
                    case 'с':
                        p++;
                        //colorToColor = Color.BLUE;
                        break;
                    case 'ф':
                        p++;
                        //colorToColor = Color.MAGENTA;
                        break;
                    case 'ч':
                        p++;
                        break;
                    case 'е':
                        p++;
                        //colorToColor = Color.GRAY;
                        break;

                    default:
                        write+=o[i];
                        break;
                }
            }else {
                //height=_sizeSquare_y;
            }
        }
        //write.substring(5);
        buff = new StringBuffer(u);
        buff.delete(0, p*2);
        u = buff.toString();
        return u;
    }

}
