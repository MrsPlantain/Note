package org.listener;

import org.note.Note;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OpenActionListener implements ActionListener {

    private Note jFrame;

    public OpenActionListener(Note jFrame) {
        this.jFrame = jFrame;
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int action = fileChooser.showOpenDialog(jFrame);
        switch (action) {
            case JFileChooser.APPROVE_OPTION:
                File file = fileChooser.getSelectedFile();
                jFrame.init();
                jFrame.setTitle("Note - " + file.getName());
                try {
                    Scanner scanner = new Scanner(new FileInputStream(file));
                    while (scanner.hasNext()) {
                        jFrame.append(scanner.nextLine());
                        jFrame.append("\r\n");
                    }
                    scanner.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                break;
            case JFileChooser.CANCEL_OPTION:
                break;
            default:
                break;
        }
    }
}
