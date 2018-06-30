package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static com.company.AlgorithmClass.OpenFile;
import static com.company.AlgorithmClass.RandomizeLocationButtons;
import static com.company.Main.*;

class ActionListenersClass {

    static ActionListener startGame = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                rf = new FileReader("src/com/company/file.txt");
                scan = new Scanner(rf);
            } catch (FileNotFoundException e1) {
                System.out.println("File not found!");
            }

            timer[0] = new Timer(100, listener);
            timer[0].start();

        }
    };

    static ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(_iterator <32) {
               OpenFile();
                _iterator++;
            }else {
                timer[0].stop();
                for (int i = 0; i < 64; i++) {
                    _buttons[i].setEnabled(true);
                }
                _isGaming=true;
                RandomizeLocationButtons();
                timer3[0] = new Timer(1000,listener3);
                timer3[0].start();
            }

        }
    };

    static ActionListener listener2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            _buttons[_buttonNumberBackToWhite].setBackground(Color.WHITE);
            _buttons[_buttonPressedNumber].setBackground(Color.WHITE);
            _isGaming=true;
            timer2[0].stop();
        }
    };

    static ActionListener listener3 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //00 00 00
            if(timerGame[2]<60)
                timerGame[2]+=1;
            if(timerGame[2]==60) {
                timerGame[2]=0;
                if(timerGame[1]<60)
                    timerGame[1]+=1;
                if(timerGame[1]==60) {
                    timerGame[0] += 1;
                    timerGame[1]=0;
                }
            }
            String tmp1,tmp2,tmp3;
            if(timerGame[2]<10)
                tmp1 = "0"+timerGame[2];
            else
                tmp1 = ""+timerGame[2];

            if(timerGame[1]<10)
                tmp2 = "0"+timerGame[1];
            else
                tmp2 = ""+timerGame[1];

            if(timerGame[0]<10)
                tmp3 = "0"+timerGame[0];
            else
                tmp3 = ""+timerGame[0];

            _timeLabel.setText("Время: "+tmp3+":"+tmp2+":"+tmp1);

        }
    };

}
