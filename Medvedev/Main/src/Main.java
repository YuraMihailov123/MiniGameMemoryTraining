import java.net.URL;
import  java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class MyFrame extends JFrame {

    MyFrame(int a, int b) {
        setTitle("Mini Game developed by DMG ");
        MyPanel panel = new MyPanel();
        setResizable(false);
        setBounds(400, 0, 650, 680);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(a, b); //положение окна
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        add(panel); //добавление панели
        setVisible(true); //Отображение окна
    }
}

class MyPanel extends JPanel { //класс панели
    MyPanel() {
        final boolean[] isFirst = {false};
        JButton[] buttons = new JButton[64]; //("Создать новое окно");
        for (int i = 0; i < 64; i++) {
            buttons[i] = new JButton();
        }
        for (int i = 0; i < 64; i++) {
            buttons[i].setText("");
            add(buttons[i]); //добавление кнопки на панель
            buttons[i].setBackground(Color.green);
            buttons[i].setPreferredSize(new Dimension(80, 80));
        }
        for (int i = 0; i < 64; i++) {
            int a = i;
            buttons[a].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {  //окрашивание кнопки в желтый цвет
                    if (!isFirst[0]) {
                        isFirst[0] = !isFirst[0];
                        buttons[a].setBackground(Color.YELLOW);

                    } else if (isFirst[0]) {
                        isFirst[0] = !isFirst[0];

                    }
                }
            });
        }
    }

}

class Main {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame(100, 100);
    }
}
