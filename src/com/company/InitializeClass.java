package com.company;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import static com.company.Main.*;

class InitializeClass {

    static void InitializeButtons(){
        for (int i = 0; i < _buttons.length; i++) {
            _buttons[i]=new JButton("");
            _buttons[i].setFocusPainted(false);
            _buttons[i].setFont(font);
            //_buttons[i].setSize(_buttons[i].getPreferredSize());
            //_buttons[i].setHorizontalTextPosition(JButton.LEFT);
            //
            //_buttons[i].setBounds(_buttons[i].getX(),_buttons[i].getY(),_buttons[i].getWidth(),_buttons[i].getHeight());
            _buttons[i].setBackground(Color.GREEN);
            _buttons[i].setEnabled(false);
            _buttons[i].setPreferredSize(new Dimension(_sizeSquare_x,_sizeSquare_y));
            panelButton.add(_buttons[i]);
            }
    }

    static JButton JButton(JButton button,String text,int size_x,int size_y){
        button = new JButton(text);
        button.setPreferredSize(new Dimension(size_x,size_y));
        button.setBackground(Color.WHITE);
        return button;
    }

    static JLabel JLabel(JLabel label, String text, int alignment, int size_x, int size_y ){
        label = new JLabel(text);
        label.setHorizontalAlignment(alignment);
        label.setPreferredSize(new Dimension(size_x,size_y));
        return label;
    }
    static void DeleteData(){
        _iterator =0;
        _countPairs=0;

        _isFirst =false;
        _isGaming=false;
        _startWithRandomisize=false;_isWon =false;
        _isRestatr=false;
        _score=0;
        _error=0;
        timerGame = new int[]{0, 0, 0};

        timer[0].stop();
        //timer2[0].stop();
        timer3[0].stop();

    }
}
