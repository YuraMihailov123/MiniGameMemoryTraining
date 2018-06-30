package com.company;
import javax.swing.*;
import java.awt.*;
import static com.company.Main.*;

class InitializeClass {

    static void InitializeButtons(){
        for (int i = 0; i < 64; i++) {
            _buttons[i]=new JButton("");
            _buttons[i].setFocusPainted(false);
            _buttons[i].setBackground(Color.GREEN);
            _buttons[i].setEnabled(false);
            _buttons[i].setPreferredSize(new Dimension(100,100));
            _container.add(_buttons[i]);
        }
    }

    static JButton JButton(JButton button,String text,int size_x,int size_y){
        button = new JButton(text);
        button.setFocusPainted(false);
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
}
