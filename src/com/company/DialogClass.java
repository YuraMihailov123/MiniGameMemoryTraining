package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import static com.company.ActionListenersClass.addPairsToErrorLists;
import static com.company.ActionListenersClass.importWordsIntoGame;
import static com.company.AlgorithmClass.ActionButton;
import static com.company.InitializeClass.*;
import static com.company.Main.*;

class DialogClass extends JDialog {
    File file;

    JDialog thisFrame;
    public DialogClass(JFrame owner,boolean isWon,String str){
        super(owner,str,true);
        setBounds(700,200,260,200);
        thisFrame=this;
        if(!isWon) {
            //setResizable(false);
            ImageIcon iconUpload = new ImageIcon(Main.class.getResource("/com/company/Icons/load.png"));
            JTextField _numX = new JTextField();
            JTextField _numY = new JTextField();
            JTextField _numSquareY = new JTextField();
            JTextField _numSquareX = new JTextField();
            JCheckBox _checkBox = new JCheckBox();
            JPanel panel = new JPanel();
            JPanel panel2 = new JPanel();

            _numX.setPreferredSize(new Dimension(25, 20));
            _numY.setPreferredSize(new Dimension(25, 20));
            _numSquareX.setPreferredSize(new Dimension(25, 20));
            _numSquareY.setPreferredSize(new Dimension(25, 20));
            //add(new JLabel("Количество ячеек:"),BorderLayout.CENTER);
            JButton _openFile,_infoButton;
            JButton _loadLevel = new JButton("Загрузить уровень");
            _loadLevel.setEnabled(false);
            _openFile = new MyBytton("");
            _infoButton = new MyBytton("");
            _infoButton.setPreferredSize(new Dimension(30,30));
            _infoButton.setToolTipText("Справка");
            _openFile.setToolTipText("Указать путь к файлу");
            _openFile.setIcon(iconUpload);
            _openFile.setBackground(Color.WHITE);
            _openFile.setPreferredSize(new Dimension(30,30));
            _openFile.setFont(font);

            _sizeSquare_x=100;
            _sizeSquare_y=100;
            _size_x=6;
            _size_y=6;

            _numSquareX.setText("100");
            _numSquareY.setText("100");
            _numY.setText("6");
            _numX.setText("6");
            ImageIcon iconInfo = new ImageIcon(Main.class.getResource("/com/company/Icons/info.png"));
            _infoButton.setIcon(iconInfo);
            _infoButton.setBackground(Color.WHITE);
            _infoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    InformationClass info = new InformationClass(thisFrame);
                    info.setVisible(true);
                }
            });
            if(_path.equals(""))_loadLevel.setEnabled(false);
            else _loadLevel.setEnabled(true);
            _openFile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFileChooser fileopen = new JFileChooser();
                    //fileopen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                    int ret = fileopen.showDialog(null, "Выбрать файл");
                    if (ret == JFileChooser.APPROVE_OPTION){
                        file = fileopen.getSelectedFile();
                        System.out.println(file.getPath());
                        //fileopen.setCurrentDirectory(file);
                        //_path="";
                        if(file!=null){
                            _path=file.getPath();
                            _loadLevel.setEnabled(true);
                        }else {
                            _loadLevel.setEnabled(false);
                        }
                    }
                }
            });
            _loadLevel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

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
                            //rf = new FileReader("src/com/company/Data/file.txt");

                            FileInputStream fis = new FileInputStream(_path);
                            try {
                                rf = new InputStreamReader(fis,"UTF-8");
                            } catch (UnsupportedEncodingException e1) {
                                e1.printStackTrace();
                            }

                            scan = new Scanner(rf);
                            //if(_isSoundEnable)
                            //AudioClass.AudioClassCreateClick("click.wav");
                        } catch (FileNotFoundException e1) {
                            System.out.println("File not found!");
                        }
                        _buttons=new DrawButton[_size_x*_size_y];
                        _labels = new JLabel[_size_x*_size_y];
                        //_pairs = new String[_size_x*_size_y/2];
                        panelButton=new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
                        panelButton.setPreferredSize(new Dimension(_size_x*_sizeSquare_x,_size_y*_sizeSquare_y));
                        int fontSize = 11+_sizeSquare_y/20;
                        font= new Font("Verdana", Font.PLAIN, fontSize);
                        //InitializeButtons();
                        panelButton.revalidate();
                        panelButton.repaint();
                        InitializeButtons();
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
            panel.add(_openFile);
            panel.add(_loadLevel);
            panel.add(_infoButton);
            //panel.add(_numX);
            add(panel2, BorderLayout.CENTER);
            add(panel, BorderLayout.SOUTH);
        }else {
            JPanel panel = new JPanel();
            JPanel panel2 = new JPanel();
            JButton _restart = new JButton("Начать заново");
            JButton _saveErr = new JButton("Сохранить ошибки");
            JButton err1,err2,errCom;
            err1=new JButton("1");
            err2=new JButton("2");
            errCom=new JButton("Оба");
            _saveErr.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileopen = new JFileChooser();
                    fileopen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    fileopen.setCurrentDirectory(new File("/src/company"));
                    int ret = fileopen.showDialog(null, "Указать директорию");
                    if (ret == JFileChooser.APPROVE_OPTION){
                        file = fileopen.getSelectedFile();
                        System.out.println(file.getPath());
                        _workingPath=file.getPath();
                        if(_workingPath.equals("")){
                            err1.setEnabled(false);
                            err2.setEnabled(false);
                            errCom.setEnabled(false);
                        }else {
                            err1.setEnabled(true);
                            err2.setEnabled(true);
                            errCom.setEnabled(true);
                        }
                    }
                    try {
                        //if(_error>0) {

                            outfile1 = new FileWriter(_workingPath+"/error_list1.txt", true);
                            outfile2 = new FileWriter(_workingPath+"/error_list2.txt", true);
                            outfile3 = new FileWriter(_workingPath+"/error_list_common.txt", true);

                            for (int i = 0; i < _error_1.size(); i++) {
                                outfile1.write(_error_1.get(i) + "\n");
                                outfile1.flush();

                                outfile3.write(_error_1.get(i)+"\n");
                                outfile3.flush();

                                outfile2.write(_error_2.get(i)+ "\n");
                                outfile2.flush();

                                outfile3.write(_error_2.get(i)+"\n");
                                outfile3.flush();

                            }
                            //File file=new File("src/com/company/Data/error_list3.txt");
                            //   file.delete();
                            _error_1.clear();
                            _error_2.clear();
                        //}
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            _saveErr.setPreferredSize(new Dimension(100,30));
            _restart.setPreferredSize(new Dimension(100,30));
            _restart.setFocusPainted(false);
            _saveErr.setFocusPainted(false);
            if(_workingPath.equals("")){
                err1.setEnabled(false);
                err2.setEnabled(false);
                errCom.setEnabled(false);
            }else {
                err1.setEnabled(true);
                err2.setEnabled(true);
                errCom.setEnabled(true);
            }
            err1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    _path=_workingPath+"/error_list1.txt";
                    app.dispose();
                    DeleteData();
                    app =new Main();
                    app.setVisible(true);
                }
            });
            err2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    _path=_workingPath+"/error_list2.txt";
                    app.dispose();
                    DeleteData();
                    app =new Main();
                    app.setVisible(true);
                }
            });
            errCom.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    _path=_workingPath+"/error_list_common.txt";
                    app.dispose();
                    DeleteData();
                    app =new Main();
                    app.setVisible(true);
                }
            });
            panel.add(new JLabel("Урок завершен!"));
            panel.add(new JLabel("Загрузить урок с файла ошибок:          "));
            panel.add(err1);
            panel.add(err2);
            panel.add(errCom);
            panel2.setLayout(new GridLayout(2,1));
            panel2.add(_saveErr);
            panel2.add(_restart);
            add(panel,BorderLayout.CENTER);
            add(panel2,BorderLayout.SOUTH);
            ActionListener _newGame = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    app.dispose();
                    DeleteData();
                    app =new Main();
                    app.setVisible(true);
                }
            };
            _restart.addActionListener(_newGame);
        }
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
