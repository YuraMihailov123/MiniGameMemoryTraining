package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import static com.company.AlgorithmClass.*;
import static com.company.Main.*;

class ActionListenersClass {

    static ActionListener undoAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(_isEnabledUndo){
                if(_ifWas) {
                    _scoreLabel.setText(": " + (--_score));
                    UndoVoid(_buttonPressedNumber,_twoWords[1]);
                    UndoVoid(_buttonNumberBackToWhite,_twoWords[0]);
                    _buttons[_buttonPressedNumber].setText(_twoWords[1]);
                    _buttons[_buttonNumberBackToWhite].setText(_twoWords[0]);
                    _buttons[_buttonNumberBackToWhite].setEnabled(true);
                    _buttons[_buttonPressedNumber].setEnabled(true);
                }
                else _errorLabel.setText(": "+(--_error));
                _isEnabledUndo=!_isEnabledUndo;
                _undoButton.setEnabled(_isEnabledUndo);
            }
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
            CheckIfButtonEmpty();

            BaseLanguageWordsColoring();
            if(!_isRestatr) {
                timer3[0] = new Timer(1000, gameTimer);
                timer3[0].start();
                _isRestatr=!_isRestatr;
            }
        }
    };

    static ActionListener importWordsIntoGame = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(_isWon) {
                _iterator = 0;
                //_isWon=!_isWon;
            }
            System.out.println("---"+_iterator);
            if(GetPairsAndDivideThem() ) {
                System.out.println("done it");

            }else {
                timer[0].stop();
                if(_canWeShuffle) {
                    ShuffleList();
                    _canWeShuffle=!_canWeShuffle;
                }
                SetButtonsPairsText();

                if (_startWithRandomisize) {
                    for (int i = 0; i < _buttons.length; i++) {
                        _buttons[i].setEnabled(true);
                    }
                    _isGaming = true;
                    RandomizeLocationButtons();

                    IfAllPairsLoaded();
                    BaseLanguageWordsColoring();
                    BaseLanguageWordsNativeColoring();
                    CheckIfButtonEmpty();
                    if (!_isRestatr) {
                        timer3[0] = new Timer(1000, gameTimer);
                        timer3[0].start();
                        _isRestatr = !_isRestatr;
                    }
                } else {
                    BaseLanguageWordsColoring();
                    BaseLanguageWordsNativeColoring();
                    CheckIfButtonEmpty();
                    IfAllPairsLoaded();
                    //timer4[0]= new Timer(20000,delayBeforeLoad);
                    //timer4[0].start();
                }
            }
        }

    };

    static ActionListener addPairsToErrorLists = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if(_error>0) {
                    outfile1 = new FileWriter("src/com/company/Data/error_list1.txt", true);
                    outfile2 = new FileWriter("src/com/company/Data/error_list2.txt", true);
                    String[] errorPair = new String[2];
                    errorPair[0] = _buttons[_buttonPressedNumber].getText();
                    errorPair[1] = _buttons[_buttonNumberBackToWhite].getText();
                    if (!errorPair[0].equals("")) {
                        for (int i = 0; i < _pairs.length; i++) {
                            if (_pairs[i].contains(errorPair[0])) {
                                outfile1.write(_pairs[i] + "\n");
                                outfile1.flush();
                            }
                            if (_pairs[i].contains(errorPair[1])) {
                                outfile2.write(_pairs[i] + "\n");
                                outfile2.flush();
                            }
                        }
                    }
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    };

    static ActionListener backToDefaultColor = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < _baseLanguageWords.size(); i++) {
                if (_buttons[_buttonNumberBackToWhite].getText().equals(_baseLanguageWords.get(i)))
                    _buttons[_buttonNumberBackToWhite].setBackground(pale_blue);
                else if  (_buttons[_buttonPressedNumber].getText().equals(_baseLanguageWords.get(i)))
                    _buttons[_buttonPressedNumber].setBackground(pale_blue);
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
