package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import static com.company.ActionListenersClass.backToDefaultColor;
import static com.company.Main.*;

class AlgorithmClass {

    static void GetPairsAndDivideThem() {
        String temp1,temp2;
        String str;
        str = scan.nextLine();
        _pairs[_countPairs] = str;
        if(scan.hasNextLine() && _countPairs<32){
            int spaceIndex = GetSpaceInString(str);
            temp1 = str.substring(0, spaceIndex);
            _baseLanguageWords[_countPairs] = temp1;
            _buttons[_countPairs].setText(temp1);
            temp2 = str.substring(spaceIndex + 1);
            _buttons[_countPairs+32].setText(temp2);
            _buttons[_countPairs].setBackground(Color.WHITE);
            _buttons[_countPairs+32].setBackground(Color.WHITE);
            AudioClass.clip.stop();
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
    static void RandomizeButtonsLocation(){
        for (int i = 0; i < _buttons.length; i++) {
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
    static void BaseLanguageWordsColoring(){
        for (int i = 0; i < _buttons.length; i++) {
            for (int j = 0; j < _baseLanguageWords.length; j++) {
                if (_buttons[i].getText().equals(_baseLanguageWords[j]))
                    _buttons[i].setBackground(Color.CYAN);
            }
        }
    }
    static void InitializeOutfile(FileWriter outfile, String fileName) {
        try {
            outfile = new FileWriter("src/com/company/Data/" + fileName);
            outfile.write("");
        }
        catch(IOException e1) {
            e1.printStackTrace();
        }
    }

    static void ActionButton(){
        for (int i = 0; i < _buttons.length; i++) {

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
                                /*String[] errorPairs = new String[2];
                                errorPairs[0] = _buttons[_buttonPressedNumber].getText();
                                errorPairs[1] = _buttons[_buttonNumberBackToWhite].getText();*/
                                _buttons[_buttonPressedNumber].setBackground(Color.RED);
                                _buttons[finalI].setBackground(Color.RED);
                                _buttonNumberBackToWhite=finalI;
                                _isGaming=false;
                                timer2[0] = new Timer(1000, backToDefaultColor);
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
