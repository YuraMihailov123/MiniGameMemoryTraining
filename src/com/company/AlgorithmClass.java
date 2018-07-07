package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

import static com.company.ActionListenersClass.backToDefaultColor;
import static com.company.ActionListenersClass.importWordsIntoGame;
import static com.company.Main.*;

class AlgorithmClass {

    static void IfAllPairsLoaded(){
        boolean toClose=true;
        for (int i = 0; i <_buttons.length ; i++) {
            if(_buttons[i].getBackground()!=Color.GREEN) {
                toClose=false;
            }
        }
        if(toClose){
            timer3[0].stop();
            DialogClass winDialog = new DialogClass(_mainFrame,!_isWon,"Результат");
            winDialog.setVisible(true);
            strs.clear();
        }
    }

    static void UndoVoid(int index, String str){
        boolean _isForeign=true;
        for (int i = 0; i < _baseLanguageWords.size(); i++) {
            if (str.equals(_baseLanguageWords.get(i))) {
                _buttons[index].setBackground(pale_blue);
                _isForeign=false;
            }
        }
        if(_isForeign)_buttons[index].setBackground(Color.WHITE);
    }

    static void CheckIfButtonEmpty(){
        for (int i = 0; i < _buttons.length; i++) {
            if(_buttons[i].getText().equals("")){
                _buttons[i].setBackground(Color.GREEN);
                _buttons[i].setEnabled(false);

            }
        }
    }

    static void CheckIfWin(){
        int count=0;
        for (int i = 0; i < _buttons.length; i++) {
            if(!_buttons[i].isEnabled()) count++;
        }
        if(count==_buttons.length) {
            _isWon=!_isWon;
            BackToWhiteColor();
            System.out.println("You win!");

            //if(_isRestatr) {
                timer[0] = new Timer(100, importWordsIntoGame);
                timer[0].start();
                _undoButton.setEnabled(false);
                _isEnabledUndo=false;
            //}


        }
    }

    static boolean GetPairsAndDivideThem() {
        if(_isWon) {
            //_countPairs = 0;
            _isWon=!_isWon;
        }

        String str="";
        if(scan.hasNextLine()) {
            str = scan.nextLine();
            //_pairs[_countPairs] = str;
            strs.add(str);
        }
        boolean ret = scan.hasNextLine();
        return ret;

    }

    static void SetButtonsPairsText(){
        String temp1,temp2,str;
        //_countPairs=0;
        //int _indexList=_countPairs;
        for (int i = 0; i < _buttons.length/2; i++) {

            if(_countPairs!=strs.size()) {
                str = strs.get(_countPairs);
                temp1 = "";
                temp2 = "";
                int _temp = GetSpaceInString(str);
                temp1 = str.substring(0, _temp);
                _baseLanguageWords.add(temp1);
                _buttons[i].setText(temp1);
                temp2 = str.substring(_temp + 1);
                _baseLanguageWordsNative.add(temp2);
                _buttons[i + _buttons.length / 2].setText(temp2);
                _buttons[i].setBackground(Color.WHITE);
                _buttons[i + _buttons.length / 2].setBackground(Color.WHITE);

                //AudioClass.AudioClassCreateClick("clickApper.wav");

                _countPairs++;
            }
        }

    }

    static void ShuffleList(){
        for (int i = 0; i < strs.size(); i++) {
            String temp;
            String temp2;
            Random random = new Random();
            int num = random.nextInt(strs.size());
            while(i==num) {
                num = random.nextInt(strs.size());
            }
            temp = strs.get(i);
            temp2 = strs.get(num);
            strs.remove(i);
            strs.add(i,temp2);
            strs.remove(num);
            strs.add(num,temp);
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
            //System.out.println(num);
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
            for (int j = 0; j < _baseLanguageWords.size(); j++) {
                if (_buttons[i].getText().equals(_baseLanguageWords.get(j)))
                    _buttons[i].setBackground(pale_blue);

            }
        }
    }

