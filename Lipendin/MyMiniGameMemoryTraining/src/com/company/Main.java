package com.company;
import java.awt.*;
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
    static String[] _baseLanguageWords = new String[32];
    static int _buttonPressedNumber, _iterator, _countPairs, _buttonNumberBackToWhite;
    static boolean _isFirst, _isGaming;
    static JLabel _timeLabel;
    static JLabel _emptyLabel;
    static JLabel _scoreLabel;
    static JLabel _errorLabel;
    static JButton[] _buttons=new JButton[64];
    private static JButton _gameButton, _saveErrorButton;
    static int _score, _error;
    static FileReader infile;
    static FileWriter outfile1;
    static FileWriter outfile2;
    static Scanner scan;
    static Container _container;
    static int[] timerGame = {0, 0, 0};
    static final Timer[] timer = new Timer[1];
    static final Timer[] timer3 = new Timer[1];
    static final Timer[] timer2= new Timer[1];
    private Main(){
        super("Memory training"); //Заголовок окна
        setResizable(false);
        setBounds(400, 0, 807, 860);

        ImageIcon icon = new ImageIcon("src/com/company/iconGame.png");
        setIconImage(icon.getImage());

        _container = getContentPane();
        _container.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

        _emptyLabel = JLabel(_emptyLabel,"DMG Group. 2018. recon.97@mail.ru -beta 0.1v.",4,300,30);
        _scoreLabel = JLabel(_scoreLabel,"Очки: "+_score,0,100,30);
        _errorLabel = JLabel(_errorLabel,"Ошибки: "+_error,0,100,30);
        _timeLabel = JLabel(_timeLabel,"Время: ",0,100,30);

        _gameButton = JButton(_gameButton,"Игра",100,30);
        _saveErrorButton = JButton(_saveErrorButton,"Сохранить ошибку",100,30);

        _gameButton.addActionListener(startGame);
        _saveErrorButton.addActionListener(addPairsToErrorLists);

        _container.add(_gameButton);
        _container.add(_saveErrorButton);
        _container.add(_scoreLabel);
        _container.add(_errorLabel);
        _container.add(_timeLabel);
        _container.add(_emptyLabel);

        InitializeOutfile(outfile1, "error_list1.txt");
        InitializeOutfile(outfile2, "error_list2.txt");
        InitializeButtons();
        ActionButton();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {

        Main app = new Main(); //Создаем экземпляр нашего приложения
        app.setVisible(true);

    }

}
