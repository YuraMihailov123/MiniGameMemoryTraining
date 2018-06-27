package com.company;
import java.net.URL;
import  java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main extends JFrame{

    private JLabel _emptyLabel;
    private JButton[] _buttons=new JButton[64];
    private JButton _gameButton,_alphabetButton,_startButton;
    private JLayeredPane lpane;
    private Main(){
        super("Memory training"); //Заголовок окна
        setResizable(false);
        setBounds(400, 0, 800, 860);

        /*String path = "icon.jpg";
        URL imgUrl = Main.class.getResource(path);
        //icon = Toolkit.getDefaultToolkit().getImage("com.company/icon.jpg");
        ImageIcon icon = new ImageIcon(imgUrl);
        */
        lpane=new JLayeredPane();

        Container _container = getContentPane();
        _container.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

        /*_startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                _startButton.setBackground(Color.RED);
            }
        });*/

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

        for (int i = 0; i < 64; i++) {
            //char a = i
            _buttons[i]=new JButton("");
            _buttons[i].setBackground(Color.GREEN);
            _buttons[i].setPreferredSize(new Dimension(100,100));
            _container.add(_buttons[i]);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        Main app = new Main(); //Создаем экземпляр нашего приложения
        app.setVisible(true);

    }

}
