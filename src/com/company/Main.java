package com.company;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import static com.company.ActionListenersClass.*;
import static com.company.InitializeClass.*;


public class Main extends JFrame{
    /*
    -mute for sound
    -загрузка с 2-х списков ошибок после завершения
    -путь до файла
    -ключи
    -справка по игре

    -сохранить ошибки кнопкой после завершения урока
    -[устранить дубликаты из списка ошибок!!-на финал-версию]
    */
    static Main app;
    static Color pale_blue = new Color(174,204,235);
    static String[] _pairs;
    static java.util.List<String> strs = new ArrayList<String>();
    static java.util.List<String> _baseLanguageWords = new ArrayList<>();
    static java.util.List<String> _baseLanguageWordsNative = new ArrayList<>();
    static String[] _twoWords=new String[2];
    static JFrame _mainFrame;
    //static String[] _baseLanguageWords;
    //static String[] _baseLanguageWords2;
    static int _buttonPressedNumber, _iterator =0,_countPairs=0, _buttonNumberBackToWhite;
    static boolean _isFirst =false,_isGaming=false,_startWithRandomisize=false, _isWon =false,_isRestatr=false,_isEnabledUndo=false;
    static boolean _ifWas=false;
    static boolean _canWeShuffle=true;
    static JLabel _timeLabel;
    static JLabel _emptyLabel;
    static JLabel _scoreLabel;
    static JLabel _errorLabel;
    static int _size_x,_size_y,_sizeSquare_x,_sizeSquare_y;
    static JButton[] _buttons;//=new JButton[_size_x*_size_y];
    static JButton _gameButton, _saveErrors,_undoButton;
    static int _score=0,_error=0;
    public static File file;
    static FileReader rf;
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

    //static final Timer[] timer4 = new Timer[1];
    public Main(){
        super("Memory training"); //Заголовок окна
        setResizable(false);

        _gameButton = new MyBytton("");
        _gameButton.setBackground(Color.WHITE);
        _gameButton.setPreferredSize(new Dimension(30,30));

        font= new Font("Verdana", Font.PLAIN, 11);
        font2 = new Font("Verdana", Font.PLAIN, 4);
        ImageIcon icon = new ImageIcon("src/com/company/Icons/iconGame.png");
        setIconImage(icon.getImage());
        _mainFrame=this;

        DialogClass dialogClass = new DialogClass(this, _isWon,"Настройки игры");
        dialogClass.setVisible(true);
        if (_size_x * _sizeSquare_x > 330) {
            setBounds(0, 0, _size_x*_sizeSquare_x,_size_y*_sizeSquare_y+90 );
        }
        else setBounds(0, 0, 330, _size_y*_sizeSquare_y+90);

        _container = getContentPane();
        _container.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

        _emptyLabel = JLabel(_emptyLabel,"DMG Group.2018 recon.97@mail.ru 0.2v.",4,250,30);
        _scoreLabel = JLabel(_scoreLabel,": "+_score,0,70,30);
        _errorLabel = JLabel(_errorLabel,": "+_error,0,70,30);
        _timeLabel = JLabel(_timeLabel,"Время: ",0,100,30);

        _gameButton.setFont(font);
        ImageIcon iconShuffle = new ImageIcon("src/com/company/Icons/shuffle.png");
        ImageIcon iconUndo = new ImageIcon("src/com/company/Icons/undo.png");
        ImageIcon iconSave = new ImageIcon("src/com/company/Icons/save1.png");
        ImageIcon iconCheck = new ImageIcon("src/com/company/Icons/check.png");
        ImageIcon iconError = new ImageIcon("src/com/company/Icons/error.png");
        _gameButton.setIcon(iconShuffle);
        _scoreLabel.setIcon(iconCheck);
        _errorLabel.setIcon(iconError);



        _undoButton = JButton(_undoButton,"",30,30);
        _undoButton.setFont(font);
        _undoButton.addActionListener(undoAction);
        _undoButton.setEnabled(_isEnabledUndo);
        _undoButton.setIcon(iconUndo);

        if(_startWithRandomisize)_gameButton.setEnabled(false);
        _saveErrors = JButton(_saveErrors,"",30,30);
        _saveErrors.setFont(font);
        _saveErrors.addActionListener(addPairsToErrorLists);
        _saveErrors.setIcon(iconSave);

        _gameButton.setToolTipText("Перемешать ячейки");
        /*_saveErrors.setToolTipText("Сохранить ошибки");
        _undoButton.setToolTipText("Отменить последнее действие");

        _scoreLabel.setToolTipText("Очки");
        _errorLabel.setToolTipText("Ошибки");*/

        _gameButton.setFocusPainted(false);
        _saveErrors.setFocusPainted(false);
        _undoButton.setFocusPainted(false);

        _gameButton.addActionListener(delayBeforeLoad);
        JPanel panelInfo = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
        JPanel panelEmail = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));

        panelInfo.add(_gameButton);
        panelInfo.add(_saveErrors);
        panelInfo.add(_undoButton);
        panelInfo.add(_scoreLabel);
        panelInfo.add(_errorLabel);
        panelInfo.add(_timeLabel);
        panelEmail.add(_emptyLabel);
        _container.add(panelInfo);
        _container.add(panelButton);
        _container.add(panelEmail);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        app = new Main();
        app.setVisible(true);

    }

}

