package com.company;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import static com.company.ActionListenersClass.*;
import static com.company.InitializeClass.*;


public class Main extends JFrame{
    /*
    -mute for sound+++
    -путь до файла+++
    -сохранить ошибки кнопкой после завершения урока+++
    -загрузка со списков ошибок после завершения+++
    -шрифт++(+-)
    -перемешевание всех пар+++
    -отмена действия с глубиной 1+++
    -добавление иконок +++
    -добавление всплывающего описания для иконок-кнопок+++
    -справка по игре+++
    -считывание с файла в формате utf-8+++
    */
    static Main app;
    static Color pale_blue = new Color(174,204,235);
    static java.util.List<String> strs = new ArrayList<String>();
    static java.util.List<String> _baseLanguageWords = new ArrayList<>();
    static java.util.List<String> _baseLanguageWordsNative = new ArrayList<>();
    static java.util.List<String> _error_1 = new ArrayList<>();
    static java.util.List<String> _error_2 = new ArrayList<>();
    static String[] _twoWords=new String[2];
    static JFrame _mainFrame;
    static int _buttonPressedNumber, _iterator =0,_countPairs=0, _buttonNumberBackToWhite;
    static boolean _isFirst =false,_isGaming=false,_startWithRandomisize=false, _isWon =false,_isRestatr=false,_isEnabledUndo=false,_isSoundEnable=true;
    static boolean _ifWas=false;
    static boolean _canWeShuffle=true;
    static JLabel _timeLabel;
    static JLabel _emptyLabel;
    static JLabel _scoreLabel;
    static JLabel _errorLabel;
    static int _size_x,_size_y,_sizeSquare_x,_sizeSquare_y;
    static JButton[] _buttons;
    static JButton _gameButton, _saveErrors,_undoButton,_soundButton;
    static int _score=0,_error=0;
    static InputStreamReader rf;
    static FileWriter outfile1;
    static FileWriter outfile2;
    static Scanner scan;
    static Container _container;
    static JPanel panelButton;
    static int[] timerGame = {0,0,0};
    static final Timer[] timer = new Timer[1];
    static final Timer[] timer2= new Timer[1];
    static final Timer[] timer3 = new Timer[1];
    static Font font2,font;
    static ImageIcon iconSoundOn;
    static ImageIcon iconSoundOff;



