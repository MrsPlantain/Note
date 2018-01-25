package org.note;

import org.listener.CloseActionListener;
import org.listener.OpenActionListener;
import org.listener.SaveActionListener;

import javax.swing.*;
import java.awt.*;

public class Note extends JFrame {

    public Note(String title) {
        setTitle(title);
        setLayout(new GridLayout(1, 1));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem open = new JMenuItem("open");
        JMenuItem save = new JMenuItem("save");
        JMenuItem close = new JMenuItem("close");
        menu.add(open);
        menu.add(save);
        menu.add(close);

        open.addActionListener(new OpenActionListener(this));
        save.addActionListener(new SaveActionListener(this));
        close.addActionListener(new CloseActionListener());

        setJMenuBar(menuBar);

        jTextPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(jTextPane);

        add(scrollPane);
        setSize(1000,500);

        setVisible(true);
    }

    private JTextPane jTextPane;

    public void init() {
        jTextPane.setText("");
    }

    public String getText() {
        return jTextPane.getText();
    }

    public void append(String str){
        jTextPane.setText(jTextPane.getText() + str);
    }


}
