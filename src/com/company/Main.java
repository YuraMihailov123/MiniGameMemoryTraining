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
    -начать с перемещ и без +++
    -сохранить список ошибок по кнопке(2 списка по раздельно)
    -задать количество ячеек по гориз и верт и их размеры +++
    -ключи
    */
    static String[] _pairs;
    static String[] _baseLanguageWords;
    //static String[] _baseLanguageWords2;
    static int _buttonPressedNumber, _iterator =0,_countPairs=0, _buttonNumberBackToWhite;
    static boolean _isFirst =false,_isGaming=false,_startWithRandomisize=false;
    static JLabel _timeLabel;
    static JLabel _emptyLabel;
    static JLabel _scoreLabel;
    static JLabel _errorLabel;
    static int _size_x,_size_y,_sizeSquare_x,_sizeSquare_y;
    static JButton[] _buttons;//=new JButton[_size_x*_size_y];
    private static JButton _gameButton, _saveErrors;
    static int _score=0,_error=0;
    public static File file;
    static FileReader rf;
    static Scanner scan;
    static Container _container;
    static JPanel panelButton;
    static int[] timerGame = {0,0,0};
    static final Timer[] timer = new Timer[1];
    static final Timer[] timer2= new Timer[1];
    static final Timer[] timer3 = new Timer[1];
    static final Timer[] timer4 = new Timer[1];
    private Main(){
        super("Memory training"); //Заголовок окна
        setResizable(false);
        setBounds(400, 0, 800, 860);
        Font font = new Font("Verdana", Font.PLAIN, 11);
        ImageIcon icon = new ImageIcon("src/com/company/iconGame.png");
        setIconImage(icon.getImage());
        DialogClass dialogClass = new DialogClass(this);
        dialogClass.setVisible(true);
        _buttons=new JButton[_size_x*_size_y];
        _pairs = new String[_size_x*_size_y/2];
        _baseLanguageWords = new String[_size_x*_size_y/2];
        //_baseLanguageWords2 = new String[_size_x*_size_y/2];
        _container = getContentPane();
        _container.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        panelButton=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
        panelButton.setPreferredSize(new Dimension(_size_x*_sizeSquare_x,_size_y*_sizeSquare_y));
        _emptyLabel = JLabel(_emptyLabel,"DMG Group.2018 recon.97@mail.ru 0.2v.",4,250,30);
        _scoreLabel = JLabel(_scoreLabel,"Очки: "+_score,0,100,30);
        _errorLabel = JLabel(_errorLabel,"Ошибки: "+_error,0,100,30);
        _timeLabel = JLabel(_timeLabel,"Время: ",0,100,30);

        _gameButton = JButton(_gameButton,"Перемешать",100,30);
        _gameButton.setFont(font);

        if(_startWithRandomisize)_gameButton.setEnabled(false);
        _saveErrors = JButton(_saveErrors,"Сохранить ошибки",150,30);
        _saveErrors.setFont(font);

        _gameButton.addActionListener(delayBeforeLoad);
        JPanel panelInfo = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));

        panelInfo.add(_gameButton);
        panelInfo.add(_saveErrors);
        panelInfo.add(_scoreLabel);
        panelInfo.add(_errorLabel);
        panelInfo.add(_timeLabel);
        panelInfo.add(_emptyLabel);

        _container.add(panelInfo);
        _container.add(panelButton);

        InitializeButtons();
        ActionButton();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {

        Main app = new Main();
        app.setVisible(true);

    }

}
