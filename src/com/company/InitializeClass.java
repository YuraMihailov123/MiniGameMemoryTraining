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
        _sizeSquare_x=0;
        _sizeSquare_y=0;
        _size_x=0;
        _size_y=0;
        _iterator =0;
        _countPairs=0;
        _canWeShuffle=true;
        _isFirst =false;
        _ifWas=false;
        _isGaming=false;
        _startWithRandomisize=false;_isWon =false;
        _isRestatr=false;
        _isSoundEnable=true;
        _soundButton.setIcon(iconSoundOn);
        _score=0;
        _error=0;
        timerGame = new int[]{0, 0, 0};
        _error_1.clear();
        _error_2.clear();
        timer[0].stop();
        //timer2[0].stop();
        timer3[0].stop();

    }
}
class CustomJToolTip extends JToolTip{
    public CustomJToolTip(JComponent c){
        super();
        setComponent(c);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
    }
}

class MyBytton extends JButton{
    public MyBytton(String text){
        super(text);
    }
     @Override
        public JToolTip createToolTip(){
            return(new CustomJToolTip(this));
        }

}
