package com.company;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

import static com.company.InitializeClass.*;

import static com.company.Main.*;
import static com.company.Parser.*;
//import static com.company.Parser.GetSubstrSize;

class DrawButton extends JButton {
    static int i=0;

    //Font font_2 = new Font("Verdana",Font.PLAIN,25);
    DrawButton(String text){
        setText(text);

    }
    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        g2=(Graphics2D)g;
        g2.setColor(Color.BLACK);
        String write="";
        String prev="";
        butText=this.getText();
        String text=this.getText();
        text=DelParametres(text);
        colorToColor = Color.black;
        boolean fir=true;
        height = _sizeSquare_y;
        //boolean changeLocation=false;
        coordX=0;
        cord_y = 0;//g2.getFontMetrics().getHeight();
        heightTooffset=_sizeSquare_y-1;
        if(test) {
            while (!write.equals(text)) {

                String c;
                c = GetParametres(butText);


                //GetSubstrSize(butText);
                /*if(!ifTwoSlashes) {
                    cord_y += heightTooffset;
                    ifTwoSlashes=true;
                }*/
                if(fir){
                    if(CheckSlashes(this.getText())){
                        cord_y=GetSizeFont(this.getText());
                    }
                    fir=false;
                }

                if(!CheckSlashes(this.getText())){
                    cord_y=0;
                    cord_y=GetSizeFont(this.getText());
                }

                if(!changeLocation) {
                    coordX=0;
                    changeLocation=true;

                }
                else {

                    coordX += g2.getFontMetrics().stringWidth(prev);
                }

                StringBuffer buff = new StringBuffer(butText);
                buff.delete(0, i_gr+1);
                butText = buff.toString();
                write+=c;
                Font font_2 = new Font("MS Gothic", Font.PLAIN, height);
                g2.setFont(font_2);
                //System.out.println(heightTooffset);
                //System.out.println(cord_y);
                //System.out.println(prev+"-"+g2.getFontMetrics().stringWidth(prev));
                g2.setColor(colorToColor);
                g2.drawString(c,  coordX, cord_y);
                //heightTooffset=0;
                //cord_y = g2.getFontMetrics().getHeight();
                prev=c;
            }

        }
        /*if(test) {

            String c;
            c=GetParametres(this.getText());
            Font font_2 = new Font("Verdana",Font.PLAIN,height);
            g2.setFont(font_2);
            g2.setColor(colorToColor);
            g2.drawString(c, (_sizeSquare_y-height)/3,_sizeSquare_y-(_sizeSquare_y-height)/2);
            height=_sizeSquare_y;
            colorToColor=Color.black;

        }*/


    }
}

class InitializeClass {
    static Font font_ = new Font("Verdana",Font.PLAIN,1);
    //////////////////////////////
    static String str_2="";
    static Color colorToColor;
    static int width=_sizeSquare_x,height=_sizeSquare_y-1;
    ////////////////


    static void InitializeButtons(){
        //Parser.ParseString();

        String[] str={"0","1","2","3"};
        for (int i = 0; i < _buttons.length; i++) {
            //Graphics2D g_2;

            //g_2.drawString("Hello",22,22);
            int finalI = i;
            _buttons[i]=new DrawButton("");
            _labels[i]=new JLabel();
            _buttons[i].setFocusPainted(false);
            _buttons[i].setFont(font_);
            _buttons[i].setLayout(new GridLayout(2,1));
            _labels[i].setForeground(Color.MAGENTA);
            _buttons[i].add(_labels[i]);

            _buttons[i].setBackground(Color.GREEN);
            _buttons[i].setEnabled(false);
            _buttons[i].setPreferredSize(new Dimension(_sizeSquare_x,_sizeSquare_y));
            //_buttons[i].add(drawPanel);
            panelButton.add(_buttons[i]);
            }
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
        //_iterator =0;
        _countPairs=0;
        _canWeShuffle=true;
        _isFirst =false;
        _ifWas=false;
        _isGaming=false;
        _startWithRandomisize=false;_isWon =false;
        _isRestatr=false;
        _isSoundEnable=true;
        //_soundButton.setIcon(iconSoundOn);
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
