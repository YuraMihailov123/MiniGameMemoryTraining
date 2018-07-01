package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.AlgorithmClass.*;
import static com.company.Main.*;

class ActionListenersClass {

    static ActionListener randomizeWords = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            RandomizeLocationButtons();
        }
    };

    static ActionListener delayBeforeLoad = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < _buttons.length; i++) {
                _buttons[i].setEnabled(true);
            }
            _isGaming=true;
            BackToWhiteColor();
            RandomizeLocationButtons();
            BaseLanguageWordsColoring();
            timer3[0] = new Timer(1000, gameTimer);
            timer3[0].start();
            //System.out.println("done Job");
            //timer4[0].stop();
        }
    };

    static ActionListener importWordsIntoGame = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(_iterator <_buttons.length/2) {
               GetPairsAndDivideThem();
                _iterator++;
            }else {
                timer[0].stop();


                if(_startWithRandomisize) {
                    for (int i = 0; i < _buttons.length; i++) {
                        _buttons[i].setEnabled(true);
                    }
                    _isGaming=true;
                    RandomizeLocationButtons();
                    BaseLanguageWordsColoring();
                    timer3[0] = new Timer(1000, gameTimer);
                    timer3[0].start();
                }
                else {
                    BaseLanguageWordsColoring();
                    //timer4[0]= new Timer(20000,delayBeforeLoad);
                    //timer4[0].start();
                }

            }

        }
    };

    static ActionListener backToDefaultColor = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < _baseLanguageWords.length; i++) {
                if (_buttons[_buttonNumberBackToWhite].getText().equals(_baseLanguageWords[i]))
                    _buttons[_buttonNumberBackToWhite].setBackground(Color.CYAN);
                else if  (_buttons[_buttonPressedNumber].getText().equals(_baseLanguageWords[i]))
                    _buttons[_buttonPressedNumber].setBackground(Color.CYAN);
            }
            if (_buttons[_buttonNumberBackToWhite].getBackground()== Color.RED)
                _buttons[_buttonNumberBackToWhite].setBackground(Color.WHITE);
            if (_buttons[_buttonPressedNumber].getBackground()== Color.RED)
                _buttons[_buttonPressedNumber].setBackground(Color.WHITE);
            _isGaming=true;
            timer2[0].stop();
        }
    };

    static ActionListener gameTimer = new ActionListener() {
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
