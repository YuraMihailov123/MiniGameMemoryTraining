package com.company;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import static com.company.ActionListenersClass.*;
import static com.company.InitializeClass.*;


public class Main extends JFrame{
    /*
    -бледно-голубой
    -отмена глубина 1
    -загрузка с 2-х списков ошибок после завершения
    -путь до файла
    -справка по игре
    -перемешевание пар до загрузки
    ---{-размеры окон и ячеек!!!, получение размеров экрана и рекомендуемые значения!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    -размеры ячейки по ширине не меньше !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    -ключи}---

    -сохранить ошибки кнопкой после завершения урока
    -[устранить дубликаты из списка ошибок!!-на финал-версию]
    */
    static Main app;
    static String[] _pairs;
    static JFrame _mainFrame;
    static String[] _baseLanguageWords;
    //static String[] _baseLanguageWords2;
    static int _buttonPressedNumber, _iterator =0,_countPairs=0, _buttonNumberBackToWhite;
    static boolean _isFirst =false,_isGaming=false,_startWithRandomisize=false, _isWon =false,_isRestatr=false;
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


        //Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //System.out.println(ScreenSize.width+"-x-"+ScreenSize.height);
        font= new Font("Verdana", Font.PLAIN, 11);
        font2 = new Font("Verdana", Font.PLAIN, 4);
        ImageIcon icon = new ImageIcon("src/com/company/iconGame.png");
        setIconImage(icon.getImage());
        _mainFrame=this;
        DialogClass dialogClass = new DialogClass(this, _isWon,"Настройки игры");
        dialogClass.setVisible(true);
        if (_size_x * _sizeSquare_x > 260) {
            setBounds(0, 0, _size_x*_sizeSquare_x,_size_y*_sizeSquare_y+90 );
        }
        else setBounds(0, 0, 260, _size_y*_sizeSquare_y+90);

        //panelButton.repaint();
        System.out.println(getBounds());
        //_baseLanguageWords2 = new String[_size_x*_size_y/2];
        _container = getContentPane();
        _container.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

        _emptyLabel = JLabel(_emptyLabel,"DMG Group.2018 recon.97@mail.ru 0.2v.",4,250,30);
        _scoreLabel = JLabel(_scoreLabel,"+: "+_score,0,50,30);
        _errorLabel = JLabel(_errorLabel,"-: "+_error,0,50,30);
        _timeLabel = JLabel(_timeLabel,"Время: ",0,100,30);

        _gameButton = JButton(_gameButton,"Перемешать",30,30);
        _gameButton.setFont(font);

        if(_startWithRandomisize)_gameButton.setEnabled(false);
        _saveErrors = JButton(_saveErrors,"Сохранить ошибки",30,30);
        _saveErrors.setFont(font);
        _saveErrors.addActionListener(addPairsToErrorLists);

        _gameButton.addActionListener(delayBeforeLoad);
        JPanel panelInfo = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
        JPanel panelEmail = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));

        panelInfo.add(_gameButton);
        panelInfo.add(_saveErrors);
        panelInfo.add(_scoreLabel);
        panelInfo.add(_errorLabel);
        panelInfo.add(_timeLabel);
        panelEmail.add(_emptyLabel);
        _container.add(panelInfo);
        _container.add(panelButton);
        _container.add(panelEmail);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //public static void DeleteApp(){
    //    app
    //}




    public static void main(String[] args) {
        /*try {
            URL url = new URL("https://translate.yandex.ru/?lang=en-ru&text=word");
            try {
                LineNumberReader reader = new LineNumberReader(new InputStreamReader(url.openStream()));
                String string = reader.readLine();
                while(string!=null){
                    System.out.println(string);
                    string = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (MalformedURLException ex){
            ex.printStackTrace();
        }*/

        app = new Main();
        app.setVisible(true);

    }

}
