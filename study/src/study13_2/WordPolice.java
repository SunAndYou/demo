package study13_2;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class WordPolice implements ActionListener {
    JTextField showText;
    HashMap<String, String> hashtable;
    File file = new File("H:\\Users\\1\\IdeaProjects\\ssp_basic01\\study\\src\\study13_2\\word.txt");
    //File file = new File("H:\\Users\\1\\IdeaProjects\\ssp_basic01\\study\\src\\study13_2\\JapaneseWord.txt");
    Scanner sc = null;

    WordPolice() {
        hashtable = new HashMap<String, String>();
        try {
            sc = new Scanner(file);
            while (sc.hasNext()) {
                String englishWord = sc.next();
                String chineseWord = sc.next();
                hashtable.put(englishWord, chineseWord);
            }
        } catch (Exception e) {
        }
    }

    public void setJTextField(JTextField showText) {

        this.showText = showText;
    }

    public void actionPerformed(ActionEvent e) {
        String englishWord = e.getActionCommand();
        if (hashtable.containsKey(englishWord)) {
            String chineseWord = hashtable.get(englishWord);
            showText.setText(chineseWord);
        } else {
            showText.setText("没有此单词...");
        }
    }
}