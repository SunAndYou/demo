package study13_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Save extends JFrame implements ActionListener {
    JTextArea showArea, southArea;
    JTextField inputName, inputTime;
    JButton button, saveButton;
    TreeSet<Program> treeSet;

    Save() {
        treeSet = new TreeSet<Program>();
        showArea = new JTextArea();
        southArea = new JTextArea();
        showArea.setFont(new Font("", Font.BOLD, 20));
        inputName = new JTextField(5);
        inputTime = new JTextField(10);
        button = new JButton("确定");
        button.addActionListener(this::actionPerformed);

        saveButton = new JButton("保存");
        // 添加点击监听器
        saveButton.addActionListener(this::actionPerformed2);
        JPanel pNorth = new JPanel();
        pNorth.add(new JLabel("节目名称:"));
        pNorth.add(inputName);
        pNorth.add(new JLabel("时间(yyyy/mm/dd/hh:mm:ss)"));
        pNorth.add(inputTime);
        pNorth.add(button);
        pNorth.add(saveButton);

        add(pNorth, BorderLayout.NORTH);
        add(new JScrollPane(showArea), BorderLayout.CENTER);

        JPanel pSouth = new JPanel();
        pSouth.add(saveButton);
        add(pSouth, BorderLayout.SOUTH);
//        add(new JScrollPane(southArea),BorderLayout.CENTER);

        setSize(500, 320);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("执行第一个按钮");
        String name = inputName.getText();
        String time = inputTime.getText();
        StringTokenizer jiexi = new StringTokenizer(time, "/:");
        int year = Integer.parseInt(jiexi.nextToken());
        int month = Integer.parseInt(jiexi.nextToken());
        int day = Integer.parseInt(jiexi.nextToken());
        int hour = Integer.parseInt(jiexi.nextToken());
        int minute = Integer.parseInt(jiexi.nextToken());
        int second = Integer.parseInt(jiexi.nextToken());
        Program program = new Program(name, year, month, day, hour, minute, second);
        treeSet.add(program);
        show(treeSet);
    }

    public void actionPerformed2(ActionEvent e1) {
        System.out.println("点击了");
        File file = new File("progam.txt");
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
            Iterator<Program> te = treeSet.iterator();
            while (te.hasNext()) {
                Program pro = te.next();
                Date date = pro.getDate();
                SimpleDateFormat matter1 = new SimpleDateFormat(" yyyy/MM/dd/HH:mm:ss");
                String time = matter1.format(date);
                fos.write(new String(pro.getName() + "(演出时间):" + time + "\n").getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void show(TreeSet tree) {
        showArea.setText(null);
        Iterator<Program> te = treeSet.iterator();
        while (te.hasNext()) {
            Program pro = te.next();
            Date date = pro.getDate();
            SimpleDateFormat matter1 = new SimpleDateFormat(" yyyy/MM/dd/HH:mm:ss");
            String time = matter1.format(date);
            showArea.append(pro.getName() + "(演出时间):" + time + "\n");
        }
    }

}