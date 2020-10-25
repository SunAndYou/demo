package study13_2;

import java.awt.*;
import javax.swing.*;

public class WindowWord extends JFrame {
    JTextField inputText, showText;
    WordPolice police; //监视器

    WindowWord() {
        setLayout(new FlowLayout());
        inputText = new JTextField(8);
        showText = new JTextField(18);
        add(inputText);
        add(showText);
        police = new WordPolice();
        police.setJTextField(showText);
        inputText.addActionListener(police);
        setBounds(100, 100, 400, 280);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
