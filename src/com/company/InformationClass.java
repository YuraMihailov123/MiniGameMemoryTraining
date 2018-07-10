package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformationClass extends JDialog {
    public  InformationClass(JDialog owner) {
        super(owner,"Справка");
        setBounds(600, 100, 460, 720);
        //setLayout(new FlowLayout(FlowLayout.LEFT));
        setLayout(new BorderLayout());
        setResizable(false);
        JPanel panel2 = new JPanel();
        JPanel panel1 = new JPanel();

        JLabel _label = new JLabel(
                "<html><br>Как начать игру:</br>" +
                        "<br></br>" +
                        "<br>-Выбрать входной файл с уроком</br>" +
                        "<br>-Установить настройки игрового поля</br>" +
                        "<br>-Нажать кнопку 'Загрузить уровень'</br>" +
                        "<br></br>" +
                        "<br>Требования настройки игры: </br>" +
                        "<br></br>"+
                        "<br>1. Поля не могут быть пустыми!</br> " +
                        "<br>2. Значения не могут быть равны 0!</br> " +
                        "<br>3. Размер поля должен быть кратен 2!</br> " +
                        "<br>4. Формат описания пар в файле:</br>" +
                        "<br>-Каждая строка файла описывает пару вида</br>" +
                        "<br><левая ячейка пары><знак табуляции><правая ячейка пары></br>" +
                        "<br>4. Формат входного файла должен быть сохранен в формате UTF-8.</br>" +
                        "<br></br>"+
                        "<br>Описание игры</br>"+
                        "<br></br>"+
                        "<br>На экране появляется поле, заполненное ячейками со словами из</br>"+
                        "<br>входного файла. Существует возможность начать игру с изначальным</br>"+
                        "<br>перемешиванием слов или с перемешиванием во время игры. </br>"+
                        "<br>В случае без перемешивания первая половина поля заполняется </br>"+
                        "<br>левыми ячейками пар входного файла, оставшаяся часть - </br>"+
                        "<br>правыми. Суть игры заключается в поиске верных соответствий между</br>"+
                        "<br>ячейками. При правильном выборе пары ячейки закрываются и</br>"+
                        "<br>окрашиваются в зелёный цвет и количество очков увеличивается на </br>"+
                        "<br>1, в противном случае выбранные ячейки окрашиваются в красный </br>"+
                        "<br>цвет и счётчик ошибок возрастает на 1. Также присутствует</br>"+
                        "<br>возможность сохранить допущенные во время игры ошибки для </br>"+
                        "<br>дальнейшей работы с ними.</br>"+
                        "</html>");


        JButton _closeButton = new JButton("Закрыть");
        _closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        _label.setForeground(Color.BLACK);
        //_label2.setForeground(Color.BLACK);
        //_label3.setForeground(Color.BLACK);

        panel2.add(_label, BorderLayout.CENTER);
        //panel2.add(_label2, BorderLayout.WEST);
        //panel2.add(_label3, BorderLayout.WEST);
        panel1.add(_closeButton,BorderLayout.SOUTH);
        add(panel2,BorderLayout.CENTER);
        add(panel1,BorderLayout.SOUTH);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    }
}