    static void BaseLanguageWordsNativeColoring(){
        for (int i = 0; i < _buttons.length; i++) {
            for (int j = 0; j < _baseLanguageWordsNative.size(); j++) {
                if (_buttons[i].getText().equals(_baseLanguageWordsNative.get(j)))
                    _buttons[i].setBackground(Color.WHITE);

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
                            _isEnabledUndo=false;
                            _undoButton.setEnabled(_isEnabledUndo);
                            _isFirst = !_isFirst;
                            _buttonPressedNumber = finalI;

                            if (_buttons[finalI].getBackground() == pale_blue){
                                for (int j = 0; j < _buttons.length; j++){
                                    if (_buttons[j].getBackground() == pale_blue)
                                        _buttons[j].setEnabled(false);
                                }
                            }
                            else if (_buttons[finalI].getBackground() == Color.WHITE) {
                                for (int j = 0; j < _buttons.length; j++) {
                                    if (_buttons[j].getBackground() == Color.WHITE)
                                        _buttons[j].setEnabled(false);
                                }
                            }
                            _buttons[finalI].setBackground(Color.YELLOW);
                            _buttons[_buttonPressedNumber].setEnabled(true);
                        } else if (_isFirst && _buttonPressedNumber != finalI ) {
                            _isEnabledUndo=true;
                            _undoButton.setEnabled(_isEnabledUndo);
                            String temp1, temp2;
                            temp1 = _buttons[finalI].getText() + " " + _buttons[_buttonPressedNumber].getText();
                            temp2 = _buttons[_buttonPressedNumber].getText() + " " + _buttons[finalI].getText();
                            _ifWas=false;
                            for (int j = 0; j < strs.size(); j++) {
                                if (strs.get(j).equals(temp2) || strs.get(j).equals(temp1)) {
                                    _buttons[finalI].setBackground(Color.GREEN);
                                    _buttons[_buttonPressedNumber].setBackground(Color.GREEN);
                                    for (int i = 0; i < _buttons.length; i++) {
                                        if(_buttons[i].getBackground()!=Color.GREEN)
                                        _buttons[i].setEnabled(true);
                                    }
                                    _twoWords[0]=_buttons[finalI].getText();
                                    _twoWords[1]=_buttons[_buttonPressedNumber].getText();
                                    _buttons[finalI].setEnabled(false);
                                    _buttons[_buttonPressedNumber].setEnabled(false);
                                    _buttonNumberBackToWhite=finalI;
                                    _buttons[finalI].setText("");
                                    _buttons[_buttonPressedNumber].setText("");
                                    _ifWas=true;

                                    //AudioClass.AudioClassCreateClick("done.wav");

                                    _scoreLabel.setText(": "+(++_score));
                                    CheckIfWin();
                                    break;
                                }
                            }
                            if(!_ifWas){
                                _buttons[_buttonPressedNumber].setBackground(Color.RED);
                                _buttons[finalI].setBackground(Color.RED);
                                for (int i = 0; i < _buttons.length; i++){
                                    if(_buttons[i].getBackground()!=Color.GREEN)
                                        _buttons[i].setEnabled(true);
                                }
                                _buttonNumberBackToWhite=finalI;
                                _isGaming=false;
                                timer2[0] = new Timer(1000, backToDefaultColor);
                                timer2[0].start();

                                //AudioClass.AudioClassCreateClick("incorrect.wav");
                                _errorLabel.setText(": "+ (++_error));
                            }
                            _isFirst = !_isFirst;
                        } else if(_buttonPressedNumber==finalI){
                            //_isEnabledUndo=true;
                            //_undoButton.setEnabled(_isEnabledUndo);
                            boolean _isForeign=true;
                            for (int i = 0; i < _baseLanguageWords.size(); i++) {
                                if (_buttons[finalI].getText().equals(_baseLanguageWords.get(i))) {
                                    _buttons[finalI].setBackground(pale_blue);
                                    _isForeign=false;
                                }
                            }
                            if(_isForeign)_buttons[finalI].setBackground(Color.WHITE);

                            for (int i = 0; i < _buttons.length; i++) {
                                if(_buttons[i].getBackground()!=Color.GREEN)
                                    _buttons[i].setEnabled(true);
                            }
                            _isFirst = !_isFirst;
                        }

                    }
                }
            });

        }
    }

}
