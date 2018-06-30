package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static com.company.ActionListenersClass.listener2;
import static com.company.Main.*;

class AlgorithmClass {

    static void OpenFile() {
        String temp1,temp2;
        String str="";
        str = scan.nextLine();
        _pairs[_countPairs] = str;
        if(scan.hasNextLine() && _countPairs<32){
            temp1="";
            temp2="";
            int _temp = SubStringOnParts(str);
            temp1 = str.substring(0, _temp);
            _buttons[_countPairs].setText(temp1);
            temp2 = str.substring(_temp + 1);
            _buttons[_countPairs+32].setText(temp2);
            _buttons[_countPairs].setBackground(Color.WHITE);
            _buttons[_countPairs+32].setBackground(Color.WHITE);
            AudioClass.clip.stop();
            AudioClass.AudioClassCreateClick("clickApper.wav");

            _countPairs++;
        }

    }
    private static int SubStringOnParts(String str){
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==' '){
                return i;
            }
        }
        return 0;
    }
    static void RandomizeLocationButtons(){
        for (int i = 0; i < 64; i++) {
            Random random = new Random();
            int num = random.nextInt(64);
            System.out.println(num);
            while(i==num) {
                num = random.nextInt(64);
            }
            String temp = _buttons[i].getText();
            _buttons[i].setText(_buttons[num].getText());
            _buttons[num].setText(temp);
        }
    }

    static void ActionButton(){
        for (int i = 0; i < 64; i++) {

            int finalI = i;
            _buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(_isGaming) {
                        AudioClass.clip.stop();
                        AudioClass.AudioClassCreateClick("click.wav");

                        if (!_isFirst) {
                            _isFirst = !_isFirst;
                            _buttonPressedNumber = finalI;
                            _buttons[finalI].setBackground(Color.YELLOW);
                        } else if (_isFirst && _buttonPressedNumber != finalI) {
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
                                    AudioClass.clip.stop();
                                    AudioClass.AudioClassCreateClickAnswer("done.wav");
                                    _scoreLabel.setText("Очки: "+(++_score));
                                    break;
                                }
                            }
                            if(!ifWas){
                                _buttons[_buttonPressedNumber].setBackground(Color.RED);
                                _buttons[finalI].setBackground(Color.RED);
                                _buttonNumberBackToWhite=finalI;
                                _isGaming=false;
                                timer2[0] = new Timer(1000, listener2);
                                timer2[0].start();
                                AudioClass.clip.stop();
                                AudioClass.AudioClassCreateClickAnswer("incorrect.wav");
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
