package com.company;
import java.awt.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import static com.company.ActionListenersClass.*;
import static com.company.AlgorithmClass.*;
import static com.company.InitializeClass.*;

public class Main extends JFrame{
    /*
    -начать с перемещ и без
    -сохранить список ошибок по кнопке(2 списка по раздельно)
    -задать количество ячеек по гориз и верт и их размеры
    -ключи
    */
    static String[] _pairs = new String[32];
    static int _buttonPressedNumber, _iterator =0,_countPairs=0, _buttonNumberBackToWhite;
    static boolean _isFirst =false,_isGaming=false;
    static JLabel _timeLabel;
    static JLabel _emptyLabel;
    static JLabel _scoreLabel;
    static JLabel _errorLabel;
    static JButton[] _buttons=new JButton[64];
    private static JButton _gameButton,_alphabetButton;
    static int _score=0,_error=0;
    public static File file;
    static FileReader rf;
    static Scanner scan;
    static Container _container;
    static int[] timerGame = {0,0,0};
    static final Timer[] timer = new Timer[1];
    static final Timer[] timer3 = new Timer[1];
    static final Timer[] timer2= new Timer[1];
    private Main(){
        super("Memory training"); //Заголовок окна
        setResizable(false);
        setBounds(400, 0, 800, 860);

        ImageIcon icon = new ImageIcon("src/com/company/iconGame.png");
        setIconImage(icon.getImage());


        _container = getContentPane();
        _container.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

        _emptyLabel = JLabel(_emptyLabel,"DMG Group. 2018. recon.97@mail.ru -beta 0.1v.",4,300,30);
        _scoreLabel = JLabel(_scoreLabel,"Очки: "+_score,0,100,30);
        _errorLabel = JLabel(_errorLabel,"Ошибки: "+_error,0,100,30);
        _timeLabel = JLabel(_timeLabel,"Время: ",0,100,30);

        _gameButton = JButton(_gameButton,"Игра",100,30);
        _alphabetButton = JButton(_alphabetButton,"Алфавит",100,30);

        _container.add(_gameButton);
        _container.add(_alphabetButton);
        _container.add(_scoreLabel);
        _container.add(_errorLabel);
        _container.add(_timeLabel);
        _container.add(_emptyLabel);

        _gameButton.addActionListener(startGame);

        InitializeButtons();
        ActionButton();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        Main app = new Main(); //Создаем экземпляр нашего приложения
        app.setVisible(true);

    }

}
