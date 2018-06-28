package com.company;
import  java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Main extends JFrame{

    //private String[][] _words;
    private int _buttonPressedNumber;
    boolean isFirst=false;
    private JLabel _devLabel,_emptyLabel;
    private JButton[] _buttons=new JButton[64];
    private JButton _gameButton,_alphabetButton,_startButton;
    private  File file;
    //private JLayeredPane lpane;
    private Main(){
        super("Memory training"); //Заголовок окна
        setResizable(false);
        setBounds(400, 0, 806, 880);

        /*String path = "icon.jpg";
        URL imgUrl = Main.class.getResource(path);
        //icon = Toolkit.getDefaultToolkit().getImage("com.company/icon.jpg");
        ImageIcon icon = new ImageIcon(imgUrl);
        */
        //lpane=new JLayeredPane();

        Container _container = getContentPane();
        _container.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));


        _devLabel = new JLabel("DMG Group. 2018. recon.97@mail.ru -beta 0.1v.");
        _devLabel.setHorizontalAlignment(JLabel.LEADING);
        _emptyLabel = new JLabel();
        _gameButton=new JButton("Игра");
        _alphabetButton=new JButton("Алфавит");
        _devLabel.setPreferredSize(new Dimension(800,20));
        _gameButton.setPreferredSize(new Dimension(100,30));
        _alphabetButton.setPreferredSize(new Dimension(100,30));
        _emptyLabel.setPreferredSize(new Dimension(600,30));
        _gameButton.setBackground(Color.WHITE);
        _alphabetButton.setBackground(Color.WHITE);
        _container.add(_devLabel);
        _container.add(_gameButton);
        _container.add(_alphabetButton);
        _container.add(_emptyLabel);

        /*_gameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i <64 ; i++) {
                    _buttons[i].setText("i");
                    try {
                        wait(1);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    /*try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });*/

        for (int i = 0; i < 64; i++) {
            //char a = i
            _buttons[i]=new JButton("");
            _buttons[i].setBackground(Color.WHITE);
            _buttons[i].setPreferredSize(new Dimension(100,100));
            _container.add(_buttons[i]);
        }
        //_buttons[0]=_buttons[31];
        for (int i = 0; i < 64; i++) {
            int finalI = i;
            _buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(!isFirst) {
                        isFirst = !isFirst;
                        _buttonPressedNumber=finalI;
                        _buttons[finalI].setBackground(Color.YELLOW);
                    }else if(isFirst && _buttonPressedNumber!=finalI){

                        isFirst=!isFirst;
                    }else if(_buttonPressedNumber==finalI) {
                        isFirst=!isFirst;
                    }


                }
            });
        }

        GenerateLevel();
        //_buttons[0]=_buttons[32];

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void GenerateLevel(){
        try{
            OpenFile();

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

    }

    public void OpenFile()  throws FileNotFoundException {
        int i=0;
        String temp1,temp2;
        FileReader rf = new FileReader("src/com/company/file.txt");
        Scanner scan = new Scanner(rf);
        String str="";
        str = scan.nextLine();
        //for (int i = 0; i < 32; i++) {
        while(scan.hasNextLine() && i<32){
            temp1="";
            temp2="";
            int _temp = SubStringOnParts(str);
            temp1 = str.substring(0, _temp);
            _buttons[i].setText(temp1);
            temp2 = str.substring(_temp + 1);
            _buttons[i+32].setText(temp2);

            str = scan.nextLine();
            //System.out.println(scan.hasNextLine());
            i++;

        }
        //rf.close();
    }

    int SubStringOnParts(String str){
        //String temp="";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==' '){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        Main app = new Main(); //Создаем экземпляр нашего приложения
        app.setVisible(true);

    }

}
