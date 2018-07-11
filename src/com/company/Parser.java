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

    static String GetParametres(String u){
        String write="";
        int p=0;
        i_gr=0;
        StringBuffer buff;
        char[] o = u.toCharArray();
        for (i_gr = 0; i_gr < o.length; i_gr++) {
            if(o[i_gr]=='\\'){
                switch (o[i_gr+1]){
                    case '1':
                        p++;
                        i_gr++;
                        //if(!write.equals("")) return write;
                    height/=6;
                        break;
                        //break;
                    case '2':
                        p++;
                        i_gr++;
                        //if(!write.equals("")) return write;
                        height=height/3;

                        break;
                    case '3':
                        p++;
                        i_gr++;
                        height/=2;
                        //if(!write.equals("")) return write;
                        break;
                    case '4':
                        p++;
                        i_gr++;
                        //if(!write.equals("")) return write;
                        height=height*2/3;
                        break;
                    case '5':
                        p++;
                        i_gr++;
                        //if(!write.equals("")) return write;
                        height=height*5/6;
                        break;
                    case '6':
                        p++;
                        i_gr++;
                        //if(!write.equals("
                        break;
                    case 'р':
                        p++;
                        i_gr++;
                        colorToColor = Color.PINK;

                        break;
                    case 'о':
                        p++;
                        i_gr++;
                        colorToColor = Color.ORANGE;
                        break;

                    case 'з':
                        p++;
                        i_gr++;
                        colorToColor = Color.GREEN;
                        break;
                    case 'г':
                        p++;
                        i_gr++;
                        colorToColor = Color.CYAN;
                        break;
                    case 'с':
                        p++;
                        i_gr++;
                        colorToColor = Color.BLUE;
                        break;
                    case 'ф':
                        p++;
                        i_gr++;
                        colorToColor = Color.MAGENTA;
                        break;
                    case 'ч':
                        p++;
                        i_gr++;
                        colorToColor = Color.BLACK;
                        break;
                    case 'е':
                        p++;
                        i_gr++;
                        colorToColor = Color.GRAY;
                        break;
                    case 'к':
                        p++;
                        i_gr++;
                        colorToColor = new Color(139,0,0);
                        break;

                    default:
                        write+=o[i_gr];
                        break;
                }
            }else {
//                System.out.println(o[i_gr+1]);
                write = write+o[i_gr];
                System.out.println(write);
                if(i_gr+1<o.length) {
                    if (o[i_gr + 1] == '\\') {

                        return write;
                    }
                }
                //height=_sizeSquare_y;
            }
        }
        //write.substring(5);
        //buff = new StringBuffer(u);
        //buff.delete(0, p*2);
        //u = buff.toString();
        return write;
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
                        i++;
                        //if(!write.equals("")) return write;
                        //height/=6;
                        break;
                    //break;
                    case '2':
                        p++;
                        i++;
                        //if(!write.equals("")) return write;
                        //height=height/3;

                        break;
                    case '3':
                        p++;
                        i++;
                        //height/=2;
                        //if(!write.equals("")) return write;
                        break;
                    case '4':
                        p++;
                        i++;
                        //if(!write.equals("")) return write;
                        //height=height*2/3;
                        break;
                    case '5':
                        p++;
                        i++;
                        //if(!write.equals("")) return write;
                        //height=height*5/6;
                        break;
                    case '6':
                        p++;
                        i++;
                        //if(!write.equals("
                        break;
                    case 'р':
                        p++;
                        i++;
                        //colorToColor = Color.PINK;

                        break;
                    case 'о':
                        p++;
                        i++;
                        //colorToColor = Color.ORANGE;
                        break;

                    case 'з':
                        p++;
                        i++;
                        //colorToColor = Color.GREEN;
                        break;
                    case 'г':
                        p++;
                        i++;
                        //colorToColor = Color.CYAN;
                        break;
                    case 'с':
                        p++;
                        i++;
                        //colorToColor = Color.BLUE;
                        break;
                    case 'ф':
                        p++;
                        i++;
                        //colorToColor = Color.MAGENTA;
                        break;
                    case 'ч':
                        p++;
                        i++;
                        break;
                    case 'е':
                        p++;
                        i++;
                        //colorToColor = Color.GRAY;
                        break;
                    case 'к':
                        p++;
                        i++;
                        //colorToColor = Color.GRAY;
                        break;

                    default:
                        write+=o[i];
                        break;
                }
            }else {
                write +=o[i];
                System.out.println(write);
            }
        }

        //buff = new StringBuffer(u);
        //buff.delete(0, p*2);
        //u = buff.toString();
        return write;
    }

}
