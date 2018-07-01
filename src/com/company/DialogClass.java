package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static com.company.ActionListenersClass.importWordsIntoGame;
import static com.company.Main.*;

class DialogClass extends JDialog {
    public DialogClass(JFrame owner){
        super(owner,"Настройки игры",true);
        setBounds(700,200,260,220);
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
        _numX.setPreferredSize(new Dimension(25,20));
        _numY.setPreferredSize(new Dimension(25,20));
        _numSquareX.setPreferredSize(new Dimension(25,20));
        _numSquareY.setPreferredSize(new Dimension(25,20));
        //add(new JLabel("Количество ячеек:"),BorderLayout.CENTER);
        JButton _loadLevel = new JButton("Загрузить уровень");
        _label.setForeground(Color.RED);
        _label2.setForeground(Color.RED);
        _label3.setForeground(Color.RED);

        _loadLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!_numSquareX.getText().equals("")) {
                    _sizeSquare_x = Integer.parseInt(_numSquareX.getText());
                }
                if(!_numSquareY.getText().equals("")) {
                    _sizeSquare_y = Integer.parseInt(_numSquareY.getText());
                }

                if(_checkBox.isSelected()) {
                    _startWithRandomisize=true;
                }

                if(!_numY.getText().equals("")) {
                    _size_y = Integer.parseInt(_numY.getText());
                }
                if(!_numX.getText().equals("")) {
                    _size_x = Integer.parseInt(_numX.getText());
                }

                if((_size_x*_size_y)%2==0 && _size_x*_size_y!=0 && _sizeSquare_x*_sizeSquare_y!=0) {
                    try {
                        rf = new FileReader("src/com/company/Data/file.txt");
                        scan = new Scanner(rf);
                        AudioClass.AudioClassCreateClick("click.wav");
                    } catch (FileNotFoundException e1) {
                        System.out.println("File not found!");
                    }

                    timer[0] = new Timer(100, importWordsIntoGame);
                    timer[0].start();

                    setVisible(false);
                }


            }
        });


        panel2.add(new JLabel("Количество ячеек:"),BorderLayout.CENTER);
        panel2.add(_numX);
        panel2.add(new JLabel("x"),BorderLayout.CENTER);
        panel2.add(_numY);
        panel2.add(new JLabel("Размер ячеек:"),BorderLayout.CENTER);
        panel2.add(_numSquareX);
        panel2.add(new JLabel("x"),BorderLayout.CENTER);
        panel2.add(_numSquareY);
        panel2.add(new JLabel("Перемешать сразу"),BorderLayout.CENTER);
        panel2.add(_checkBox);
        panel2.add(_label,BorderLayout.CENTER);
        panel2.add(_label2,BorderLayout.CENTER);
        panel2.add(_label3,BorderLayout.CENTER);
        panel.add(_loadLevel);
        //panel.add(_numX);
        add(panel2,BorderLayout.CENTER);
        add(panel,BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setUndecorated(false);
        //setSize(260,160);
    }
}
