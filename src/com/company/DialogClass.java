package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static com.company.ActionListenersClass.importWordsIntoGame;
import static com.company.AlgorithmClass.ActionButton;
import static com.company.InitializeClass.*;
import static com.company.Main.*;

class DialogClass extends JDialog {
    public DialogClass(JFrame owner,boolean isWon,String str){
        super(owner,str,true);
        setBounds(700,200,260,220);
        if(!isWon) {
            //setResizable(false);
            JTextField _numX = new JTextField();
            JTextField _numY = new JTextField();
            JTextField _numSquareY = new JTextField();
            JTextField _numSquareX = new JTextField();
            JCheckBox _checkBox = new JCheckBox();
            JPanel panel = new JPanel();
            JPanel panel2 = new JPanel();
            JLabel _label = new JLabel("Требования настройки");
            JLabel _label2 = new JLabel("1.поля не могут быть пустыми!");
            JLabel _label3 = new JLabel("2.значения не могут быть равны 0!");
            _numX.setPreferredSize(new Dimension(25, 20));
            _numY.setPreferredSize(new Dimension(25, 20));
            _numSquareX.setPreferredSize(new Dimension(25, 20));
            _numSquareY.setPreferredSize(new Dimension(25, 20));
            //add(new JLabel("Количество ячеек:"),BorderLayout.CENTER);
            JButton _loadLevel = new JButton("Загрузить уровень");
            _label.setForeground(Color.RED);
            _label2.setForeground(Color.RED);
            _label3.setForeground(Color.RED);

            _loadLevel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    _sizeSquare_x=0;
                    _sizeSquare_y=0;
                    _size_x=0;
                    _size_y=0;
                    if (!_numSquareX.getText().equals("")) {
                        _sizeSquare_x = Integer.parseInt(_numSquareX.getText());
                    }
                    if (!_numSquareY.getText().equals("")) {
                        _sizeSquare_y = Integer.parseInt(_numSquareY.getText());
                    }

                    if (_checkBox.isSelected()) {
                        _startWithRandomisize = true;
                    }

                    if (!_numY.getText().equals("")) {
                        _size_y = Integer.parseInt(_numY.getText());
                    }
                    if (!_numX.getText().equals("")) {
                        _size_x = Integer.parseInt(_numX.getText());
                    }

                    if ((_size_x * _size_y) % 2 == 0 && _size_x * _size_y != 0 && _sizeSquare_x * _sizeSquare_y != 0) {
                        try {
                            rf = new FileReader("src/com/company/Data/file.txt");
                            scan = new Scanner(rf);
                            AudioClass.AudioClassCreateClick("click.wav");
                        } catch (FileNotFoundException e1) {
                            System.out.println("File not found!");
                        }
                        _buttons=new JButton[_size_x*_size_y];
                        _pairs = new String[_size_x*_size_y/2];
                        _baseLanguageWords = new String[_size_x*_size_y/2];
                        panelButton=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
                        panelButton.setPreferredSize(new Dimension(_size_x*_sizeSquare_x,_size_y*_sizeSquare_y));
                        InitializeButtons();
                        panelButton.revalidate();
                        panelButton.repaint();
                        ActionButton();
                        //timer[0].stop();

                        timer[0] = new Timer(100, importWordsIntoGame);
                        timer[0].start();

                        setVisible(false);
                    }


                }
            });


            panel2.add(new JLabel("Количество ячеек:"), BorderLayout.CENTER);
            panel2.add(_numX);
            panel2.add(new JLabel("x"), BorderLayout.CENTER);
            panel2.add(_numY);
            panel2.add(new JLabel("Размер ячеек:"), BorderLayout.CENTER);
            panel2.add(_numSquareX);
            panel2.add(new JLabel("x"), BorderLayout.CENTER);
            panel2.add(_numSquareY);
            panel2.add(new JLabel("Перемешать сразу"), BorderLayout.CENTER);
            panel2.add(_checkBox);
            panel2.add(_label, BorderLayout.CENTER);
            panel2.add(_label2, BorderLayout.CENTER);
            panel2.add(_label3, BorderLayout.CENTER);
            panel.add(_loadLevel);
            //panel.add(_numX);
            add(panel2, BorderLayout.CENTER);
            add(panel, BorderLayout.SOUTH);
        }else {
            JPanel panel = new JPanel();
            JPanel panel2 = new JPanel();
            JButton _restart = new JButton("Начать заново");
            _restart.setFocusPainted(false);
            panel.add(new JLabel("Урок завершен!"));
            panel2.add(_restart);
            add(panel,BorderLayout.CENTER);
            add(panel2,BorderLayout.SOUTH);
            ActionListener _newGame = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    app.dispose();
                    DeleteData();
                    //Main app2 = new Main();
                    //app2.setVisible(true);
                    app =new Main();
                    app.setVisible(true);
                    /*_isWon=!_isWon;
                    try {
                        rf = new FileReader("src/com/company/Data/file.txt");
                        scan = new Scanner(rf);
                        AudioClass.AudioClassCreateClick("click.wav");
                    } catch (FileNotFoundException e1) {
                        System.out.println("File not found!");
                    }
                    panelButton.removeAll();
                    //_iterator=0;
                    _isRestatr=true;
                    //revalidate();
                    //repaint();
                    DialogClass _newGameAction = new DialogClass(_mainFrame,!_isWon,"Настройка игры");
                    _newGameAction.setVisible(true);
                    setVisible(false);*/
                }
            };
            _restart.addActionListener(_newGame);


        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(false);
        //setSize(260,160);
    }
}
