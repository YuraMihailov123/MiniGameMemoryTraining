package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static com.company.ActionListenersClass.backToDefaultColor;
import static com.company.Main.*;

class AlgorithmClass {

    static void CheckIfWin(){
        int count=0;
        for (int i = 0; i < _buttons.length; i++) {
            if(!_buttons[i].isEnabled()) count++;
        }
        if(count==_buttons.length) System.out.println("You win!");
    }

    static void GetPairsAndDivideThem() {
        String temp1,temp2;
        String str="";
        str = scan.nextLine();
        _pairs[_countPairs] = str;
        if(scan.hasNextLine() && _countPairs<_buttons.length/2){
            temp1="";
            temp2="";
            int _temp = GetSpaceInString(str);
            temp1 = str.substring(0, _temp);
            _baseLanguageWords[_countPairs] = temp1;
            _buttons[_countPairs].setText(temp1);
            temp2 = str.substring(_temp + 1);
            //_baseLanguageWords2[_countPairs] = temp2;
            _buttons[_countPairs+_buttons.length/2].setText(temp2);
            _buttons[_countPairs].setBackground(Color.WHITE);
            _buttons[_countPairs+_buttons.length/2].setBackground(Color.WHITE);

            AudioClass.AudioClassCreateClick("clickApper.wav");

            _countPairs++;
        }

    }
    private static int GetSpaceInString(String str){
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==' '){
                return i;
            }
        }
        return 0;
    }
    static void RandomizeLocationButtons(){
        for (int i = 0; i < _buttons.length; i++) {
            Random random = new Random();
            int num = random.nextInt(_buttons.length);
            System.out.println(num);
            while(i==num) {
                num = random.nextInt(_buttons.length);
            }
            String temp = _buttons[i].getText();
            _buttons[i].setText(_buttons[num].getText());
            _buttons[num].setText(temp);
        }
    }

    static void BaseLanguageWordsColoring(){
        for (int i = 0; i < _buttons.length; i++) {
            for (int j = 0; j < _baseLanguageWords.length; j++) {
                if (_buttons[i].getText().equals(_baseLanguageWords[j]))
                    _buttons[i].setBackground(Color.CYAN);
            }
        }
    }

    static void BackToWhiteColor(){
        for (int i = 0; i < _buttons.length; i++) {
            _buttons[i].setBackground(Color.WHITE);
        }
    }


    static void ActionButton(){
        for (int i = 0; i < _buttons.length; i++) {

            int finalI = i;
            _buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(_isGaming) {
                        AudioClass.AudioClassCreateClick("click.wav");

                        if (!_isFirst) {
                            _isFirst = !_isFirst;
                            _buttonPressedNumber = finalI;
                            _buttons[finalI].setBackground(Color.YELLOW);
                        } else if (_isFirst && _buttonPressedNumber != finalI ) {
                            String temp1, temp2;
                            temp1 = _buttons[finalI].getText() + " " + _buttons[_buttonPressedNumber].getText();
                            temp2 = _buttons[_buttonPressedNumber].getText() + " " + _buttons[finalI].getText();
                            boolean ifWas=false;
                            for (int j = 0; j < _pairs.length; j++) {
                                if (_pairs[j].equals(temp2) || _pairs[j].equals(temp1)) {
                                    _buttons[finalI].setBackground(Color.GREEN);
                                    _buttons[_buttonPressedNumber].setBackground(Color.GREEN);
                                    _buttons[finalI].setEnabled(false);
                                    _buttons[_buttonPressedNumber].setEnabled(false);
                                    _buttons[finalI].setText("");
                                    _buttons[_buttonPressedNumber].setText("");
                                    ifWas=true;

                                    //AudioClass.AudioClassCreateClick("done.wav");

                                    _scoreLabel.setText("Очки: "+(++_score));
                                    CheckIfWin();
                                    break;
                                }
                            }
                            if(!ifWas){
                                _buttons[_buttonPressedNumber].setBackground(Color.RED);
                                _buttons[finalI].setBackground(Color.RED);
                                _buttonNumberBackToWhite=finalI;
                                _isGaming=false;
                                timer2[0] = new Timer(1000, backToDefaultColor);
                                timer2[0].start();

                                //AudioClass.AudioClassCreateClick("incorrect.wav");
                                _errorLabel.setText("Ошибки: "+ (++_error));
                            }
                            _isFirst = !_isFirst;
                        } else {
                            _buttons[finalI].setBackground(Color.WHITE);
                            _isFirst = !_isFirst;
                        }

                    }
                }
            });

        }
    }

}
