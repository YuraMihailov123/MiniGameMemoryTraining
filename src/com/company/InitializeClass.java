package com.company;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

import static com.company.InitializeClass.*;

import static com.company.Main.*;
import static com.company.Parser.GetParametres;

class DrawButton extends JButton {
    static int i=0;

    //Font font_2 = new Font("Verdana",Font.PLAIN,25);
    DrawButton(String text){
        setText(text);

    }

    public void setG2D(Graphics g){
        Graphics2D _g=(Graphics2D)g;
        g2=_g;
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        g2=(Graphics2D)g;
        g2.setColor(Color.BLACK);
        //g2.setFont(font_2);
        if(test) {
        //write_2+=write_;
            String c;// = this.getText();
            c=GetParametres(this.getText());
            Font font_2 = new Font("Verdana",Font.PLAIN,height);
            g2.setFont(font_2);
            g2.setColor(colorToColor);
            //this.setText(c);
            g2.drawString(c, _sizeSquare_x / 2 - 33,_sizeSquare_y / 2+8);
            height=_sizeSquare_y;
            colorToColor=Color.black;
            //test=false;
            i++;
            //test=false;
        }
        //if(fuckingDucking) {
        //    g2.drawString(this.getText(), _sizeSquare_x / 2 - 30, _sizeSquare_y / 2);
        //}

    }
}

class InitializeClass {
    static Font font_ = new Font("Verdana",Font.PLAIN,1);
    //////////////////////////////
    static String str_2="";
    static Color colorToColor;
    static int width=_sizeSquare_x,height=_sizeSquare_y;
    ////////////////


    static void InitializeButtons(){
        //Parser.ParseString();

        String[] str={"0","1","2","3"};
        for (int i = 0; i < _buttons.length; i++) {
            //Graphics2D g_2;

            //g_2.drawString("Hello",22,22);
            int finalI = i;
            _buttons[i]=new DrawButton("");
            _buttons[i].setFocusPainted(false);
            _buttons[i].setFont(font_);
            _buttons[i].setBackground(Color.GREEN);
            _buttons[i].setEnabled(false);
            _buttons[i].setPreferredSize(new Dimension(_sizeSquare_x,_sizeSquare_y));
            //_buttons[i].add(drawPanel);
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
