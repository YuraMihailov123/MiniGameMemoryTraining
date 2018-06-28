package com.company;
import  java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Main extends JFrame{

    //private String[][] _words;
    private String[] _pairs = new String[32];
    private int _buttonPressedNumber, _iterator =0,_countPairs=0;;
    boolean _isFirst =false,_isGaming=false;
    private JLabel _emptyLabel;
    private JButton[] _buttons=new JButton[64];
    private JButton _gameButton,_alphabetButton,_startButton;
    private  File file;
    private FileReader rf;
    private  Scanner scan;
    //private int finalI=0;
    //private JLayeredPane lpane;
    private Main(){
        super("Memory training"); //Заголовок окна
        setResizable(false);
        setBounds(400, 0, 800, 860);

        /*String path = "icon.jpg";
        URL imgUrl = Main.class.getResource(path);
        //icon = Toolkit.getDefaultToolkit().getImage("com.company/icon.jpg");
        ImageIcon icon = new ImageIcon(imgUrl);
        */
        //lpane=new JLayeredPane();

        Container _container = getContentPane();
        _container.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));


        _emptyLabel = new JLabel("DMG Group. 2018. recon.97@mail.ru -beta 0.1v.");
        _emptyLabel.setHorizontalAlignment(JLabel.RIGHT);
        _gameButton=new JButton("Игра");
        _alphabetButton=new JButton("Алфавит");
        _gameButton.setPreferredSize(new Dimension(100,30));
        _alphabetButton.setPreferredSize(new Dimension(100,30));
        _gameButton.setBackground(Color.WHITE);
        _alphabetButton.setBackground(Color.WHITE);
        _emptyLabel.setPreferredSize(new Dimension(600,30));
        _container.add(_gameButton);
        _container.add(_alphabetButton);
        _container.add(_emptyLabel);
/////////////////////////////////////////////////////////////////////
        final Timer[] timer = new Timer[1];
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //for (int _iterator = 0; _iterator <64 ; _iterator++) {
                if(_iterator <32) {
                    //_buttons[_iterator].setText("_iterator");
                    //GenerateLevel();
                    OpenFile();
                    _iterator++;
                }else {
                    timer[0].stop();
                    for (int i = 0; i < 64; i++) {
                        _buttons[i].setEnabled(true);
                    }
                    _isGaming=true;

                }
                //}
            }
        };

        _gameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try{
                    //OpenFile();
                    rf = new FileReader("src/com/company/file.txt");
                    scan = new Scanner(rf);
                }
                catch (FileNotFoundException e1) {
                    System.out.println("File not found!");
                }

                timer[0] = new Timer(100,listener);
                timer[0].start();
            }
        });
///////////////////////////////////////////////////////////////////////
        for (int i = 0; i < 64; i++) {
            //char a = _iterator
            _buttons[i]=new JButton("");
            _buttons[i].setBackground(Color.GREEN);
            _buttons[i].setEnabled(false);
            _buttons[i].setPreferredSize(new Dimension(100,100));
            _container.add(_buttons[i]);
        }
/////////////////////////////////////////////////////////

        final Timer[] timer2= new Timer[1];

        ActionListener listener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //_buttons[finalI].setBackground(Color.RED);
                _buttons[_buttonPressedNumber].setBackground(Color.RED);
                timer2[0].stop();
            }
        };


            for (int i = 0; i < 64; i++) {

                int finalI = i;
                _buttons[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(_isGaming) {
                            if (!_isFirst) {
                                _isFirst = !_isFirst;
                                _buttonPressedNumber = finalI;
                                _buttons[finalI].setBackground(Color.YELLOW);
                            } else if (_isFirst && _buttonPressedNumber != finalI) {
                                String temp1, temp2;
                                temp1 = _buttons[finalI].getText() + " " + _buttons[_buttonPressedNumber].getText();
                                temp2 = _buttons[_buttonPressedNumber].getText() + " " + _buttons[finalI].getText();
                                for (int j = 0; j < _pairs.length; j++) {
                                    //System.out.println(_pairs[j].equals(temp2));
                                    if (_pairs[j].equals(temp2) || _pairs[j].equals(temp1)) {
                                        _buttons[finalI].setBackground(Color.GREEN);
                                        _buttons[_buttonPressedNumber].setBackground(Color.GREEN);
                                        _buttons[finalI].setEnabled(false);
                                        _buttons[_buttonPressedNumber].setEnabled(false);
                                        _buttons[finalI].setText("");
                                        _buttons[_buttonPressedNumber].setText("");
                                        break;
                                    } else {
                                        timer2[0] = new Timer(1000, listener2);
                                        timer2[0].start();

                                    }
                                    System.out.println("break??");
                                }

                                _isFirst = !_isFirst;
                            } else if (_buttonPressedNumber == finalI) {
                                _buttons[finalI].setBackground(Color.WHITE);
                                _isFirst = !_isFirst;
                            }

                        }
                    }
                });

        }
        //GenerateLevel();
        //_buttons[0]=_buttons[32];

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*void GenerateLevel(){
        try{
            OpenFile();

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }*/

    public void OpenFile() {//} throws FileNotFoundException {

        String temp1,temp2;

        String str="";
        str = scan.nextLine();
        _pairs[_countPairs] = str;
        //here while
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

            //str = scan.nextLine();
            _countPairs++;

        }
        //rf.close();
    }

    int SubStringOnParts(String str){
        //String temp="";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==' '){
                return i;
                //System.out.println("fuck");
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        Main app = new Main(); //Создаем экземпляр нашего приложения
        app.setVisible(true);

    }

}