    public Main(){
        super("Программа для запоминания слов"); //Заголовок окна
        setResizable(false);
        _mainFrame=this;
        ImageIcon iconShuffle = new ImageIcon("src/com/company/Icons/shuffle.png");/////создание иконок для кнопок
        ImageIcon iconUndo = new ImageIcon("src/com/company/Icons/undo.png");
        ImageIcon iconSave = new ImageIcon("src/com/company/Icons/save1.png");
        ImageIcon iconCheck = new ImageIcon("src/com/company/Icons/check.png");
        ImageIcon iconError = new ImageIcon("src/com/company/Icons/error.png");
        ImageIcon icon = new ImageIcon("src/com/company/Icons/iconGame.png");
        iconSoundOn = new ImageIcon("src/com/company/Icons/on2.png");
        iconSoundOff = new ImageIcon("src/com/company/Icons/off.png");

        setIconImage(icon.getImage());/////установление иконки приложения

        JPanel panelInfo = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0)); /////создание панели для хранения кнопок
        JPanel panelEmail = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));///// создание панели для хранения метки с авторской информацией



        MainButtons(iconShuffle, iconUndo, iconSave,iconSoundOn,iconSoundOff, panelInfo); /////вызов функции инициализации кнопок
        _undoButton.setEnabled(_isEnabledUndo);/////делаем кнопку неактивной

        DialogClass dialogClass = new DialogClass(this, _isWon,"Настройки игры");/////создание окна с настройками игры
        dialogClass.setVisible(true);/////делаем окно с настройками активным
        if (_size_x * _sizeSquare_x > 330) {/////фиксация размеров экрана
            setBounds(0, 0, _size_x*_sizeSquare_x,_size_y*_sizeSquare_y+90 );
        }
        else setBounds(0, 0, 330, _size_y*_sizeSquare_y+90);

        _container = getContentPane();/////создание контейнера для компонентов
        _container.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));/////установление последовательного слоя расположения компонентов

        _emptyLabel = JLabel(_emptyLabel,"DMG Group.2018 recon.97@mail.ru 0.2v.",4,250,30);/////создание метки с авторской информацией
        _scoreLabel = JLabel(_scoreLabel,": "+_score,0,70,30);/////создание метки очков
        _errorLabel = JLabel(_errorLabel,": "+_error,0,70,30);/////создание метки ошибок
        _timeLabel = JLabel(_timeLabel,"Время: ",0,100,30);/////создание метки времени

        _scoreLabel.setIcon(iconCheck);/////установка иконки для метки очков
        _errorLabel.setIcon(iconError);/////установка иконки для метки ошибок

        if(_startWithRandomisize)_gameButton.setEnabled(false);/////проверка для старта с перемешкой или же без нее

        panelInfo.add(_scoreLabel);/////добавление на панель метки очков
        panelInfo.add(_errorLabel);/////добавление на панель метки ошибок
        panelInfo.add(_timeLabel);/////добавление на панель метки времени
        panelEmail.add(_emptyLabel);/////добавление на панель метки с авторской информацией
        panelEmail.add(_soundButton);/////добавление на панель кнопки управления звуком
        _container.add(panelInfo);/////добавление компоненто контейнера
        _container.add(panelButton);
        _container.add(panelEmail);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void MainButtons(ImageIcon iconShuffle, ImageIcon iconUndo, ImageIcon iconSave, ImageIcon iconSoundOn,ImageIcon iconSoundOff ,JPanel panelInfo) {/////функция инициализации главных кнопок
        _gameButton = new MyBytton("");/////кнопка перемешивания
        _gameButton.setBackground(Color.WHITE);
        _gameButton.setPreferredSize(new Dimension(30,30));
        //_gameButton.setFont(font);
        _gameButton.setIcon(iconShuffle);
        _gameButton.setToolTipText("Перемешать ячейки");
        _gameButton.setFocusPainted(false);
        _gameButton.addActionListener(delayBeforeLoad);
        panelInfo.add(_gameButton);

        _soundButton = new MyBytton("");/////кнопка управления звуком
        _soundButton.setBackground(Color.WHITE);
        _soundButton.setPreferredSize(new Dimension(30,30));
        //_soundButton.setFont(font);
        _soundButton.setIcon(iconSoundOn);
        _soundButton.setToolTipText("Вкл/Выкл звук");
        _soundButton.setFocusPainted(false);
        _soundButton.addActionListener(soundMute);

        _saveErrors = new MyBytton("");/////кнопка сохранения ошибок
        _saveErrors.setBackground(Color.WHITE);
        _saveErrors.setPreferredSize(new Dimension(30,30));
        //_saveErrors.setFont(font);
        _saveErrors.setIcon(iconSave);
        _saveErrors.setToolTipText("Сохранить ошибки");
        _saveErrors.setFocusPainted(false);
        _saveErrors.addActionListener(addPairsToErrorLists);
        panelInfo.add(_saveErrors);

        _undoButton = new MyBytton("");/////кнопка отмены последнего действия
        _undoButton.setBackground(Color.WHITE);
        _undoButton.setPreferredSize(new Dimension(30,30));
        //_undoButton.setFont(font);
        _undoButton.setIcon(iconUndo);
        _undoButton.setToolTipText("Отменить последнее действие");
        _undoButton.setFocusPainted(false);
        _undoButton.addActionListener(undoAction);
        panelInfo.add(_undoButton);
    }

    public static void main(String[] args) {

        app = new Main();/////создание окна
        app.setVisible(true);

    }

}

